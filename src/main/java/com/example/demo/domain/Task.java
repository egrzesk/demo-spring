package com.example.demo.domain;

import java.time.LocalDate;
import java.time.ZonedDateTime;

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

    public String setTitle(String title) {
        String old = this.title;
        this.title = title;
        return old;
    }

    public String setDescription(String description) {
        String old = this.description;
        this.description = description;
        return old;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void applyPatch(String newTitle, String newDescription, Boolean newCompleted) {
        if (newTitle != null) setTitle(newTitle);
        if (newDescription != null) setDescription(newDescription);
        if (newCompleted != null) setCompleted(newCompleted);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", createdAt=" + createdAt +
                ", id=" + id +
                '}';
    }

}
