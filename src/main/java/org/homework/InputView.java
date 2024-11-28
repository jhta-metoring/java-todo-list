package org.homework;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputMenu() {
        System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
        return scanner.nextLine();
    }

    public String inputTodo() {
        System.out.print("할 일 입력: ");
        return scanner.nextLine();
    }

    public String inputDelete() {
        System.out.print("삭제하고 싶은 할 일의 고유 번호(ID)를 입력: ");
        return scanner.nextLine();
    }

    public String inputView() {
        System.out.print("조회하고자 하는 할 일의 고유 번호(ID)를 입력: ");
        return scanner.nextLine();
    }
}
