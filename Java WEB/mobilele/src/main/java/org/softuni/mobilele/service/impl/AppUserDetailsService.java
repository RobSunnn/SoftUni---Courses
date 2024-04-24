package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.model.entity.UserRoleEntity;
import org.softuni.mobilele.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
                .map(AppUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with email:" + email + "not found!"));

    }


    // map the userEntity to UserDetails bean because Spring need it
    //also here we control what we need, like if we want user first name we need to add it here,
    // so we can use it in thymeleaf EXAMPLE IS .username in UserDetails

    private static UserDetails map(UserEntity userEntity) {
        return User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream().map(AppUserDetailsService::map).toList())
                .username(userEntity.getFirstName() + " " + userEntity.getLastName())
                .build();
    }

    // to take the roles of the user we need to give granted authority to the user
    private static GrantedAuthority map(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority(
                "ROLE_" + userRoleEntity.getRole().name());
    }

}
