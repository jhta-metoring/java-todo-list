package org.homework;

import java.util.List;

public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public void addTodo(String content) {
        String id = repository.addId();
        Todo todo = new Todo(id, content);
        repository.add(todo);
    }

    public List<Todo> getToDoList() {
        return repository.findAll();
    }

    public String completeTodoById(String id) {
        Todo todo = repository.findById(id);
        if (todo != null) {
            todo.Completed();
            return "할 일이 완료되었습니다.";
        }
        return "해당 ID의 할 일을 찾을 수 없습니다.";
    }

    public String deleteTodoById(String id) {
        boolean deleteResult = repository.deleteById(id);
        return deleteResult ? "할 일이 삭제되었습니다." : "해당 ID의 할 일이 없습니다.";
    }

    public String getTodoById(String id) {
        Todo todo = repository.findById(id);
        if (todo != null) {
            return todo.toString();
        }
        return "해당 ID의 할 일이 없습니다.";
    }
}