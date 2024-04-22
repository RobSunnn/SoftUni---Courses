package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.UserRegisterDTO;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(UserRegisterDTO userRegisterDTO) {

        this.userRepository.save(mapUser(userRegisterDTO));
        return false;
    }


    private UserEntity mapUser(UserRegisterDTO userRegisterDTO) {

        UserEntity user = new UserEntity();
        user.setActive(true);
        user.setCreated(LocalDateTime.now());
        user.setFirstName(userRegisterDTO.firstName());
        user.setLastName(userRegisterDTO.lastName());
        user.setUsername(userRegisterDTO.username());
        user.setEmail(userRegisterDTO.email());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.password()));

        return user;
    }
}
