package com.example.demo.application;

import com.example.common.PageSpec;
import com.example.common.ResultPage;
import com.example.demo.domain.Task;
import org.springframework.stereotype.Service;

@Service
public class GetAllTasksUseCase {
    private final TaskRepository taskRepository;

    public GetAllTasksUseCase(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ResultPage<Task> handle(final PageSpec pageSpec) {
        return taskRepository.findAll(pageSpec);
    }
}
