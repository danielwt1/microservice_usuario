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

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TeacherJpaPersistenceAdapterTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserEntityMapper userEntityMapper;

    @InjectMocks
    private TeacherJpaPersistencePort teacherJpaPersistencePort;

    @BeforeEach
    void setUp() {
        teacherJpaPersistencePort = new TeacherJpaPersistencePort(userRepository, userEntityMapper);
    }

    @Test
    void createTeacher() {
        // Arrange
        UserModel user_ = UserModelMockData.createMockUserModel(1L, UserTypeEnum.PROFESOR);
        UserTypeModel expectedUserType = new UserTypeModel(UserTypeEnum.PROFESOR.getIdType());
        user_.setUserType(expectedUserType);

        // Act
        teacherJpaPersistencePort.createTeacher(user_);

        // Assert
        verify(userRepository).save(userEntityMapper.toEntity(user_));
        assert user_.getUserType().getIdUserType().equals(expectedUserType.getIdUserType());

    }
}