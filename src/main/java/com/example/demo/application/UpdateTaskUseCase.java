package com.example.demo.application;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskId;
import com.example.demo.domain.TaskPatchRequest;

public class UpdateTaskUseCase {
    private final TaskRepository taskRepository;

    public UpdateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task handle(TaskId taskId, TaskPatchRequest patch) {
        var current = taskRepository.findById(taskId).orElseThrow(TaskNotFoundExeption::new);
        current.applyPatch(
                patch.getTitle(),
                patch.getDescription(),
                patch.getCompleted()
        );
        return taskRepository.save(current); //return taskRepository.update(task);
    }
}
