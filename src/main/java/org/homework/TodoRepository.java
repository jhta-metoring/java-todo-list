package org.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TodoRepository {
    private final Map<Long, Todo> maps = new HashMap<>();
    private Long id = 1L;

    public Todo save(String contents) {
        Todo todo = new Todo(id++, contents);
        maps.put(todo.getId(), todo);
        return todo;
    }

    public Optional<Todo> findById(Long id) {
        Todo todo = maps.get(id);
        return Optional.ofNullable(todo);
    }

    public void deleteById(Long id) {
        maps.remove(id);
    }
}
