package com.microservice.microservice_usuario.domain.model;

public class UserTypeModel {

    private Long idUserType;
    private String name;
    private String description;

    public UserTypeModel() {
    }

    public UserTypeModel(Long idUserType) {
        this.idUserType = idUserType;
    }

    public UserTypeModel(Long idUserType, String name, String description) {
        this.idUserType = idUserType;
        this.name = name;
        this.description = description;
    }

    public Long getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(Long idUserType) {
        this.idUserType = idUserType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
