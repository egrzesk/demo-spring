package com.example.demo.adapters.rest;

import com.example.common.PageSpec;
import com.example.common.ResultPage;
import com.example.demo.application.GetAllTasksUseCase;
import com.example.demo.domain.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
//@RequestMapping("api/tasks")
public class GetTasksRestController {
    private GetAllTasksUseCase getAllTasksUseCase;

    public GetTasksRestController(GetAllTasksUseCase getAllTasksUseCase) {
        this.getAllTasksUseCase = getAllTasksUseCase;
    }

    @GetMapping("api/tasks")
    public ResponseEntity<ResultPage<GetTasksResponse>> getTasks(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") final int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") final int pageSize) {
        var pageSpec = new PageSpec(pageNumber, pageSize);
        var response = getAllTasksUseCase.handle(pageSpec).map(GetTasksResponse::from);
        return ResponseEntity.ok(response);
    }

}

record GetTasksResponse(String id, String title, String description, boolean completed, LocalDate createdAt) {

    static GetTasksResponse from(Task task) {
        return new GetTasksResponse(
                String.valueOf(task.getId()),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt());
    }

}