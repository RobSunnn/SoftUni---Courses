package org.softuni.mobilele.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.softuni.mobilele.model.entity.enums.UserRoleEnum;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    public UserRoleEnum getUserRoleEnum() {
        return role;
    }

    public void setUserRoleEnum(UserRoleEnum role) {
        this.role = role;
    }
}
