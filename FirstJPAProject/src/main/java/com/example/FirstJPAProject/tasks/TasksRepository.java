package com.example.FirstJPAProject.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository  extends JpaRepository<TaskEntity, Integer> {


}
