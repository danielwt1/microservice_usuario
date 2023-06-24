package com.microservice.microservice_usuario.apadaters.driven.persistencejpa.repository;

import com.microservice.microservice_usuario.apadaters.driven.persistencejpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
