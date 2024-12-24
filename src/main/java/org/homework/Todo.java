package org.homework;

public class Todo {
    private final int id;
    private final String description;
    private boolean isCompleted;

    public Todo(int id, String description) {
        this.id = id;
        this.description = description;
        this.isCompleted = false; // 기본 상태: 미완료
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void complete() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", 내용: " + description + ", 상태: " + (isCompleted ? "[완료]" : "[미완료]");
    }
}
