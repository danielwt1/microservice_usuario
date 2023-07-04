package com.microservice.microservice_usuario.configuration.security;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.entity.UserEntity;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Clase S2
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public JwtUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        String role = user.getUserType().getName();
        roles.add(new SimpleGrantedAuthority(role));

        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getIdUser()), user.getPassword(), roles);
    }
}
