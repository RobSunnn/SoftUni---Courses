package com.plannerapp.service;

import com.plannerapp.model.dto.AddTaskDTO;
import com.plannerapp.model.dto.TaskDTO;
import com.plannerapp.model.dto.TaskHomeViewModel;
import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    private final PriorityRepository priorityRepository;

    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, PriorityRepository priorityRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
        this.userRepository = userRepository;
    }

    public void add(AddTaskDTO addTaskDTO) {
        PriorityEntity priority = priorityRepository.findByName(addTaskDTO.getPriority());

        TaskEntity task = new TaskEntity();
        task.setDescription(addTaskDTO.getDescription());
        task.setDueDate(LocalDate.parse(addTaskDTO.getDueDate()));
        task.setPriority(priority);


        taskRepository.save(task);
    }

    public void remove(Long id) {
        taskRepository.deleteById(id);
    }

    public void assign(Long id, String username) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            TaskEntity task = optionalTask.get();

            if (username == null) {
                task.setUser(null);
            } else {
                UserEntity user = userRepository.findByUsername(username);
                task.setUser(user);
            }

            taskRepository.save(task);
        }
    }

    public TaskHomeViewModel getViewData(String username) {

        UserEntity byUsername = userRepository.findByUsername(username);

        List<TaskDTO> availableTasks = taskRepository
                .allAvailableTasks()
                .stream()
                .map(TaskDTO::createFromTaskEntity)
                .toList();
        List<TaskDTO> assignedTasks = taskRepository
                .findByUser(byUsername)
                .stream()
                .map(TaskDTO::createFromTaskEntity)
                .toList();

        return new TaskHomeViewModel(availableTasks, assignedTasks);
    }
}
