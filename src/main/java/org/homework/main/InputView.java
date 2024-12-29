package org.homework.main;

import org.homework.domain.Todo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Optional;
import java.util.regex.Pattern;

/*
  사용자에게 입력을 받아 컨트롤러에 인스턴스를 전달
 */
public class InputView {
  private BufferedReader br;
  private BufferedWriter bw;

  public InputView(BufferedReader br, BufferedWriter bw) {
    this.br = br;
    this.bw = bw;
  }

  public String input() throws IOException {
    return br.readLine();
  }

  public void print(String output) throws IOException {
    try {
      bw.write(output + "\n");
      bw.flush();
    } catch (IOException ie) {
      ie.printStackTrace();
      throw ie;
    }
  }

  // 할 일 정보 입력
  public Todo todoForm() throws IOException {
    Todo todo = new Todo();

    print("할 일의 이름을 입력하세요");
    String name = input();
    todo.setName(name);

    print("할 일의 내용을 입력하세요");
    String description = input();
    todo.setDescription(description);

    print("마감일을 입력하세요 (ex: 2024-12-22)");
    String dueDate = input();

    LocalDate due = dateValdiationCheck(dueDate); // 마감일 유효성 검사하여 리턴

    todo.setDue_date(due);

    return todo;
  }

  // 마감일 유효성 검사 메서드
  public LocalDate dateValdiationCheck(String dueDate) throws IOException {

    // 입력 받은 문자열을 LocalDate 로 바꾸기 위한 LocalDateFormatter
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // 입력 받은 문자열이 yyyy-MM-dd 인지 체크하는 정규 표현식
    String regEx = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[0-1])$";
    Pattern pattern = Pattern.compile(regEx);

    LocalDate due = null;

    while (true) {

      // 날짜 형식에 맞는 입력이 아닐 경우 다시 입력
      if (!pattern.matcher(dueDate).matches()) {
        print("날짜 형식에 맞게 입력해주세요 (ex: 2024-12-22)");
        dueDate = input();
        continue;
      }

      // LocalDate 인스턴스 생성 시 실제하지 않는 날짜일 경우 예외 처리 및 다시 입력
      try {
        due = LocalDate.parse(dueDate, formatter);
      } catch (DateTimeParseException dtpe) {
        print("올바르지 않은 날짜입니다. 다시 입력해주세요");
        dueDate = input();
        continue;
      }

      // 마감일이 현재 날짜보다 이전일 경우 다시 입력
      if (!due.isAfter(LocalDate.now())) {
        print("마감일은 등록일 이후이어야 합니다. 다시 입력해주세요");
        dueDate = input();
        continue;
      }

      // 유효성 체크 통과 시 loop 탈출
      break;
    }

    return due;
  }

  public String getId() throws IOException {
    print("수정할 할일의 id 를 입력하세요");
    return input();
  }

  public Optional<Todo> editTodo(Optional<Todo> opt) throws IOException {
    Todo edit = null;
    if (opt.isEmpty()) {
      print("해당하는 할 일이 없습니다. 메뉴로 돌아갑니다.");
      return null;
    } else {
      edit = opt.get();
    }

    print("==========수정할 할일==========");
    print(edit.toString());

    // 수정하려는 Todo 는 service 에서 처리
    print("새 이름을 입력하세요 (그대로 두려면 Enter)");
    String new_name = input();

    if (!new_name.trim()
                    .isEmpty()) {
      edit.setName(new_name);
    }

    print("새 내용을 입력하세요 (그대로 두려면 Enter)");
    String new_desc = input();

    if (!new_desc.trim()
                    .isEmpty()) {
      edit.setDescription(new_desc);
    }

    print("새 마감일을 입력하세요 (그대로 두려면 Enter)");
    String new_due_str = input();
    if (!new_due_str.trim()
                    .isEmpty()) {
      LocalDate new_due = dateValdiationCheck(new_due_str);
      edit.setDue_date(new_due);
    }

    return opt;
  }

  public String inputSearch() throws IOException {
    print("검색어를 입력하세요");
    print("[ id, 이름, 내용, 등록일, 마감일(yyyy-mm-dd) ]");
    return input();
  }

  public String getDeleteId() throws IOException {
    print("삭제하고자 하는 id를 입력하세요");
    return input();
  }

  public String getEditId() throws IOException{
    print("완료할 할 일의 id 를 입력하세요");
    return input();
  }
}