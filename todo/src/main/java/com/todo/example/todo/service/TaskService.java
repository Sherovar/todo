package com.todo.example.todo.service;


import com.todo.example.todo.domain.Task;

import java.util.List;

public interface TaskService {
    Task addTask(Task task);

    List<Task> getTasks();

    Task updateTask(Task task);

    void changeStatus(Long id);

    void deleteTask(Long id);
}
