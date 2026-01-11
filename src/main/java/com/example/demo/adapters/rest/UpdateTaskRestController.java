package com.example.demo.adapters.rest;

import com.example.demo.application.UpdateTaskUseCase;
import com.example.demo.domain.Task;
import com.example.demo.domain.TaskResponseDto;
import com.example.demo.domain.TaskId;
import com.example.demo.domain.TaskPatchRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
final class UpdateTaskRestController {
    private final UpdateTaskUseCase updateTaskUseCase;
    //private final Validator validator;

    public UpdateTaskRestController(UpdateTaskUseCase updateTaskUseCase) {  //Validator validator
        this.updateTaskUseCase = updateTaskUseCase;
    }

    @PatchMapping(value = "/{id}") //consumes = "application/merge-patch+json")
    public ResponseEntity<TaskResponseDto> updateTask(
            @PathVariable String id,
            @RequestBody TaskPatchRequest patch) {
        var taskId = new TaskId(UUID.fromString(id));
        Task updated = updateTaskUseCase.handle(taskId, patch);
        return ResponseEntity.ok(TaskResponseDto.from(updated));
    }

}
