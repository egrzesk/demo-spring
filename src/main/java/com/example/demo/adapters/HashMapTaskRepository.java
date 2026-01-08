package com.example.demo.adapters;

import com.example.demo.application.TaskRepository;
import com.example.demo.domain.Task;
import com.example.demo.domain.TaskId;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class HashMapTaskRepository implements TaskRepository {
    private final Map<TaskId, Task> data = new HashMap<>();

    @Override
    public synchronized Task save(final Task task) {
        data.put(task.getId(), task);
        return task;
    }

    @Override
    public synchronized Optional<Task> findById(TaskId id) {
        var task = data.get(id);
        return Optional.ofNullable(task);
    }

    @Override
    public synchronized Optional<Task> findAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Task> completeTask(TaskId taskId) {
        var task = data.get(taskId);
        task.setCompleted(true);
        return Optional.empty();
    }
}
