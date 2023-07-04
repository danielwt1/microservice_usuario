package com.microservice.microservice_usuario.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Clase S1
@Component
public class JwtTokenUtil implements Serializable {

    //milisegundos
    public final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000; //5 horas

    @Value("${jwt.secret}") //EL Expression Language
    private String secret;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(getKey())
                .compact();
    }
    private Key getKey() {
        byte[] keyBytes = secret.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    public List<String> getRolesFromToken(String token) {
        return getClaimFromToken(token, claim -> {
            List<?> rolesObject = claim.get("roles", List.class);
            if (rolesObject != null) {
                return rolesObject.stream()
                        .filter(String.class::isInstance)
                        .map(String::valueOf)

                        //.map(role -> role.substring(5))
                        .collect(Collectors.toList());

            }
            return Collections.emptyList();
        });
    }

    public String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public boolean validateToken(String token, String userFromHeader) {
        final String username = getUsernameFromToken(token);
        return (username.equalsIgnoreCase(userFromHeader) && !isTokenExpired(token));
    }
    public String getTokenFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

}
