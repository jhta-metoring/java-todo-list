package org.homework;

public class Todo {
    private final String id;
    private final String content;
    private boolean completed;

    public Todo(String id, String content) {
        this.id = id;
        this.content = content;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean checkCompleted() {
        return completed;
    }

    public void Completed() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "ID_"+ id+ ")" +content + (completed ? " [완료]" : " [미완료]");
    }

}
