package com.example.demo.application;

import com.example.demo.domain.TaskId;

public class DeleteTaskUseCase {
    private final TaskRepository taskRepository;

    public DeleteTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public boolean handle(TaskId id) {
        return taskRepository.deleteTask(id);
    }
}
