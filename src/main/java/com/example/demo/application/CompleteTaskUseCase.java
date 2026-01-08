package com.example.demo.application;

import com.example.demo.domain.Task;

public class CompleteTaskUseCase {
    private final TaskRepository taskRepository;

    public CompleteTaskUseCase(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task handle(Task task) {
        taskRepository.completeTask(task.getId());
        return taskRepository.save(task);
    }
}
