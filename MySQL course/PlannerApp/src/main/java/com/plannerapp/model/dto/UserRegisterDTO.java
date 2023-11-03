package com.plannerapp.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterDTO {

    @Size(min = 3, max = 20, message = "Enter valid username!")
    @NotBlank
    private String username;

    @Size(min = 3, max = 20, message = "Please enter your password.")
    private String password;

    @NotBlank(message = "Please confirm your password.")
    private String confirmPassword;

    @Email
    @NotBlank(message = "Please enter email.")
    private String email;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
