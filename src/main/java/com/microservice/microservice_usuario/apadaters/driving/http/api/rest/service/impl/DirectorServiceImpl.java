package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.impl;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserDirectorRequestDTO;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.mappers.dto.DirectorModelMapper;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.service.DirectorService;
import com.microservice.microservice_usuario.domain.ports.api.DirectorServicePort;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorServicePort directorServicePort;

    private final DirectorModelMapper directorModelMapper;

    public DirectorServiceImpl(DirectorServicePort directorServicePort, DirectorModelMapper directorModelMapper) {
        this.directorServicePort = directorServicePort;
        this.directorModelMapper = directorModelMapper;
    }

    @Override
    public void createDirector(UserDirectorRequestDTO userDirectorRequestDTO) {
        this.directorServicePort.createDirector(
                this.directorModelMapper.toModel(userDirectorRequestDTO));
    }
}
