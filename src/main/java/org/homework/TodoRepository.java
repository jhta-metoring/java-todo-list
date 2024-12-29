package org.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TodoRepository {
    private final HashMap<String, Todo> todo;
    private int idCount;

    public TodoRepository() {
        this.todo = new HashMap<>();
        this.idCount = 1;
    }

    public String addId() {
        return String.valueOf(idCount++);
    }

    public void add(Todo todo) {
        this.todo.put(todo.getId(), todo);
    }

    public List<Todo> findAll() {
        return new ArrayList<>(todo.values());
    }

    public Todo findById(String id) {
        return todo.get(id);
    }

    public boolean deleteById(String id) {
        if (todo.containsKey(id)) {
            todo.remove(id);
            return true;
        }
        return false;
    }
}
