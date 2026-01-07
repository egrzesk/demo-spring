package com.example.demo.application;

import com.example.demo.domain.Task;

public class AddTaskUseCase {

    private final DateTimeProvider dateTimeProvider;
    private TaskRepository taskRepository;

    public AddTaskUseCase(DateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
    }

    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void handle(String title, String description, boolean completed) {
        var task = createTask(title, description, completed);
        taskRepository.save(task);
    }

    private Task createTask(String title, String description, boolean completed) {
        return new Task(1L, title, description, completed, dateTimeProvider.getZonedDateTime());
    }
}
