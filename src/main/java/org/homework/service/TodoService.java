package org.homework.service;

import org.homework.domain.Todo;
import org.homework.domain.TodoRepository;

import java.time.LocalDate;
import java.util.List;

public class TodoService {

  private TodoRepository dao;

  public TodoService(TodoRepository dao) {
    this.dao = dao;
  }

  // dao 에서 id 및 등록일 입력받은 todo Controller 에 반환
  public Todo insertTodo(Todo todo) {
    todo = dao.insert(todo);
    return todo;
  }

  public List<Todo> getSearchList(String word) {
    return dao.getSearchList(word);
  }

  public List<Todo> select_all() {
    return dao.select_all();
  }

  public boolean delete(String id) {
    int result = dao.delete(id);
    if (result == 1) {
      return true;
    } else {
      return false;
    }
  }

  public boolean todoDone(String id) {
    Todo todo = dao.getTodoById(id);
    if (todo == null) {
      return false;
    } else {
      dao.todoDone(id);
      return true;
    }
  }

  public Todo editTodo(String[] input, LocalDate new_due, Todo edit) {

    if(!input[0].trim().isEmpty()) {
      edit.setName(input[0]);
    }

    if(!input[1].trim().isEmpty()) {
      edit.setDescription(input[1]);
    }

    if(!input[2].trim().isEmpty() && new_due != null) {
      edit.setDue_date(new_due);
    }

    return edit;
  }

  public Todo getTodoById(String id) {
    return dao.getTodoById(id);
  }
}
