package com.example.demo.application;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskId;

import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);

    Optional<Task> findById(TaskId id);

    Optional<Task> findAll();

    Optional<Task> completeTask(TaskId taskId);
}
