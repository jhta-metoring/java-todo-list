package org.homework;

import java.io.*;
import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<Integer, String> toDo = new HashMap<>();
    Menu menu = new Menu();
    Process process = new Process(menu);

    while (true) {
      menu.printOption();
      try {
        process.process(menu.selectOption(br), br, toDo);
      } catch (Exception e) {
        //e.printStackTrace();
        if (e.getMessage() != null) {
          System.out.println(e.getMessage());
        } else {
          e.printStackTrace();
          System.out.println("===== 예외 처리 추가 필요 =====");
        }
      }
    }
  }
}