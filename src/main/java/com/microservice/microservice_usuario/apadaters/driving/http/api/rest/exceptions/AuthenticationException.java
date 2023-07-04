package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.exceptions;

public class AuthenticationException  extends RuntimeException{
    public AuthenticationException(String message) {
        super(message);
    }
}