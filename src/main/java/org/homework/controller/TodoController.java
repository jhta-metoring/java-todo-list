package org.homework.controller;

import org.homework.domain.Todo;
import org.homework.main.InputView;
import org.homework.main.OutputView;
import org.homework.service.TodoService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Pattern;

import static org.homework.main.Options.*;

public class TodoController {
  private InputView inputView;
  private OutputView outputView;
  private TodoService serviceImpl;

  public TodoController(InputView inputView, OutputView outputView, TodoService serviceImpl) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.serviceImpl = serviceImpl;
  }

  public void run() throws IOException{

    try {
      outputView.printMenu();
      String input = inputView.input();

      if (input.equals(ADD.getName())) {
        addTodo();
      } else if(input.equals(SEARCH.getName())) {
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
        run();
      }
    } catch (IOException ie) {
      outputView.printError(ie);
      run();
    }
  }

  private void addTodo() throws IOException {
    Todo todo = todoForm();

    // 비즈니스 로직 거치면서 todo 인스턴스에 필요한 정보 갱신하여 반환 받는다.
    todo = serviceImpl.insertTodo(todo);

    outputView.print("정상 등록되었습니다.");

    outputView.printTodo(todo); // 등록한 할 일 정보 출력

    run(); // 다시 run() 호출
  }

  // 할 일 정보 입력
  private Todo todoForm() throws IOException {
    Todo todo = new Todo();

    outputView.print("할 일의 이름을 입력하세요");
    String name = inputView.input();
    todo.setName(name);

    outputView.print("할 일의 내용을 입력하세요");
    String description = inputView.input();
    todo.setDescription(description);

    outputView.print("마감일을 입력하세요 (ex: 2024-12-22)");
    String dueDate = inputView.input();

    LocalDate due = dateValdiationCheck(dueDate); // 마감일 유효성 검사하여 리턴

    todo.setDue_date(due);

    return todo;
  }

  // 마감일 유효성 검사 메서드
  private LocalDate dateValdiationCheck(String dueDate) throws IOException {

    // 입력 받은 문자열을 LocalDate 로 바꾸기 위한 LocalDateFormatter
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // 입력 받은 문자열이 yyyy-MM-dd 인지 체크하는 정규 표현식
    String regEx = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[0-1])$";
    Pattern pattern = Pattern.compile(regEx);

    LocalDate due = null;

    while (true) {

      // 날짜 형식에 맞는 입력이 아닐 경우 다시 입력
      if (!pattern.matcher(dueDate).matches()) {
        outputView.print("날짜 형식에 맞게 입력해주세요 (ex: 2024-12-22)");
        dueDate = inputView.input();
        continue;
      }

      // LocalDate 인스턴스 생성 시 실제하지 않는 날짜일 경우 예외 처리 및 다시 입력
      try {
        due = LocalDate.parse(dueDate, formatter);
      } catch (DateTimeParseException dtpe) {
        outputView.print("올바르지 않은 날짜입니다. 다시 입력해주세요");
        dueDate = inputView.input();
        continue;
      }

      // 마감일이 현재 날짜보다 이전일 경우 다시 입력
      if (!due.isAfter(LocalDate.now())) {
        outputView.print("마감일은 등록일 이후이어야 합니다. 다시 입력해주세요");
        dueDate = inputView.input();
        continue;
      }

      // 유효성 체크 통과 시 loop 탈출
      break;
    }

    return due;
  }

  private void searchTodo() throws IOException {
    outputView.print("검색어를 입력하세요");
    outputView.print("[ id, 이름, 내용, 등록일, 마감일(yyyy-mm-dd) ]");

    String word = inputView.input();
    
    List<Todo> list = getSearchList(word);
    if (list.size() > 0) {
      outputView.printList(list);
    } else {
      outputView.print("검색 결과가 존재하지 않습니다.");
    }

    run();
  }

  private List<Todo> getSearchList(String word) {
    return serviceImpl.getSearchList(word);
  }

  private void editTodo() throws IOException {
    outputView.print("수정할 할일의 id 를 입력하세요");

    String id = inputView.input();

    Todo edit = serviceImpl.getTodoById(id);

    if (edit == null) {
      outputView.print("해당하는 할 일이 없습니다. 메뉴로 돌아갑니다.");
      run();
    }

    outputView.print("==========수정할 할일==========");
    outputView.printTodo(edit);
    String[] input = new String[3];

    // 수정하려는 Todo 는 service 에서 처리
    outputView.print("새 이름을 입력하세요 (그대로 두려면 Enter)");
    input[0] = inputView.input();
    outputView.print("새 내용을 입력하세요 (그대로 두려면 Enter)");
    input[1] = inputView.input();
    outputView.print("새 마감일을 입력하세요 (그대로 두려면 Enter)");
    input[2] = inputView.input();
    LocalDate new_due = null;
    if (!input[2].trim().isEmpty()) {
      new_due = dateValdiationCheck(input[2]);
    }

    edit = serviceImpl.editTodo(input, new_due, edit);

    outputView.print("==========수정된 할일==========");
    outputView.printTodo(edit);

    run();
  }

  private void selectAll() throws IOException {
    outputView.print("==========할 일 전체 출력==========");
    List<Todo> list = serviceImpl.select_all();
    if (list.isEmpty()) {
      outputView.print("입력된 할 일이 없습니다.");
    } else {
      outputView.printList(list);
    }

    run();
  }

  private void delete() throws IOException{
    outputView.print("삭제하고자 하는 id를 입력하세요");
    String id = inputView.input();

    boolean delete_success = serviceImpl.delete(id);

    if (delete_success) {
      outputView.print("삭제에 성공했습니다.");
    } else {
      outputView.print("삭제에 실패했습니다.");
    }

    run();
  }

  private void todoDone() throws IOException {
    outputView.print("완료할 할 일의 id 를 입력하세요");
    String id = inputView.input();
    boolean done_success = serviceImpl.todoDone(id);
    if (!done_success) {
      outputView.print("완료 처리 실패");
    } else {
      outputView.print("완료 처리 성공");
    }
      run();
  }

  private void exit() throws IOException {
    outputView.printExit();
    System.exit(0);
  }

}
