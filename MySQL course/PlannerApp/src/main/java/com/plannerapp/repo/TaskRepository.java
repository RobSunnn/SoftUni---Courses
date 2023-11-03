package com.plannerapp.repo;

import com.plannerapp.model.dto.TaskDTO;
import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM tasks WHERE user_id IS NOT NULL")
    List<TaskEntity> findByUser(UserEntity user);

    @Query(nativeQuery = true,value = "SELECT * FROM tasks WHERE user_id IS NULL")
    List<TaskEntity> allAvailableTasks();
}
