package com.microservice.microservice_usuario.configuration;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.mapper.entity.UserEntityMapper;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.repository.UserRepository;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.service.TeacherJpaPersistenceAdapter;
import com.microservice.microservice_usuario.domain.ports.api.TeacherServicePort;
import com.microservice.microservice_usuario.domain.ports.spi.TeacherPersistencePort;
import com.microservice.microservice_usuario.domain.usecase.TeacherUseCase;
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
    public TeacherPersistencePort getTeacherPersistencePort() {
        return new TeacherJpaPersistenceAdapter(userRepository, userEntityMapper);
    }
    @Bean
    public TeacherServicePort getTeacherServicePort() {
        return new TeacherUseCase(getTeacherPersistencePort());
    }

}
