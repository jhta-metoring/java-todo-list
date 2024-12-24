package org.homework;

import java.util.Optional;

public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public void addTodo(int id, String description) {
        Todo todo = new Todo(id, description);
        repository.save(todo);
    }

    public Optional<Todo> viewTodoById(int id) {
        return repository.findById(id);
    }

    public boolean deleteTodoById(int id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean markTodoAsCompleted(int id) {
        Optional<Todo> todo = repository.findById(id);
        if (todo.isPresent()) {
            todo.get().markAsCompleted();
            return true;
        }
        return false;
    }
}