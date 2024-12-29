package org.homework.main;

import org.homework.controller.TodoController;
import org.homework.domain.TodoRepository;
import org.homework.service.TodoService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws Exception {

    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      // 출력내용에 줄바꿈이 필요하다면 newLine 함수를 사용합니다.

      InputView input = new InputView(br, bw);
      // inputView 에 Standard inputStream in 의존성 주입하고 인스턴스 생성

      OutputView output = new OutputView(br, bw);
      // outputView 에 Standard outputStream out 의존성 주입하고 인스턴스 생성

      TodoRepository repo = new TodoRepository();
      // dao 역할을 할 TodoRepository 인스턴스 생성
      TodoService serviceImpl = new TodoService(repo);
      // TodoRepository 의존성 주입하고 TodoService 인스턴스 생성

      TodoController controller = new TodoController(input, output, serviceImpl);
      // Controller 에 필요한 클래스 의존성 주입하고 Controller 인스턴스 생성

      controller.run();
      // run 실행

    } catch (Exception e) { // Controller 에서 처리되지 못한 예외 정보 출력하고 프로그램 종료
      e.printStackTrace();
      System.out.println("비정상적인 종료입니다.");
    }
  }
}