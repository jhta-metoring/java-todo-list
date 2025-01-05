package org.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TodoRepository {
    private final List<Todo> todos = new ArrayList<>();

    public List<Todo> findAll() {
        return new ArrayList<>(todos);
    }

    public void save(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> findByKeyword(String keyword) {
        return todos.stream()
                .filter(todo -> todo.getTitle().contains(keyword) || todo.getDescription().contains(keyword))
                .collect(Collectors.toList());
    }
}