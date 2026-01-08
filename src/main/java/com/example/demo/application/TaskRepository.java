package com.example.demo.application;

import com.example.common.PageSpec;
import com.example.common.ResultPage;
import com.example.demo.domain.Task;
import com.example.demo.domain.TaskId;

import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);

    Optional<Task> findById(TaskId id);

    ResultPage<Task> findAll(final PageSpec pageSpec);

    Optional<Task> completeTask(TaskId taskId);

    boolean deleteTask(TaskId taskId);
}
