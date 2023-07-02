package com.microservice.microservice_usuario.domain.usecase;

import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.model.UserTypeModel;
import com.microservice.microservice_usuario.domain.model.enums.UserTypeEnum;
import com.microservice.microservice_usuario.domain.ports.spi.TeacherPersistencePort;
import com.microservice.microservice_usuario.mockData.UserModelMockData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TeacherUseCaseTest {
    @Mock
    private TeacherPersistencePort teacherPersistencePort;

    @InjectMocks
    private TeacherUseCase teacherUseCase;

    @BeforeEach
    void setUp() {
        teacherUseCase = new TeacherUseCase(teacherPersistencePort);
    }

    @Test
    void createTeacher() {
        // Arrange
        UserModel user_ = UserModelMockData.createMockUserModel(1L, UserTypeEnum.PROFESOR);
        UserTypeModel expectedUserType = new UserTypeModel(UserTypeEnum.PROFESOR.getIdType());
        user_.setUserType(expectedUserType);

        // Act
        teacherUseCase.createTeacher(user_);

        // Assert
        verify(teacherPersistencePort).createTeacher(any(UserModel.class));
        assert user_.getUserType().getIdUserType().equals(expectedUserType.getIdUserType());
    }

    @Test
    void createTeacher_WithNullUser_ShouldThrowException() {
        // Arrange & Act & Assert
        assertThrows(NullPointerException.class, () -> teacherUseCase.createTeacher(null));
    }
}