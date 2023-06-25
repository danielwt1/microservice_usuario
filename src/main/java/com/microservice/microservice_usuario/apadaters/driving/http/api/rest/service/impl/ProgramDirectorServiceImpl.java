package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.impl;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserTeacherRequestDTO;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.mappers.dto.UserModelMapper;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.ProgramDirectorService;
import com.microservice.microservice_usuario.domain.ports.api.ProgramDirectorServicePort;
import org.springframework.stereotype.Service;

@Service
public class ProgramDirectorServiceImpl implements ProgramDirectorService {

    private final ProgramDirectorServicePort programDirectorServicePort;
    private final UserModelMapper userModelMapper;

    public ProgramDirectorServiceImpl(ProgramDirectorServicePort programDirectorServicePort, UserModelMapper userModelMapper) {
        this.programDirectorServicePort = programDirectorServicePort;
        this.userModelMapper = userModelMapper;
    }

    @Override
    public void createTeacher(UserTeacherRequestDTO teacher) {
        this.programDirectorServicePort.createTeacher(this.userModelMapper.toModel(teacher));
    }
}
