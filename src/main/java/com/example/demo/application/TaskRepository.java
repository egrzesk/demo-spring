package com.example.demo.application;

import com.example.demo.domain.Task;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);

    Optional<Task> findById(String id);
}
