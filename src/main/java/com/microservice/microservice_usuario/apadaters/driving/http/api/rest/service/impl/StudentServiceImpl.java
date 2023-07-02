package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.impl;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserStudentRequestDto;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.mappers.dto.StudentModelMapper;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.StudentService;
import com.microservice.microservice_usuario.domain.ports.api.StudentServicePort;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentServicePort studentServicePort;
    private final StudentModelMapper studentModelMapper;

    public StudentServiceImpl(StudentServicePort studentServicePort, StudentModelMapper studentModelMapper) {
        this.studentServicePort = studentServicePort;
        this.studentModelMapper = studentModelMapper;
    }

    @Override
    public void createStudent(UserStudentRequestDto userStudentRequestDto) {
        studentServicePort.createStudent(this.studentModelMapper.toModel(userStudentRequestDto));
    }
}
