package com.microservice.microservice_usuario.domain.usecase;

import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.model.UserTypeModel;
import com.microservice.microservice_usuario.domain.model.enums.UserTypeEnum;
import com.microservice.microservice_usuario.domain.ports.api.ProgramDirectorServicePort;
import com.microservice.microservice_usuario.domain.ports.spi.UserPersistencePort;

public class ProgramDirectorUseCase implements ProgramDirectorServicePort {

    private final UserPersistencePort teacherPersistencePort;

    public ProgramDirectorUseCase(UserPersistencePort teacherPersistencePort) {
        this.teacherPersistencePort = teacherPersistencePort;
    }

    @Override
    public void createTeacher(UserModel user) {
        UserTypeModel userType = new UserTypeModel(UserTypeEnum.PROFESOR.getIdType());
        user.setUserType(userType);
        this.teacherPersistencePort.createTeacher(user);
    }
}
