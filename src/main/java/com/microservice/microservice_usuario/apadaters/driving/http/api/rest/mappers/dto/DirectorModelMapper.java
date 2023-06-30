package com.microservice.microservice_usuario.apadaters.driving.http.api.rest.mappers.dto;

import com.microservice.microservice_usuario.apadaters.driving.http.api.rest.dto.request.UserDirectorRequestDTO;
import com.microservice.microservice_usuario.domain.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface DirectorModelMapper {
    public UserModel toModel(UserDirectorRequestDTO userDirectorRequestDTO);
}
