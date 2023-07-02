package com.microservice.microservice_usuario.domain.model.enums;

public enum UserTypeEnum {
    DECANO(1L),
    DIRECTOR_DE_PROGRAMA(2l),
    PROFESOR(3L),
    ALUMNO(4L);

    private final Long idType;

    UserTypeEnum(Long idType) {
        this.idType = idType;
    }

    public Long getIdType() {
        return idType;
    }

}
