package com.plannerapp.service;

import com.plannerapp.model.dto.UserLoginDTO;
import com.plannerapp.model.dto.UserRegisterDTO;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final LoggedUser loggedUser;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }


    public boolean registerUser(UserRegisterDTO userRegisterDTO) {

        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            return false;
        }


        UserEntity dbUser = userRepository.findByUsernameOrEmail(userRegisterDTO.getUsername(), userRegisterDTO.getEmail());

        if (dbUser != null) {
            return false;
        }

        UserEntity user = new UserEntity();
        user.setUsername(userRegisterDTO.getUsername());
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));


        userRepository.save(user);

        return true;
    }

    public boolean loginUser(UserLoginDTO userLoginDTO) {
        UserEntity user = userRepository.findByUsername(userLoginDTO.getUsername());

        if (user != null &&
        passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {

            loggedUser.login(user.getUsername());
            return true;
        }

        return false;
    }

    public void logout() {
        loggedUser.logout();
    }
}
