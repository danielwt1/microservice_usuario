package com.microservice.microservice_usuario.apadaters.driven.persistencejpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_USUARIO")
public class UserTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idUserType;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    public UserTypeEntity() {
    }

    public UserTypeEntity(Long idUserType, String name, String description) {
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
