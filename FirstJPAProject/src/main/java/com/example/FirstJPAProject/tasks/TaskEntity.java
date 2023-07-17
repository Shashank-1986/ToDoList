package com.example.FirstJPAProject.tasks;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import  com.
        fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity(name = "todolist")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue
    @Column(name ="TASK_ID")
    private Integer id;
    @JsonProperty("name")
    @Column(name = "task_name",nullable = false)
    private String taskName;
    @Column(name = "Done")
    @JsonProperty("done")
    private boolean done = false;


    public TaskEntity(String taskName, boolean b) {

        this.taskName = taskName;
        this.done =b;
    }
}
