package com.microservice.microservice_usuario.domain.ports.api;

import com.microservice.microservice_usuario.domain.model.UserModel;

public interface StudentServicePort {
    void createStudent(UserModel user);
}
