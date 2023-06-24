package com.microservice.microservice_usuario.domain.ports.spi;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.entity.UserEntity;
import com.microservice.microservice_usuario.domain.model.UserModel;

public interface TeacherPersistencePort {

    void createTeacher (UserModel user);
}
