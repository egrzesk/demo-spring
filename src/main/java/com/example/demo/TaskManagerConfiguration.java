package com.example.demo;

import com.example.demo.application.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskManagerConfiguration {

    @Bean
    public AddTaskUseCase addTaskUseCase(DateTimeProvider dateTimeProvider, TaskRepository taskRepository) {
        var addTaskUseCase = new AddTaskUseCase(dateTimeProvider);
        addTaskUseCase.setTaskRepository(taskRepository);
        return addTaskUseCase;
    }

    @Bean
    public GetTaskUseCase getTaskUseCase(TaskRepository taskRepository) {
        return new GetTaskUseCase(taskRepository);
    }

    @Bean
    public CompleteTaskUseCase completeTaskUseCase(TaskRepository taskRepository) {
        var completeTaskUseCase = new CompleteTaskUseCase();
        completeTaskUseCase.setTaskRepository(taskRepository);
        return completeTaskUseCase;
    }

}
