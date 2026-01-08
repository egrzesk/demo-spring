package com.example.demo.application;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskId;

public class CompleteTaskUseCase {
    private TaskRepository taskRepository;

    public CompleteTaskUseCase() {
    }

    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task handle(Task task) {
        taskRepository.completeTask(task.getId());
        return taskRepository.save(task);
    }
}
