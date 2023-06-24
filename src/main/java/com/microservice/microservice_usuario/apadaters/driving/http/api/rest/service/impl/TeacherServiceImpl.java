package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.impl;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserTeacherRequestDTO;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.mappers.dto.UserModelMapper;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.TeacherService;
import com.microservice.microservice_usuario.domain.ports.api.TeacherServicePort;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherServicePort teacherServicePort;
    private final UserModelMapper userModelMapper;

    public TeacherServiceImpl(TeacherServicePort teacherServicePort, UserModelMapper userModelMapper) {
        this.teacherServicePort = teacherServicePort;
        this.userModelMapper = userModelMapper;
    }

    @Override
    public void createTeacher(UserTeacherRequestDTO teacher) {
        this.teacherServicePort.createTeacher(this.userModelMapper.toModel(teacher));
    }
}
