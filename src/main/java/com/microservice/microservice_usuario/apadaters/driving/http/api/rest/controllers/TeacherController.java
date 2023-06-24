package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.controllers;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserTeacherRequestDTO;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.TeacherService;
import com.microservice.microservice_usuario.exceptionhandler.response.ErrorDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @Operation(summary = "Le permite  a un Director de programa crear un Usuario de tipo PROFESOR",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Se creo un usuario de tipo PROFESOR correctamente"),

                    @ApiResponse(responseCode = "500", description = "A business logic error occurred",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "401", description = "El usario no esta authenticado, o el token esta incorrecto ",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class)))
            }
    )
    @PostMapping("")
    public ResponseEntity<Void> createTeacher(@Valid @RequestBody UserTeacherRequestDTO teacherDTO) {
        this.teacherService.createTeacher(teacherDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
