package com.microservice.microservice_usuario.apadaters.driven.persistencejpa.service;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.mapper.entity.UserEntityMapper;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.repository.UserRepository;
import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.ports.spi.StudentPersistencePort;

public class StudentJpaPersistencePort implements StudentPersistencePort {

    private final UserRepository userRepository;

    private final UserEntityMapper userEntityMapper;

    public StudentJpaPersistencePort(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public void createStudent(UserModel user) {
        this.userRepository.save(this.userEntityMapper.toEntity(user));
    }
}
