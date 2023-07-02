package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.impl;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserDirectorRequestDTO;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.mappers.dto.DirectorModelMapper;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.DirectorService;
import com.microservice.microservice_usuario.domain.ports.api.DirectorProgramServicePort;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorProgramServicePort directorProgramServicePort;

    private final DirectorModelMapper directorModelMapper;

    public DirectorServiceImpl(DirectorProgramServicePort directorProgramServicePort, DirectorModelMapper directorModelMapper) {
        this.directorProgramServicePort = directorProgramServicePort;
        this.directorModelMapper = directorModelMapper;
    }

    @Override
    public void createDirector(UserDirectorRequestDTO userDirectorRequestDTO) {
        this.directorProgramServicePort.createDirector(
                this.directorModelMapper.toModel(userDirectorRequestDTO));
    }
}
