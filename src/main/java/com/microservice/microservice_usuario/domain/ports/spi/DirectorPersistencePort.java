package com.microservice.microservice_usuario.domain.ports.spi;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.service.DirectorJpaPersistencePort;
import com.microservice.microservice_usuario.domain.model.UserModel;

public interface DirectorPersistencePort {
    public void createDirector(UserModel userModel);
}
