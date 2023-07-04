package com.microservice.microservice_usuario.configuration.security;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

//Clase S3
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO request para logeo",
        name = "JwtRequest")
public class JwtRequest implements Serializable {
    @Email
    @Schema(description = "Email del usuario",example = "correo@email.com")
    private String email;
    @NotBlank
    @Schema(description = "Contraseña del usuario",example = "contraseña")
    private String password;

}

