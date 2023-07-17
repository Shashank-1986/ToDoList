package com.example.FirstJPAProject.tasks;

//import com.example.FirstJPAProject.DTO.TaskDto;
import com.example.FirstJPAProject.DTO.TaskDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RequestMapping("/tasks")
@RestController()
public class TasksController {


    //    @Autowired//no need of constructor injection. Rather field injection. It uses reflection and reflection is slow
    //field injection happens after the constructor
    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/")
    public List<TaskEntity> getAllTodos()
    {
        return tasksService.getAllTasks();
    }

    @PostMapping("/")
    public TaskEntity addNewTodo(@RequestBody TaskDto body)
    {
        return tasksService.addNewTask(body.name);
    }

    @GetMapping("/{id}")
    public TaskEntity getTodoById(@PathVariable("id") Integer id)
    {
        return tasksService.getTaskById(id);
    }

    @PutMapping("/{id}/done")
    String setTodoDone(@PathVariable("id") Integer id)
    {
        tasksService.setTaskDone(id, true);
        return "Task " + id + " set to done";
    }

    @PutMapping("/{id}/notdone")
    String setTodoNotDone(@PathVariable("id") Integer id)
    {
        tasksService.setTaskDone(id, false);
        return "Task " + id + " set to not done";
    }

    @PutMapping("/{id}/delete")
    String delete(@PathVariable("id") Integer id)
    {
        tasksService.deleteTask(id);
        return "Task " + id + " deleted from the list";
    }
}
