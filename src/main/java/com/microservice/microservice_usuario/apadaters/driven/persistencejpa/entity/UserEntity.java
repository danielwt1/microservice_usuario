package com.microservice.microservice_usuario.apadaters.driven.persistencejpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idUser;

    @Column(name = "nombre", nullable = false, length = 20)
    private String name;

    @Column(name = "apellido", nullable = false, length = 20)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "codigo", nullable = false)
    private Long code;

    @OneToOne
    @JoinColumn(name = "idUserType")
    private UserTypeEntity userType;

    public UserEntity() {
    }

    public UserEntity(Long idUser, String name, String lastName, String email, String password, Long code, UserTypeEntity userType) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.code = code;
        this.userType = userType;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public UserTypeEntity getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEntity userType) {
        this.userType = userType;
    }
}
