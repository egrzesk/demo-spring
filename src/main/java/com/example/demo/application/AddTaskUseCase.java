package com.example.demo.application;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddTaskUseCase {

    private static final Logger log = LoggerFactory.getLogger(AddTaskUseCase.class);
    private final DateTimeProvider dateTimeProvider;
    private TaskRepository taskRepository;

    public AddTaskUseCase(DateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
    }

    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task handle(String title, String description, boolean completed) {
        var task = createTask(title, description, completed);
        log.info("Task created: {}", task);
        return taskRepository.save(task);
    }

    private Task createTask(String title, String description, boolean completed) {
        return new Task(new TaskId(), title, description, completed, dateTimeProvider.getZonedDateTime());
    }
}
