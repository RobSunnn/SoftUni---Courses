package com.plannerapp.repo;

import com.plannerapp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsernameOrEmail(String username, String email);
    UserEntity findByUsername(String username);
}
