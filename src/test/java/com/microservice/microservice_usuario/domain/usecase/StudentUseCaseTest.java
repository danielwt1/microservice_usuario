package com.microservice.microservice_usuario.domain.usecase;

import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.model.UserTypeModel;
import com.microservice.microservice_usuario.domain.model.enums.UserTypeEnum;
import com.microservice.microservice_usuario.domain.ports.spi.StudentPersistencePort;
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
class StudentUseCaseTest {
    @Mock
    private StudentPersistencePort studentPersistencePort;

    @InjectMocks
    private StudentUseCase studentUseCase;

    @BeforeEach
    void setUp() {
        studentUseCase = new StudentUseCase(studentPersistencePort);
    }

    @Test
    void createStudent_ShouldSetUserTypeAndCallPersistencePort() {
        // Arrange
        UserModel user_ = UserModelMockData.createMockUserModel(1L, UserTypeEnum.ALUMNO);
        UserTypeModel expectedUserType = new UserTypeModel(UserTypeEnum.ALUMNO.getIdType());
        user_.setUserType(expectedUserType);

        // Act
        studentUseCase.createStudent(user_);

        // Assert
        verify(studentPersistencePort).createStudent(any(UserModel.class));
        assert user_.getUserType().getIdUserType().equals(expectedUserType.getIdUserType());
    }

    @Test
    void createStudent_WithNullUser_ShouldThrowException() {
        // Arrange & Act & Assert
        assertThrows(NullPointerException.class, () -> studentUseCase.createStudent(null));
    }

}