package com.example.demo.adapters.rest;

import com.example.demo.application.CompleteTaskUseCase;
import com.example.demo.domain.Task;
import com.example.demo.domain.TaskId;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class CompleteTaskController {
    private final CompleteTaskUseCase completeTaskUseCase;

    public CompleteTaskController(CompleteTaskUseCase completeTaskUseCase) {
        this.completeTaskUseCase = completeTaskUseCase;
    }
    @PatchMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto> completeTask(
            @PathVariable String id,
            @RequestBody CompletedOnly completedOnly)
    {
        var taskId = new TaskId(UUID.fromString(id));
        var completed = completedOnly.completed();
        var task = completeTaskUseCase.handle(taskId, completed);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok(TaskDto.from(task));
    }

    public record CompletedOnly(boolean completed) {}

}

record TaskDto(String id, String title, String description, boolean completed, LocalDate created) {

    static TaskDto from(Task task) {
        return new TaskDto(
                String.valueOf(task.getId()),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt());
    }

}