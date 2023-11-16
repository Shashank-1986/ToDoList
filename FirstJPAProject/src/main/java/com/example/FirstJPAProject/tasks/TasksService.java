package com.example.FirstJPAProject.tasks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TasksService {

    private ArrayList<TaskEntity> taskList = new ArrayList<>();
    private TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public TaskEntity addNewTask(String taskName)
    {
        var task = new TaskEntity(taskName, false);
        tasksRepository.save(task);
        return task;
    }

    public List<TaskEntity> getAllTasks()
    {
        return tasksRepository.findAll();
//        return taskList;
    }

    public TaskEntity getTaskById(Integer index)
    {
        return tasksRepository.findById(index).get();
//        return taskList.get(index);//todo handle invalid index
    }

    public TaskEntity setTaskDone(Integer index, Boolean done)
    {
        var task = tasksRepository.findById(index).get();
        task.setDone(done);
        return tasksRepository.save(task);
    }

    public boolean deleteTask(Integer index)
    {
        tasksRepository.delete(
                tasksRepository.findById(index).get()
        );
        return true;//to handle invalid index
    }
}
