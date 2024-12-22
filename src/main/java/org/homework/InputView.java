package org.homework;

import java.util.Scanner;

public class InputView {
    public String getMenuOperation(Scanner scanner) {
        System.out.print("옵션을 선택하세요 1) 추가, 2) 조회, 3) 완료, 4) 삭제, 5) 종료: ");
        return scanner.nextLine();
    }

    public String getTodoContent(Scanner scanner) {
        System.out.print("할 일 내용을 입력하세요: ");
        return scanner.nextLine();
    }

    public String getTodoId(Scanner scanner) {
        System.out.print("완료할 일의 ID를 입력하세요: ");
        return scanner.nextLine();
    }


}