package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.impl;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserTeacherRequestDTO;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.mappers.dto.TeacheModelMapper;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.ProgramDirectorService;
import com.microservice.microservice_usuario.domain.ports.api.TeacherServicePort;
import org.springframework.stereotype.Service;

@Service
public class ProgramDirectorServiceImpl implements ProgramDirectorService {

    private final TeacherServicePort teacherServicePort;
    private final TeacheModelMapper teacheModelMapper;

    public ProgramDirectorServiceImpl(TeacherServicePort teacherServicePort, TeacheModelMapper teacheModelMapper) {
        this.teacherServicePort = teacherServicePort;
        this.teacheModelMapper = teacheModelMapper;
    }

    @Override
    public void createTeacher(UserTeacherRequestDTO teacher) {
        this.teacherServicePort.createTeacher(this.teacheModelMapper.toModel(teacher));
    }
}
