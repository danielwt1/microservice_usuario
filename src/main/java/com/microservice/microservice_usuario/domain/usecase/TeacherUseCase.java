package com.microservice.microservice_usuario.domain.usecase;

import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.model.UserTypeModel;
import com.microservice.microservice_usuario.domain.model.enums.UserTypeEnum;
import com.microservice.microservice_usuario.domain.ports.api.TeacherServicePort;
import com.microservice.microservice_usuario.domain.ports.spi.TeacherPersistencePort;
import org.hibernate.usertype.UserType;

public class TeacherUseCase implements TeacherServicePort {

    private final TeacherPersistencePort teacherPersistencePort;

    public TeacherUseCase(TeacherPersistencePort teacherPersistencePort) {
        this.teacherPersistencePort = teacherPersistencePort;
    }

    @Override
    public void createTeacher(UserModel user) {
        UserTypeModel userType = new UserTypeModel(UserTypeEnum.PROFESOR.getIdType());
        user.setUserType(userType);
        this.teacherPersistencePort.createTeacher(user);
    }
}
