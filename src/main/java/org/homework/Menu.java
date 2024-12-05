package org.homework;

import java.io.BufferedReader;
import java.io.IOException;

public class Menu {

  private final String[] OPTIONS = {"추가", "삭제", "조회", "전체 조회", "종료"};

  public String getOPTION(int i) {
    return this.OPTIONS[i];
  }

  public void printOption() {
    System.out.print("옵션을 선택하세요: ");

    for (int cnt = 0; cnt < OPTIONS.length - 1; cnt++) {
      System.out.print(cnt + 1 + "."+ OPTIONS[cnt] + ", ");
    }
    System.out.println(OPTIONS.length + "." + OPTIONS[OPTIONS.length - 1]);
  }

  public int selectOption(BufferedReader br) throws Exception {
    try {
      return Integer.parseInt(br.readLine());
    } catch (NumberFormatException nfe) {
      //nfe.printStackTrace();
      throw new Exception("잘못된 입력입니다." /* + nfe.getMessage() */);
    } catch (IOException ie) {
      //ie.printStackTrace();
      throw new Exception("메뉴 입력 실패" /* + ie.getMessage() */);
    }
  }
}
