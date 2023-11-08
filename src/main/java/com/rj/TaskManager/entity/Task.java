package com.rj.TaskManager.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is required.")
    private String title;
    @NotBlank(message = "Description is required.")
    private String description;
    @Future(message = "Date should be in future.")
    private Date dueDate;
    
    private boolean completed;

}
