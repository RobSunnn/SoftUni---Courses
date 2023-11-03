package com.plannerapp.model.dto;

import com.plannerapp.annotations.CustomDate;
import com.plannerapp.model.enums.PriorityName;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AddTaskDTO {


    @Size(min = 2, max = 50,message = "Username length must be between 2 and 50 characters!")
    private String description;

    @CustomDate(message = "Due Date must be in the future!")
    @NotNull
    private String dueDate;

    public AddTaskDTO() {
    }

    @NotNull(message = "You must select a priority!")
    private PriorityName priority;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public PriorityName getPriority() {
        return priority;
    }

    public void setPriority(PriorityName priority) {
        this.priority = priority;
    }
}
