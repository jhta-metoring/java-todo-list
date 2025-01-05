package org.homework;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String title;
    private String description;
    private LocalDate dueDate;

    public Todo(int id, String title, String description, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return String.format("[ID: %d] %s (마감일: %s)\n설명: %s", id, title, dueDate, description);
    }
}



