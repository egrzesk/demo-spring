package com.example.demo.adapters.rest;

import com.example.demo.application.CompleteTaskUseCase;
import com.example.demo.domain.TaskResponseDto;
import com.example.demo.domain.TaskId;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
final class CompleteTaskController {
    private final CompleteTaskUseCase completeTaskUseCase;

    public CompleteTaskController(CompleteTaskUseCase completeTaskUseCase) {
        this.completeTaskUseCase = completeTaskUseCase;
    }
    @PatchMapping(path = "{id}/complete", consumes = MediaType.APPLICATION_JSON_VALUE) //application/json
    public ResponseEntity<TaskResponseDto> completeTask(
            @PathVariable final String id,
            @RequestBody CompletedOnly completedOnly)
    {
        var taskId = new TaskId(UUID.fromString(id));
        var completed = completedOnly.completed();
        var task = completeTaskUseCase.handle(taskId, completed);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok(TaskResponseDto.from(task));
    }

    public record CompletedOnly(boolean completed) {}

}

