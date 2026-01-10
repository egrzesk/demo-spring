package com.example.demo.application;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskId;

public class CompleteTaskUseCase {
    private final TaskRepository taskRepository;

    public CompleteTaskUseCase(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task handle(TaskId taskId, boolean completed) {
        // taskRepository.completeTask(task.getId());
        var task = taskRepository.findById(taskId).orElseThrow();
        task.setCompleted(completed);
        return taskRepository.update(task);
    }
}
