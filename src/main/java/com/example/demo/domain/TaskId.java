package com.example.demo.domain;

import java.util.UUID;
import static java.util.UUID.randomUUID;

public record TaskId(UUID value) {
    public TaskId() {
        this(randomUUID());
    }
}
