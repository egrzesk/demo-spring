package com.example.demo.adapters;

import com.example.demo.application.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class SystemDateTimeProvider implements DateTimeProvider {
    @Override
    public ZonedDateTime getZonedDateTime() {
        return ZonedDateTime.now();
    }
}
