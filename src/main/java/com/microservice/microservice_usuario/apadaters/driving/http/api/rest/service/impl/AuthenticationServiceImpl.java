package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.impl;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.exceptions.AuthenticationException;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.AuthenticationService;
import com.microservice.microservice_usuario.configuration.security.JwtRequest;
import com.microservice.microservice_usuario.configuration.security.JwtResponse;
import com.microservice.microservice_usuario.configuration.security.JwtTokenUtil;
import com.microservice.microservice_usuario.configuration.security.JwtUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public JwtResponse login(JwtRequest request) throws AuthenticationException {
        authenticate(request.getEmail(), request.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);
        return new JwtResponse(token);
    }
    private void authenticate(String username, String password) throws AuthenticationException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException(String.format("USER_DISABLED: %s", e.getMessage()));
        } catch (BadCredentialsException e) {
            throw new AuthenticationException(String.format("INVALID_CREDENTIALS: %s ", e.getMessage()));
        }
    }
}
