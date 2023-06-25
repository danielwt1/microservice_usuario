package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserTeacherRequestDTO;

public interface ProgramDirectorService {

    void createTeacher(UserTeacherRequestDTO teacher);
}
