package com.plannerapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Length(min = 3, max = 20)
    @Column(nullable = false, unique = true)
    private String  username;

    @Column(nullable = false)
    @Length(min = 3, message = "Password must be between 3 and 20 characters!")
    private String  password;


    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email cannot be empty!")
    @Email
    private String  email;


    @OneToMany(mappedBy = "user")
    private List<TaskEntity> assignedTasks;


    public UserEntity() {
        this.assignedTasks = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TaskEntity> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<TaskEntity> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }
}
