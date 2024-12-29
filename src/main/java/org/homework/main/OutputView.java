package org.homework.main;

import org.homework.domain.Todo;

import java.io.*;
import java.util.List;
import java.util.Optional;

/*
  컨트롤러로부터 넘겨 받은 데이터를 가지고 결과 출력
 */
public class OutputView {

  private BufferedReader br;
  private BufferedWriter bw;

  public OutputView(BufferedReader br, BufferedWriter bw) {
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

  public void printError(Exception e) {
    try {

      if (e.getMessage() != null) {
        bw.write(e.getMessage());
        bw.flush();
      } else {
        bw.write("추가 정보가 필요합니다.");
        bw.flush();
      }

    } catch (Exception e2) {
      e2.printStackTrace();
      System.out.println("printError() 에러" + e.getMessage());
    }
  }

  public void printMenu() throws IOException {
    String[] menu = {"1.추가", "2.검색", "3.수정", "4.전체 조회", "5.삭제", "6.완료", "7.종료"};
    print("=========메뉴를 선택하세요=========");
    for (String m : menu) {
      bw.write(m + "\n");
    }
    print("===============================");
  }

  public void printExit() throws IOException {
    print("프로그램을 종료합니다.");
  }

  public void printList(List<Todo> list) throws IOException {
    for (Todo todo : list) {
      print(todo.toString());
      print("==============================");
    }
  }

    public void printEditTodo(Optional<Todo> opt) throws IOException {
      if (opt.isPresent()) {
        print("==========수정된 할일==========");
        print(opt.get()
                  .toString());
      } else {
        print("==========수정에 실패했습니다.==========");
      }
    }

  public void printAddResult(Todo todo) throws IOException {
    print("정상 등록되었습니다.");

    print(todo.toString()); // 등록한 할 일 정보 출력

  }

  public void printSearch(List<Todo> list) throws IOException {
    if (list.size() > 0) {
      printList(list);
    } else {
      print("검색 결과가 존재하지 않습니다.");
    }
  }

  public void printAll(List<Todo> list) throws IOException {
    print("==========할 일 전체 출력==========");

    if (list.isEmpty()) {
      print("입력된 할 일이 없습니다.");
    } else {
      printList(list);
    }
  }

  public void printDeleteResult(boolean deleteSuccess) throws IOException {
    if (deleteSuccess) {
      print("삭제에 성공했습니다.");
    } else {
      print("삭제에 실패했습니다.");
    }
  }

  public void printDoneResult(boolean doneSuccess) throws IOException {
    if (!doneSuccess) {
      print("완료 처리 실패");
    } else {
      print("완료 처리 성공");
    }
  }
}
