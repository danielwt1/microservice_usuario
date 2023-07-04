package com.microservice.microservice_usuario.configuration;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.mapper.entity.UserEntityMapper;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.repository.UserRepository;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.service.ProgramDirectorJpaPersistencePort;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.service.StudentJpaPersistencePort;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.service.TeacherJpaPersistencePort;
import com.microservice.microservice_usuario.domain.ports.api.DirectorProgramServicePort;
import com.microservice.microservice_usuario.domain.ports.api.StudentServicePort;
import com.microservice.microservice_usuario.domain.ports.api.TeacherServicePort;
import com.microservice.microservice_usuario.domain.ports.spi.DirectorPersistencePort;
import com.microservice.microservice_usuario.domain.ports.spi.StudentPersistencePort;
import com.microservice.microservice_usuario.domain.ports.spi.TeacherPersistencePort;
import com.microservice.microservice_usuario.domain.usecase.DirectorProgramUseCase;
import com.microservice.microservice_usuario.domain.usecase.StudentUseCase;
import com.microservice.microservice_usuario.domain.usecase.TeacherUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeansConfiguration {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    public BeansConfiguration(UserRepository userRepository, UserEntityMapper userEntityMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public TeacherPersistencePort getTeacherPersistencePort() {
        return new TeacherJpaPersistencePort(userRepository, userEntityMapper,passwordEncoder);
    }

    @Bean
    public TeacherServicePort getTeacherServicePort() {
        return new TeacherUseCase(getTeacherPersistencePort());
    }

    @Bean
    public StudentPersistencePort getStudentPersistencePort() {
        return new StudentJpaPersistencePort(userRepository, userEntityMapper,passwordEncoder);
    }

    @Bean
    public StudentServicePort getStudentServicePort() {
        return new StudentUseCase(getStudentPersistencePort());
    }

    @Bean
    public DirectorPersistencePort getDirectorPersistencePort() {
        return new ProgramDirectorJpaPersistencePort(userRepository, userEntityMapper,passwordEncoder);
    }

    @Bean
    public DirectorProgramServicePort getDirectorServicePort() {
        return new DirectorProgramUseCase(getDirectorPersistencePort());
    }

}
