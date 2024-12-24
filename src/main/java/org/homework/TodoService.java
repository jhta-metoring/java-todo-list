package org.homework;

import java.util.Map;

public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo addTodo(String description) {
        return repository.add(description);
    }

    public Todo findTodoById(int id) {
        return repository.findById(id);
    }

    public Todo deleteTodoById(int id) {
        return repository.delete(id);
    }

    public Map<Integer, Todo> getAllTodos() {
        return repository.findAll();
    }

    public boolean completeTodoById(int id) {
        Todo todo = repository.findById(id);
        if (todo != null) {
            todo.complete();
            return true;
        }
        return false;
    }
}
