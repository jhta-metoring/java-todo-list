package org.homework.service;

import org.homework.domain.Todo;
import org.homework.domain.TodoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    Optional<Todo> todo = dao.getTodoById(id);
    if (todo.isEmpty()) {
      return false;
    } else {
      dao.todoDone(id);
      return true;
    }
  }

  public Todo editTodo(Todo edit) {
    // 레포지토리에서 검색하여 가져온 Todo 의 인스턴스에 대한 참조가 계속 유지되어 inputView 에서 Todo의 정보를 수정하면
    // TodoRepository 의 정보도 바뀌어서 service 나 Repository 에서 추가 작업을 할 필요가 없어 일단 추가 작업 없이 놔둔 상태
    return edit;
  }

  public Optional<Todo> getTodoById(String id) {
    return dao.getTodoById(id);
  }
}
