package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@Schema(description = "DTO que permite la creacion de un usuario de tipo ALUMNO",
        name = "UserStudentRequestDto")
public class UserStudentRequestDto {

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+){0,2}$", message = "El nombre solo puede contener letras")
    @Schema(description = "Es el nombre del estudiante",
            example = "David Jose")
    private String name;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+){0,2}$", message = "El apellido solo puede contener letras")
    @Schema(description = "Es el apellido del estudiante",
            example = "Garces Conde")
    private String lastName;

    @NotEmpty
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El correo no es valido")
    @Schema(description = "Es el correo del estudiante",
            example = "d@d.com")
    private String email;

    @NotEmpty
    @NotNull
    @Size(min = 8, max = 20)
    @Schema(description = "Es la password del sistema del estudiantes",
            example = "password")
    private String password;

    @NotEmpty
    @NotNull
    @Size(min = 8, max = 10)
    @Pattern(regexp = "^[0-9]+$",message = "El codigo debe ser un numero")
    @Schema(description = "Es el codigo del estudiante",
            example = "20210920")
    private String code;
}
