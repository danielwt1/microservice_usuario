package com.microservice.microservice_usuario.configuration;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.mapper.entity.UserEntityMapper;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.repository.UserRepository;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.service.UserJpaPersistenceAdapter;
import com.microservice.microservice_usuario.domain.ports.api.ProgramDirectorServicePort;
import com.microservice.microservice_usuario.domain.ports.spi.UserPersistencePort;
import com.microservice.microservice_usuario.domain.usecase.ProgramDirectorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public BeansConfiguration(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Bean
    public UserPersistencePort getTeacherPersistencePort() {
        return new UserJpaPersistenceAdapter(userRepository, userEntityMapper);
    }
    @Bean
    public ProgramDirectorServicePort getTeacherServicePort() {
        return new ProgramDirectorUseCase(getTeacherPersistencePort());
    }

}
