package org.homework;

import java.util.HashMap;
import java.util.Map;

public class TodoRepository {
    private final Map<Integer, Todo> todoList = new HashMap<>();
    private int nextId = 1;

    public Todo add(String description) {
        Todo todo = new Todo(nextId++, description);
        todoList.put(todo.getId(), todo);
        return todo;
    }

    public Todo findById(int id) {
        return todoList.get(id);
    }

    public Todo delete(int id) {
        return todoList.remove(id);
    }

    public Map<Integer, Todo> findAll() {
        return new HashMap<>(todoList);
    }
}
