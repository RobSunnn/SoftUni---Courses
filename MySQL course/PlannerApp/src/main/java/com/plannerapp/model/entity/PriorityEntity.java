package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityName;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "priorities")
public class PriorityEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PriorityName name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "priority")
    private List<TaskEntity> tasks;

    public PriorityEntity() {
    }

    public PriorityName getName() {
        return name;
    }

    public void setName(PriorityName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
