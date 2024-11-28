package org.homework;

public class Todo {
    private Long id;
    private String contents;

    public Todo(Long id, String contents) {
        this.id = id;
        this.contents = contents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return String.format("할 일 ID: %d, 내용: %s", id, contents);
    }
}
