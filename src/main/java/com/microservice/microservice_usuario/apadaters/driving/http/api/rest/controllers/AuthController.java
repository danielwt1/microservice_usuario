package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.controllers;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.exceptions.AuthenticationException;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.AuthenticationService;
import com.microservice.microservice_usuario.configuration.security.JwtRequest;
import com.microservice.microservice_usuario.configuration.security.JwtResponse;
import com.microservice.microservice_usuario.exceptionhandler.response.ErrorDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@RequestMapping("/login")
@Tag(name = "Login",description = "Enpoint para logeo")
public class AuthController {
    private final AuthenticationService authService;

    public AuthController(AuthenticationService authService) {
        this.authService = authService;
    }
    @Operation(summary = "Permite Logearse y generar Token",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Token JWT",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = JwtResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request de la solicitud",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "500", description = "A business logic error occurred",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "401", description = "El usario no esta authenticado, o el token esta incorrecto ",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class)))
            }
    )
    @PostMapping
    public ResponseEntity<JwtResponse>login(@Valid @RequestBody JwtRequest request) throws AuthenticationException {
        JwtResponse response = this.authService.login(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
