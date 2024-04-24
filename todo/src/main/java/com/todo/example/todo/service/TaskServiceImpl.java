package com.todo.example.todo.service;

import com.todo.example.todo.domain.Task;
import com.todo.example.todo.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;
    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task updatedTask) {
        Task task = taskRepository.findById(updatedTask.getId()).orElse(null);
        if (task != null){
            if (updatedTask.getDescription() != null){
                task.setDescription(updatedTask.getDescription());
            }
            if (updatedTask.getTitle() != null){
                task.setTitle(updatedTask.getTitle());
            }
        }
        return taskRepository.save(task);
    }

    @Override
    public void changeStatus(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null){
            task.setCompleted(!task.isCompleted());
        }
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
