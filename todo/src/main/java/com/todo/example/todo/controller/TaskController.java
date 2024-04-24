package com.todo.example.todo.controller;

import com.todo.example.todo.domain.Task;
import com.todo.example.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @PutMapping("/changeStatus/{id}")
    public void changeStatus(@RequestParam Long id){
        taskService.changeStatus(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@RequestParam Long id){
        taskService.deleteTask(id);
    }

    @GetMapping("/all")
    public List<Task> getAllTasks(){
        return taskService.getTasks();
    }

}
