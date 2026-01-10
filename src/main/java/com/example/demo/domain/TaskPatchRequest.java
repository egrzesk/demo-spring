package com.example.demo.domain;

public record TaskPatchRequest(
            String title,
            boolean completed
    ) {}

