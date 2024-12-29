package org.homework.controller;

import org.homework.domain.Todo;
import org.homework.main.InputView;
import org.homework.main.OutputView;
import org.homework.service.TodoService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.homework.main.Options.*;

public class TodoController {
  private InputView inputView;
  private OutputView outputView;
  private TodoService todoService;

  public TodoController(InputView inputView, OutputView outputView, TodoService todoService) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.todoService = todoService;
  }

  /*
    컨트롤러는 데이터를 주고 받는 작업만 수행.
   */

  public void run() throws IOException {
    while (true) {
      try {
        outputView.printMenu();
        String input = inputView.input();

        if (input.equals(ADD.getName())) {
          addTodo();
        } else if (input.equals(SEARCH.getName())) {
          searchTodo();
        } else if (input.equals(EDIT.getName())) {
          editTodo();
        } else if (input.equals(ALL.getName())) {
          selectAll();
        } else if (input.equals(DELETE.getName())) {
          delete();
        } else if (input.equals(DONE.getName())) {
          todoDone();
        } else if (input.equals(EXIT.getName())) {
          exit();
        } else {
          outputView.print("올바르지 않은 입력입니다. 다시 입력해주세요.");
        }
      } catch (IOException ie) {
        outputView.printError(ie);
      }
    }
  }

  private void addTodo() throws IOException {
    Todo todo = inputView.todoForm();

    // 비즈니스 로직 거치면서 todo 인스턴스에 필요한 정보 갱신하여 반환 받는다.
    todo = todoService.insertTodo(todo);

    outputView.printAddResult(todo);
  }


  private void searchTodo() throws IOException {

    String word = inputView.inputSearch();

    List<Todo> list = todoService.getSearchList(word);

    outputView.printSearch(list);
  }

  private void editTodo() throws IOException {

    String id = inputView.getId();

    Optional<Todo> opt = todoService.getTodoById(id);

    opt = inputView.editTodo(opt);

    outputView.printEditTodo(opt);
  }

  private void selectAll() throws IOException {

    List<Todo> list = todoService.select_all();

    outputView.printAll(list);
  }

  private void delete() throws IOException {
    String id = inputView.getDeleteId();

    boolean delete_success = todoService.delete(id);

    outputView.printDeleteResult(delete_success);
  }

  private void todoDone() throws IOException {
    String id = inputView.getEditId();
    boolean done_success = todoService.todoDone(id);

    outputView.printDoneResult(done_success);
  }

  // 프로그램 종료
  private void exit() throws IOException {
    outputView.printExit();
    System.exit(0);
  }

}
