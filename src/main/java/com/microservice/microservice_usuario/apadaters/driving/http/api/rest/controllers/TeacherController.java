package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.controllers;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserTeacherRequestDTO;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.TeacherService;
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

    @PostMapping("")
    public ResponseEntity<Void> createTeacher(@Valid @RequestBody UserTeacherRequestDTO teacherDTO) {
        this.teacherService.createTeacher(teacherDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
