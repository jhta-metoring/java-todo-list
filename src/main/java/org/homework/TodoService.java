package org.homework;

import java.util.Optional;

public class TodoService {
    private final TodoRepository todoRepository = new TodoRepository();

    public Todo addTodo(String contents) {
        return todoRepository.save(contents);
    }

    public Todo getTodo(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 할 일이 없습니다."));
    }

    public void removeTodo(long id) {
        Todo todo = getTodo(id);
        todoRepository.deleteById(todo.getId());
    }
}
