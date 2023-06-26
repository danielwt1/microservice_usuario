package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@Schema(description = "DTO que permite la creacion de un usuario de tipo ESTUDIANTE",
        name = "UserStudentRequestDto")
public class UserStudentRequestDto {

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+){0,2}$", message = "El nombre solo puede contener letras")
    @Schema(description = "Es el nombre de la persona",
            example = "David Jose")
    private String name;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+){0,2}$", message = "El apellido solo puede contener letras")
    private String lastName;

    @NotEmpty
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.([a-zA-Z]{2,4})+$", message = "El correo no es valido")
    private String email;

    @NotEmpty
    @NotNull
    @Size(min = 8, max = 10)
    @Pattern(regexp = "^[0-9]+$",message = "El codigo debe ser un numero")
    private String code;
}
