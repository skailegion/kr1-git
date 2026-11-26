package ru.mirea.taskflow.model;

public class Task {
    private final String title;
    private final String priority;
    private final String author;

    private Task(Builder builder) {
        this.title = builder.title;
        this.priority = builder.priority;
        this.author = builder.author;
    }

    public static class Builder {
        private final String title;
        private String priority = "MEDIUM";
        private String author = "Student";

        public Builder(String title) { this.title = title; }
        public Builder priority(String priority) { this.priority = priority; return this; }
        public Builder author(String author) { this.author = author; return this; }
        public Task build() { return new Task(this); }
    }
}
