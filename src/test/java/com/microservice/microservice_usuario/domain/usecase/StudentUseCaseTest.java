package com.microservice.microservice_usuario.domain.usecase;

import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.model.UserTypeModel;
import com.microservice.microservice_usuario.domain.model.enums.UserTypeEnum;
import com.microservice.microservice_usuario.domain.ports.spi.StudentPersistencePort;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class StudentUseCaseTest {
    @Mock
    private StudentPersistencePort studentPersistencePort;

    private StudentUseCase studentUseCase;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        studentUseCase = new StudentUseCase(studentPersistencePort);
    }

    @Test
    public void createStudent_ShouldCallPersistencePortWithCorrectUser() {
        // Arrange
        UserModel user = new UserModel();
        user.setIdUser(9L);
        user.setName("David");
        user.setLastName("Garces");
        user.setEmail("david@example.com");
        user.setPassword("d123456789");
        user.setCode(123456789L);

        // Create UserTypeModel if needed
        UserTypeModel userType = new UserTypeModel(UserTypeEnum.ALUMNO.getIdType());
        user.setUserType(userType);

        // Act
        studentUseCase.createStudent(user);

        // Assert
        verify(studentPersistencePort).createStudent(user);
    }
}