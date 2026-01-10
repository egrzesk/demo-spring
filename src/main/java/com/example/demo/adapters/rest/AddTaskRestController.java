package com.example.demo.adapters.rest;

import com.example.common.web.LocationUri;
import com.example.demo.application.AddTaskUseCase;
import com.example.demo.domain.Task;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
final class AddTaskRestController {
    private final AddTaskUseCase addTaskUseCase;

    public AddTaskRestController(AddTaskUseCase addTaskUseCase) {
        this.addTaskUseCase = addTaskUseCase;
    }

    @PostMapping("api/tasks")
    ResponseEntity<AddTaskResponse> addTask(@Valid @RequestBody AddTaskRequest addTaskRequest) {
        var task = addTaskUseCase.handle(addTaskRequest.title(), addTaskRequest.description(), addTaskRequest.completed());
        var id = task.getId().value();
        //var id = LocationUri.fromRequest(s);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()      // /api/tasks
                .path("/{id}")
                .buildAndExpand(id)        // .build()
                .toUri();
        return ResponseEntity.created(location).body(AddTaskResponse.from(task));
    }
}

record AddTaskRequest(
        @NotBlank(message = "title is required") String title,
        String description,     // may be filled in later
        boolean completed) {
}

record AddTaskResponse(String id, String title, String description, boolean completed) {

    static AddTaskResponse from(final Task task) {
        return new AddTaskResponse(String.valueOf(task.getId()), task.getTitle(), task.getDescription(), task.isCompleted());
    }

}