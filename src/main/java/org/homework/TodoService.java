package org.homework;

import java.util.List;

public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public void addTodo(String content) {
        String id = repository.AddId();
        Todo todo = new Todo(id, content);
        repository.add(todo);
    }

    public List<Todo> getToDoList() {
        return repository.findAll();
    }

    public boolean completeTodoById(String id) {
        Todo todo = repository.findById(id);
        if (todo != null) {
            todo.Completed();
            return true;
        }
        return false;
    }

    public boolean deleteTodoById(String id) {
        return repository.deleteById(id);
    }
}