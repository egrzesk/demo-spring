package com.example.demo;

import com.example.demo.application.AddTaskUseCase;
import com.example.demo.application.DateTimeProvider;
import com.example.demo.application.TaskRepository;
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
    
}
