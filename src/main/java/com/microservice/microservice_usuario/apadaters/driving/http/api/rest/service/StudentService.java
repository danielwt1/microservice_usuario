package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserStudentRequestDto;

public interface StudentService {
    void createStudent(UserStudentRequestDto userStudentRequestDto);
}
