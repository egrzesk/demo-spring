package com.example.demo.application;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskId;

public class GetTaskUseCase {
    private final TaskRepository taskRepository;

    public GetTaskUseCase(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task handle(final TaskId taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundExeption::new);
    }
}
