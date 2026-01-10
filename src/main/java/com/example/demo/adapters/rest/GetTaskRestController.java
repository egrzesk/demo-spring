package com.example.demo.adapters.rest;

import com.example.demo.application.GetTaskUseCase;
import com.example.demo.domain.Task;
import com.example.demo.domain.TaskId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/tasks")
final class GetTaskRestController {

    private final GetTaskUseCase getTaskUseCase;

    public GetTaskRestController(GetTaskUseCase getTaskUseCase) {
        this.getTaskUseCase = getTaskUseCase;
    }

    @GetMapping("{id}")
    ResponseEntity<GetTaskResponse> getTask(@PathVariable final String id) {
        var taskId = new TaskId(UUID.fromString(id));
        var task = getTaskUseCase.handle(taskId);
        return ResponseEntity.ok(GetTaskResponse.from(task));
    }
}

record GetTaskResponse(String id, String title, String description, boolean completed, LocalDate created) {

    static GetTaskResponse from(Task task) {
        return new GetTaskResponse(
                String.valueOf(task.getId()),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt());
    }

}

