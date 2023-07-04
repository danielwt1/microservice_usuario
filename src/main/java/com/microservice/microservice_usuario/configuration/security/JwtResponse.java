package com.microservice.microservice_usuario.configuration.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

//Clase S4
@Getter
@AllArgsConstructor
public class JwtResponse {

    private final String jwtToken;

}
