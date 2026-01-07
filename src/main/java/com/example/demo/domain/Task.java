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
    private final Long id;
    private final String title;
    private final String description;
    private final boolean completed;
    private final LocalDate createdAt;

    public Task(Long id, String title, String description, boolean completed, ZonedDateTime timestamp) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = timestamp.toLocalDate();
    }

}
