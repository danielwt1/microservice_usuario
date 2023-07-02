package com.microservice.microservice_usuario.mockData;

import com.microservice.microservice_usuario.domain.model.UserModel;
import com.microservice.microservice_usuario.domain.model.UserTypeModel;
import com.microservice.microservice_usuario.domain.model.enums.UserTypeEnum;

public class UserModelMockData {
    public static UserModel createMockUserModel(Long id, UserTypeEnum UserType) {
        UserModel user_ = new UserModel();
        user_.setIdUser(id);
        user_.setName("John");
        user_.setLastName("Doe");
        user_.setEmail("john.doe@example.com");
        user_.setPassword("123456");
        user_.setCode(id);
        UserTypeModel expectedUserType = new UserTypeModel(UserType.getIdType());
        user_.setUserType(expectedUserType);

        return user_;
    }
}
