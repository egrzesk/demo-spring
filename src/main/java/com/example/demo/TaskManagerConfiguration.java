package com.example.demo;

import com.example.demo.application.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskManagerConfiguration {

    //private static final Logger log = LoggerFactory.getLogger(TaskManagerConfiguration.class);

    @Bean
    public AddTaskUseCase addTaskUseCase(DateTimeProvider dateTimeProvider, TaskRepository taskRepository) {
        //log.info("@Bean addTaskUseCase ------------------------------------------------------------------------------");
        var addTaskUseCase = new AddTaskUseCase(dateTimeProvider);
        addTaskUseCase.setTaskRepository(taskRepository);
        return addTaskUseCase;
    }

    @Bean
    public GetTaskUseCase getTaskUseCase(TaskRepository taskRepository) {
        //log.info("@Bean getTaskUseCase ------------------------------------------------------------------------------");
        return new GetTaskUseCase(taskRepository);
    }

    @Bean
    public GetAllTasksUseCase getAllTasksUseCase(TaskRepository taskRepository) {
        return new GetAllTasksUseCase(taskRepository);
    }

    @Bean
    public CompleteTaskUseCase completeTaskUseCase(TaskRepository taskRepository) {
        return new CompleteTaskUseCase(taskRepository);
    }

    @Bean
    public DeleteTaskUseCase deleteTaskUseCase(TaskRepository taskRepository) {
        //log.info("@Bean deleteTaskUseCase ---------------------------------------------------------------------------");
        return new DeleteTaskUseCase(taskRepository);
    }

    @Bean
    public UpdateTaskUseCase updateTaskUseCase(TaskRepository taskRepository) {
        return new UpdateTaskUseCase(taskRepository);
    }

}
