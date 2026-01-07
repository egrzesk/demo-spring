package com.example.demo;

import com.example.demo.application.AddTaskUseCase;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApplication implements ApplicationRunner {

    private final AddTaskUseCase addTaskUseCase;

    public TaskManagerApplication(AddTaskUseCase addTaskUseCase) {
        this.addTaskUseCase = addTaskUseCase;
    }

    public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        addTaskUseCase.handle("Demo Task", "This is task description.", false);
    }
}
