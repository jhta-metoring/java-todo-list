package org.homework;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        return scanner.nextLine();
    }

    public String getTodoDescription() {
        System.out.println("추가할 할 일을 입력하세요:");
        return scanner.nextLine();
    }

    public int getTodoId(String action) {
        System.out.println(action + "할 할 일의 ID를 입력하세요:");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            return -1;
        }
    }
}