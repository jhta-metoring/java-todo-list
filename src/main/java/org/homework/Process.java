package org.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Process {
  private final Menu menu;

  public Process(Menu menu) {
    this.menu = menu;
  }

  public void process(int i, BufferedReader br, HashMap<Integer, String> toDo) throws Exception {
    String option = menu.getOPTION(i - 1);

    try {
      switch (option) {
        case "추가" -> {
          System.out.println(i + "." + option);
          System.out.println("할 일을 입력하세요>");

          if (toDo.isEmpty()) {
            toDo.put(1, br.readLine());
          } else {
            Object[] keys = toDo.keySet().stream().sorted().toArray();
            toDo.put((Integer) keys[toDo.size() - 1] + 1, br.readLine());
          }
        }

        case "삭제" -> {
          System.out.println(i + "." + option);
          System.out.println("삭제하고자 하는 ID를 입력하세요");
          int selectedID = Integer.parseInt(br.readLine());
          System.out.println(selectedID + ". " + toDo.get(selectedID) + " 를 삭제합니다.");
          toDo.remove(selectedID);
        }

        case "조회" -> {
          System.out.println(i + "." + option);
          System.out.println("조회하고자 하는 ID를 입력하세요");
          System.out.println(toDo.getOrDefault(Integer.parseInt(br.readLine()), "해당 ID의 할 일이 없습니다."));
        }

        case "전체 조회" -> {
          System.out.println(i + "." + option);

          if (toDo.isEmpty()) {
            System.out.println("현재 추가된 할 일이 없습니다.");
          } else {
            for (int key : toDo.keySet()) {
              System.out.println(key + ". " + toDo.get(key));
            }
          }
        }

        case "종료" -> {
          System.out.println(i + "." + option);
          System.out.println("프로그램을 종료합니다.");
          System.exit(0);
        }

      }
    } catch (IOException ie) {
      throw new Exception(ie.getMessage());

    }
  }
}
