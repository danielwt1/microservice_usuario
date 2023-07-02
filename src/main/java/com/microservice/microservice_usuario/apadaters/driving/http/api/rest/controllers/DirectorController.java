package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.controllers;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserDirectorRequestDTO;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/director")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Operation(summary = "Le permite a un usuario registrarse como tipo DIRECTOR",
            responses = {
                    @ApiResponse(responseCode = "201",
                            description = "Se creo un usuario de tipo DIRECTOR correctamente"),
                    @ApiResponse(responseCode = "500",
                            description = "Error en el servidor",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = Exception.class))),
                    @ApiResponse(responseCode = "401",
                            description = "El usario no esta autenticado, o el token esta incorrecto ",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "object", implementation = Exception.class)))
            }
    )
    @PostMapping("")
    public ResponseEntity<Void> createDirector(@Valid @RequestBody UserDirectorRequestDTO userDirectorRequestDTO) {
        this.directorService.createDirector(userDirectorRequestDTO);
        return ResponseEntity.ok().build();
    }
}
