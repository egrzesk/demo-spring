package com.example.demo.domain;

import java.time.LocalDate;
import java.time.ZonedDateTime;

/*---------------------------------------------
    `id` – unikalny identyfikator (`Long`)
    `title` – tytuł zadania
    `description` – opis
    `completed` – status wykonania (`boolean`)
    `createdAt` – data utworzenia

    Long id, String title, String description, boolean completed, LocalDate createdAt
*/
public final class Task {
    private final TaskId id;
    private String title;
    private String description;
    private boolean completed;
    private final LocalDate createdAt;

    public Task(TaskId id, String title, String description, boolean completed, ZonedDateTime timestamp) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = timestamp.toLocalDate();
    }

    public TaskId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
