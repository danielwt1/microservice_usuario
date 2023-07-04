package com.microservice.microservice_usuario.apadaters.driven.persistencejpa.service;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.mapper.entity.UserEntityMapper;
import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.repository.UserRepository;
import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.model.UserTypeModel;
import com.microservice.microservice_usuario.domain.model.enums.UserTypeEnum;
import com.microservice.microservice_usuario.mockData.UserModelMockData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentJpaPersistencePortTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserEntityMapper userEntityMapper;
    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    private StudentJpaPersistencePort studentJpaPersistencePort;

    @BeforeEach
    public void setup() {
        studentJpaPersistencePort = new StudentJpaPersistencePort(userRepository, userEntityMapper,passwordEncoder);
    }

    @Test
    void createStudent() {
        // Arrange
        UserModel user_ = UserModelMockData.createMockUserModel(1L, UserTypeEnum.ALUMNO);
        UserTypeModel expectedUserType = new UserTypeModel(UserTypeEnum.ALUMNO.getIdType());
        user_.setUserType(expectedUserType);

        // Act
        studentJpaPersistencePort.createStudent(user_);

        // Assert
        verify(userRepository).save(userEntityMapper.toEntity(user_));
        assert user_.getUserType().getIdUserType().equals(expectedUserType.getIdUserType());
    }

}