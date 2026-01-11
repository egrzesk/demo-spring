package com.example.demo.adapters.rest;

import com.example.demo.application.DeleteTaskUseCase;
import com.example.demo.domain.TaskId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/tasks")
final class DeleteTaskController {
    private DeleteTaskUseCase deleteTaskUseCase;

    public DeleteTaskController(DeleteTaskUseCase deleteTaskUseCase) {
        this.deleteTaskUseCase = deleteTaskUseCase;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable final String id) {
        var taskId = new TaskId(UUID.fromString(id));
        var deleted = deleteTaskUseCase.handle(taskId);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
