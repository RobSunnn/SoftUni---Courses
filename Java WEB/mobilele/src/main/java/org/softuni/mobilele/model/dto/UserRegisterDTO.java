package org.softuni.mobilele.model.dto;

public record UserRegisterDTO(String firstName,
                              String lastName,
                              String email,
                              String username,
                              String password,
                              String confirmPassword) {
}
