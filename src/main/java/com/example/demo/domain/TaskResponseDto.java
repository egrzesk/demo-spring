package com.example.demo.domain;

import java.time.LocalDate;

public record TaskResponseDto(String id, String title, String description, boolean completed, LocalDate created) {

    public static TaskResponseDto from(Task task) {
        return new TaskResponseDto(
                String.valueOf(task.getId()),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt());
    }

}