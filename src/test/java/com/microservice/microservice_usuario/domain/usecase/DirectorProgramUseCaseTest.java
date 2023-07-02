package com.microservice.microservice_usuario.domain.usecase;

import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.model.UserTypeModel;
import com.microservice.microservice_usuario.domain.model.enums.UserTypeEnum;
import com.microservice.microservice_usuario.domain.ports.spi.DirectorPersistencePort;
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
class DirectorProgramUseCaseTest {
    @Mock
    private DirectorPersistencePort directorPersistencePort;

    @InjectMocks
    private DirectorProgramUseCase directorProgramUseCase;

    @BeforeEach
    void setUp() {
        directorProgramUseCase = new DirectorProgramUseCase(directorPersistencePort);
    }

    @Test
    void createDirector() {
        // Arrange
        UserModel user_ = UserModelMockData.createMockUserModel(1L, UserTypeEnum.DIRECTOR_DE_PROGRAMA);
        UserTypeModel expectedUserType = new UserTypeModel(UserTypeEnum.DIRECTOR_DE_PROGRAMA.getIdType());
        user_.setUserType(expectedUserType);

        // Act
        directorProgramUseCase.createDirector(user_);

        // Assert
        verify(directorPersistencePort).createDirector(any(UserModel.class));
        assert user_.getUserType().getIdUserType().equals(expectedUserType.getIdUserType());
    }

    @Test
    void createDirector_WithNullUser_ShouldThrowException() {
        // Arrange & Act & Assert
        assertThrows(NullPointerException.class, () -> directorProgramUseCase.createDirector(null));
    }
}