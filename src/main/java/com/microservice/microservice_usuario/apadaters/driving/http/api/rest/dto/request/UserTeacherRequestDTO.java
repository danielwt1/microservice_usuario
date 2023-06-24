package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@Schema(description = "DTO que permite la creacion de un usuario de tipo PROFESOR",
        name = "UserTeacherRequestDTO")
public class UserTeacherRequestDTO {
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 20)
    @Schema(description = "Es el nombre de la persona",
            example = "DANIEL DAVID")
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+){0,2}$", message = "El nombre solo puede contener letras")
    private String name;
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 20)
    @Schema(description = "Es el apellido de la persona",
            example = "Ramos Garcia")
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+){0,2}$", message = "El nombre solo puede contener letras")
    private String lastName;
    @Email
    @NotEmpty
    @NotNull
    @Schema(description = "Es el correo de la persona",
            example = "correo@gmail.com")
    private String email;
    @NotEmpty
    @NotNull
    @Size(min = 8, max = 20)
    @Schema(description = "Es la password del sistema de la persona",
            example = "password")
    private String password;
    @NotEmpty
    @NotNull
    @Pattern(regexp = "^[0-9]+$",message = "El codigo debe ser un numero")
    @Size(min = 8, max = 15)
    @Schema(description = "Es el codigo de la persona",
            example = "123456789")
    private String code;
}
