package com.microservice.microservice_usuario.domain.ports.spi;

import com.microservice.microservice_usuario.domain.model.UserModel;

public interface UserPersistencePort {

    void createTeacher (UserModel user);
}
