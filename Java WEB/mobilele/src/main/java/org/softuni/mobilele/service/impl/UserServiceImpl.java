package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.model.dto.UserRegisterDTO;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.UserService;
import org.softuni.mobilele.session.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private CurrentUser currentUser;


    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public boolean registerUser(UserRegisterDTO userRegisterDTO) {

        this.userRepository.save(mapUser(userRegisterDTO));
        return false;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> user = this.userRepository.findByEmail(userLoginDTO.email());

        if (user.isPresent()) {
            currentUser.setFirstName(user.get().getFirstName());
            currentUser.setLastName(user.get().getLastName());
            currentUser.setLogged(true);

        } else {
            currentUser.logout();
        }

        return false;
    }

    public void logout() {
        currentUser.logout();
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
