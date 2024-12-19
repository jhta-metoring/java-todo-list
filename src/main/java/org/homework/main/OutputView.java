package org.homework.main;

import org.homework.domain.Todo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputView {

  private BufferedWriter bw;

  public OutputView(OutputStream out) {
    this.bw = new BufferedWriter(new OutputStreamWriter(out));
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
    bw.write("=========메뉴를 선택하세요=========\n");
    for (String m : menu) {
      bw.write(m + "\n");
    }
    bw.write("===============================\n");
    bw.flush();
  }

  public void printExit() throws IOException {
    bw.write("프로그램을 종료합니다.");
    bw.flush();
  }


  public void printTodo(Todo todo) throws IOException {
    bw.write("id : " + todo.getId() + "\n"
            + "할 일 이름 : " + todo.getName() + "\n"
            + "할 일의 내용 : "+ todo.getDescription() +"\n"
            + "완료 여부 : " + (todo.isDone() ? "[완료]" : "[미완료]") + "\n"
            + "생성일 : " + todo.getReg_dateString() + "\n"
            + "마감일 : " + todo.getDue_dateString() + "\n" );

    bw.flush();
  }

  public void printList(List<Todo> list) throws IOException {
    for (Todo todo : list) {
      printTodo(todo);
      bw.write("==============================\n");
    }
  }
}
