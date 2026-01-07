package com.example.demo.adapters;

import com.example.demo.application.DateTimeProvider;

import java.time.ZonedDateTime;

public class SystemDateTimeProvider implements DateTimeProvider {
    @Override
    public ZonedDateTime getZonedDateTime() {
        return ZonedDateTime.now();
    }
}
