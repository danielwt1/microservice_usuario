package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.mappers.dto;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.entity.UserEntity;
import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserTeacherRequestDTO;
import com.microservice.microservice_usuario.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserModelMapper {
    UserModel toModel(UserTeacherRequestDTO teacherDTO);
    UserEntity toEntity(UserModel teacherModel);

}
