package org.homework.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoRepository {

  private ArrayList<Todo> list;

  public TodoRepository() {
    list = new ArrayList<>();
  }

  public Todo insert(Todo todo) {

    todo.setReg_date(LocalDate.now()); // 등록일 : default sysdate
    todo.setDone(false); // 완료 여부 : default false

    String id = "1";

    int size = list.size();

    // 1 또는 마지막 id + 1
    if (size != 0) {

      int last_id = Integer.parseInt(list.get(list.size() - 1).getId());

      id = Integer.toString(last_id + 1);
    }

    todo.setId(id);

    list.add(todo);

    return todo;
  }

  public List<Todo> select_all() {
    return list;
  }

  // stream.filter() 에서 사용할 메서드
  private static boolean predicate(Todo todo, String word) {

    if (todo.getId().equals(word)) { // id 로 검색
      return true;
    } else if (todo.getName().contains(word)) { // 이름으로 검색
      return true;
    } else if (todo.getDescription().contains(word)) { // 내용으로 검색
      return true;
    } else if (todo.getReg_dateString().equals(word)) { // 등록일로 검색
      return true;
    } else if (todo.getDue_dateString().equals(word)) { // 마감일로 검색
      return true;
    } else if (!todo.isDone() && "[미완료]".contains(word)) { // 미완료 여부로 검색
      return true;
    } else if (todo.isDone() && "[완료]".contains(word)) { // 완료 여부로 검색
      return true;
    } else {
      return false;
    }
  }

  // stream.filter() 에서 사용할 메서드2
  private static boolean predicate2(Todo todo, String id) {
    if (todo.getId().equals(id)) { // id 로 검색
      return true;
    } else {
      return false;
    }
  }

  public List<Todo> getSearchList(String word) {
    return list.stream().filter(Todo -> predicate(Todo, word)).collect(Collectors.toList());
  }


  public int delete(String id) {
    int total = list.size();
    this.list = (ArrayList<Todo>) list.stream().filter(Todo -> !predicate2(Todo, id)).collect(Collectors.toList());
    return total - list.size();
  }

  public void todoDone(String id) {
    this.list = (ArrayList<Todo>) list.stream().map(Todo -> {
      if (Todo.getId().equals(id)) {
        Todo.setDone(true);
      }
      return Todo;
    }).sorted(this::sortTodo).collect(Collectors.toList());
  }

  // 안 쓰일 지도
  private int sortTodo(Todo todo1, Todo todo2) {
    return Integer.parseInt(todo1.getId()) - Integer.parseInt(todo2.getId());
  }

  // 안 쓰일 지도
  public void sort() {
    this.list.sort(this::sortTodo);
  }

  public Todo getTodoById(String id) {
    List<Todo> result = this.list.stream().filter(Todo -> predicate2(Todo, id)).collect(Collectors.toList());
    if (!result.isEmpty()) {
      return result.get(0);
    } else {
      return null;
    }
  }
}


