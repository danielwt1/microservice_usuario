package com.microservice.microservice_usuario.apadaters.driven.persistencejpa.mapper.entity;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.entity.UserEntity;
import com.microservice.microservice_usuario.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    UserEntity toEntity(UserModel userModel);
    UserModel toModel(UserEntity userEntity);

}
