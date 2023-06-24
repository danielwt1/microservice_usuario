package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class UserTeacherRequestDTO {
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+){0,2}$", message = "El nombre solo puede contener letras")
    private String name;
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-Z]+(\\s[a-zA-Z]+){0,2}$", message = "El nombre solo puede contener letras")
    private String lastName;
    @Email
    @NotEmpty
    @NotNull
    private String email;
    @NotEmpty
    @NotNull
    @Size(min = 8, max = 20)
    private String password;
    @NotEmpty
    @NotNull
    @Pattern(regexp = "^[0-9]+$",message = "El codigo debe ser un numero")
    @Size(min = 8, max = 15)
    private String code;
}
