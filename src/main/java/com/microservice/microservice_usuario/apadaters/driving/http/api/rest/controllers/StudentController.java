package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.controllers;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserStudentRequestDto;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.StudentService;
import com.microservice.microservice_usuario.exceptionhandler.response.ErrorDetails;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Le permite a un usuario registrarse como tipo ESTUDIANTE",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Se creo un usuario de tipo ESTUDIANTE correctamente"),

                    @ApiResponse(responseCode = "500", description = "Error en el servidor",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class))),
                    @ApiResponse(responseCode = "401", description = "El usario no esta autenticado, o el token esta incorrecto ",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = ErrorDetails.class)))
            }
    )
    @PostMapping("")
    public ResponseEntity<Void> createStudent(@Valid @RequestBody UserStudentRequestDto userStudentRequestDto) {
        this.studentService.createStudent(userStudentRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
