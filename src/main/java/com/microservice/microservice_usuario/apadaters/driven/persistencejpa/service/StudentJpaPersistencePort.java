package com.microservice.microservice_usuario.apadaters.driven.persistencejpa.service;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.mapper.entity.UserEntityMapper;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.repository.UserRepository;
import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.ports.spi.StudentPersistencePort;
import org.springframework.security.crypto.password.PasswordEncoder;

public class StudentJpaPersistencePort implements StudentPersistencePort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    public StudentJpaPersistencePort(UserRepository userRepository, UserEntityMapper userEntityMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createStudent(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(this.userEntityMapper.toEntity(user));
    }
}
