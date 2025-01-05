package org.homework;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public List<Todo> getUpcomingTodos() {
        return repository.findAll().stream()
                .filter(todo -> !todo.getDueDate().isBefore(LocalDate.now()) &&
                        !todo.getDueDate().isAfter(LocalDate.now().plusDays(7)))
                .sorted((t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate()))
                .collect(Collectors.toList());
    }

    public void addTodo(Todo todo) {
        repository.save(todo);
    }

    public List<Todo> searchTodosByKeyword(String keyword) {
        return repository.findByKeyword(keyword).stream()
                .sorted((t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate()))
                .collect(Collectors.toList());
    }
}