package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

// No need to put @Service because we put it in security config like @Bean
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

       return userRepository.findByEmail(email)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with email:" + email + "not found!"));

    }

    private UserDetails map(UserEntity userEntity) {
        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(List.of())// todo: add roles
                .build();
    }

}
