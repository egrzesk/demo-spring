package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/*
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.common.PageSpec;
import com.example.common.ResultPage;
import com.example.demo.application.*;
import com.example.demo.domain.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class TaskManagerApplication implements ApplicationRunner {
    private static final Logger LOG = LoggerFactory.getLogger(TaskManagerApplication.class);

    private final AddTaskUseCase addTaskUseCase;
    private final GetTaskUseCase getTaskUseCase;
    private final CompleteTaskUseCase completeTaskUseCase;
    private final GetAllTasksUseCase getAllTasksUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;

    public TaskManagerApplication(AddTaskUseCase addTaskUseCase,
                                  GetTaskUseCase getTaskUseCase,
                                  CompleteTaskUseCase completeTaskUseCase,
                                  GetAllTasksUseCase getAllTasksUseCase,
                                  DeleteTaskUseCase deleteTaskUseCase) {
        this.addTaskUseCase = addTaskUseCase;
        this.getTaskUseCase = getTaskUseCase;
        this.completeTaskUseCase = completeTaskUseCase;
        this.getAllTasksUseCase = getAllTasksUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
    }
*/
@Configuration
@SpringBootApplication
public class TaskManagerApplication {

    public static void main(String[] args) {
	}

/*
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Task taskA = null;
        for (int i = 0; i < 10; i++) {
            var t = addTaskUseCase.handle("Task " + String.valueOf(i), "Task description.", false);
            if (i == 5) {
                taskA = t;
            }
        }

        ResultPage<Task> page = getAllTasksUseCase.handle(new PageSpec(5, 10));
        page.content().forEach(task -> LOG.info("getAllTasksUseCase: {}", task.toString()));

        var taskF = getTaskUseCase.handle(taskA.getId());
        LOG.info("getTaskUseCase: {}", taskF.toString()); // taskF found

        completeTaskUseCase.handle(taskF);
        LOG.info("completeTaskUseCase: {}", taskF.toString()); // taskF completed
        if (deleteTaskUseCase.handle(taskF.getId()) ) {
            LOG.info("deleteTaskUseCase: success Task deleted - {}", taskF.toString());
        } else {
            LOG.info("deleteTaskUseCase: no Task to delete - {}", taskF.toString());
        }
        try {
            getTaskUseCase.handle(taskF.getId()); // task was deleted
        } catch (TaskNotFoundExeption e) {
            LOG.info("Task id: {} was deleted", taskF.getId());
        }
    }
*/
}
