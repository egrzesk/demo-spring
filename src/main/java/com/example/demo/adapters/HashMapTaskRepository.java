package com.example.demo.adapters;

import com.example.common.PageSpec;
import com.example.common.ResultPage;
import com.example.demo.application.TaskRepository;
import com.example.demo.domain.Task;
import com.example.demo.domain.TaskId;
import org.springframework.stereotype.Repository;

import java.util.*;

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
    public synchronized ResultPage<Task> findAll(final PageSpec pageSpec) {
        var tasks = new ArrayList<>(data.values());
        tasks.sort(Comparator.comparing(Task::getTitle).reversed());
        int startIndex = pageSpec.index(); // * pageSpec.size();
        int endIndex = Math.min(startIndex + tasks.size(), tasks.size());
        var content = tasks.subList(startIndex, endIndex);
        int totalPages = (int) Math.ceil((double) tasks.size() / pageSpec.size());
        return new ResultPage<>(content, pageSpec, totalPages);
    }

    @Override
    public synchronized Optional<Task> completeTask(TaskId taskId) {
        var task = data.get(taskId);
        task.setCompleted(true);
        return Optional.empty();
    }

    @Override
    public synchronized boolean deleteTask(TaskId taskId) {
        return data.remove(taskId) != null;
    }
}
