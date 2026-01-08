package com.example.demo;

import com.example.demo.application.AddTaskUseCase;
import com.example.demo.application.CompleteTaskUseCase;
import com.example.demo.application.GetTaskUseCase;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApplication implements ApplicationRunner {

    private final AddTaskUseCase addTaskUseCase;
    private final GetTaskUseCase getTaskUseCase;
    private final CompleteTaskUseCase completeTaskUseCase;

    public TaskManagerApplication(AddTaskUseCase addTaskUseCase,
                                  GetTaskUseCase getTaskUseCase,
                                  CompleteTaskUseCase completeTaskUseCase) {
        this.addTaskUseCase = addTaskUseCase;
        this.getTaskUseCase = getTaskUseCase;
        this.completeTaskUseCase = completeTaskUseCase;
    }

    public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var taskA = addTaskUseCase.handle("Task A", "This is the first task description.", false);
        var taskB = addTaskUseCase.handle("Task B", "This is the second task description.", false);

        var taskF = getTaskUseCase.handle(taskA.getId());
        completeTaskUseCase.handle(taskF);

        // verify the task was completed
        // listAllTasksUseCase.handle();

        // deleteTaskUseCase.handle(taskF.getId());

        // the task was deleted - but just check
        // getTaskUseCase.handle(taskA.getId());
        // listAllTasksUseCase.handle();
    }
}
