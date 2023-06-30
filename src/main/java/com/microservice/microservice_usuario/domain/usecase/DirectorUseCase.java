package com.microservice.microservice_usuario.domain.usecase;

import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.model.UserTypeModel;
import com.microservice.microservice_usuario.domain.model.enums.UserTypeEnum;
import com.microservice.microservice_usuario.domain.ports.api.DirectorServicePort;
import com.microservice.microservice_usuario.domain.ports.spi.DirectorPersistencePort;

public class DirectorUseCase implements DirectorServicePort {

    private final DirectorPersistencePort directorPersistencePort;

    public DirectorUseCase(DirectorPersistencePort directorPersistencePort) {
        this.directorPersistencePort = directorPersistencePort;
    }

    @Override
    public void createDirector(UserModel userModel) {
        UserTypeModel userType = new UserTypeModel(UserTypeEnum.DIRECTOR_DE_PROGRAMA.getIdType());
        userModel.setUserType(userType);
        this.directorPersistencePort.createDirector(userModel);
    }
}
