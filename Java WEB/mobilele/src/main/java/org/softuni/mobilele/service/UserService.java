package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.model.dto.UserRegisterDTO;
import org.springframework.stereotype.Service;


public interface UserService {

    boolean registerUser(UserRegisterDTO userRegisterDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logout();
}
