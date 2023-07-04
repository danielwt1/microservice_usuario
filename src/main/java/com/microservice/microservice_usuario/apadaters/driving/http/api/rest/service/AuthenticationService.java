package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.exceptions.AuthenticationException;
import com.microservice.microservice_usuario.configuration.security.JwtRequest;
import com.microservice.microservice_usuario.configuration.security.JwtResponse;

public interface AuthenticationService {
    JwtResponse login(JwtRequest request) throws AuthenticationException;


}
