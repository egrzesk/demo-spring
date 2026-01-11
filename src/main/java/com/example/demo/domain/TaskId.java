package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.UUID;
import static java.util.UUID.randomUUID;

public record TaskId(UUID value) {
    public TaskId() {
        this(randomUUID());
    }

    @JsonValue
    public String asString() { return value.toString(); }

    @Override
    public String toString() { return value.toString(); }

}
