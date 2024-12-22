package org.homework;

import java.util.HashMap;
import java.util.Optional;

public class TodoRepository {
    private final HashMap<Integer, Todo> todos = new HashMap<>();

    public void save(Todo todo) {
        todos.put(todo.getId(), todo);
    }

    public Optional<Todo> findById(int id) {
        return Optional.ofNullable(todos.get(id));
    }

    public void deleteById(int id) {
        todos.remove(id);
    }
}