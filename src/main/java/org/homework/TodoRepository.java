package org.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TodoRepository {
    private final HashMap<String, Todo> toDo;
    private int IdCount;

    public TodoRepository() {
        this.toDo = new HashMap<>();
        this.IdCount = 1;
    }

    public String AddId() {
        return String.valueOf(IdCount++);
    }

    public void add(Todo todo) {
        toDo.put(todo.getId(), todo);
    }

    public List<Todo> findAll() {
        return new ArrayList<>(toDo.values());
    }

    public Todo findById(String id) {
        return toDo.get(id);
    }

    public boolean deleteById(String id) {
        if (toDo.containsKey(id)) {
            toDo.remove(id);
            return true;
        }
        return false;
    }
}
