package com.microservice.microservice_usuario.domain.usecase;

import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.model.UserTypeModel;
import com.microservice.microservice_usuario.domain.model.enums.UserTypeEnum;
import com.microservice.microservice_usuario.domain.ports.api.StudentServicePort;
import com.microservice.microservice_usuario.domain.ports.spi.StudentPersistencePort;

public class StudentUseCase implements StudentServicePort {
    private final StudentPersistencePort studentPersistencePort;

    public StudentUseCase(StudentPersistencePort studentPersistencePort) {
        this.studentPersistencePort = studentPersistencePort;
    }

    @Override
    public void createStudent(UserModel user) {
        UserTypeModel userType = new UserTypeModel(UserTypeEnum.ALUMNO.getIdType());
        user.setUserType(userType);
        this.studentPersistencePort.createStudent(user);
    }
}
