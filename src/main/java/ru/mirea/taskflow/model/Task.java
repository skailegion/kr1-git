package ru.mirea.taskflow.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private final String title;
    private final String priority;
    private final String author;
    private final String startedAt;
    private String finishedAt;
    private long durationMinutes;
    private transient LocalDateTime startTime;

    private Task(Builder builder) {
        this.title = builder.title;
        this.priority = builder.priority;
        this.author = builder.author;
        this.startTime = LocalDateTime.now().minusMinutes(builder.simulatedMinutes);
        this.startedAt = this.startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public void finish() {
        LocalDateTime endTime = LocalDateTime.now();
        this.finishedAt = endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.durationMinutes = Duration.between(startTime, endTime).toMinutes();
    }

    public static class Builder {
        private final String title;
        private String priority = "MEDIUM";
        private String author = "Student";
        private long simulatedMinutes = 45;

        public Builder(String title) { this.title = title; }
        public Builder priority(String priority) { this.priority = priority; return this; }
        public Builder author(String author) { this.author = author; return this; }
        public Builder workedMinutes(long minutes) { this.simulatedMinutes = minutes; return this; }
        public Task build() { return new Task(this); }
    }
}
