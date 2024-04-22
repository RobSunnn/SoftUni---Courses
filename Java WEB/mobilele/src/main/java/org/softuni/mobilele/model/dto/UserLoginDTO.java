package org.softuni.mobilele.model.dto;

import jakarta.persistence.Column;

public class UserLoginDTO {

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    public UserLoginDTO() {}

}
