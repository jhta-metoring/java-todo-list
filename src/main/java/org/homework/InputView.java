package org.homework;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getMenuOperation() {
        System.out.print("옵션을 선택하세요 >");
        return scanner.nextLine();
    }

    public String getTodoContent() {
        System.out.print("할 일 내용을 입력하세요: ");
        return scanner.nextLine();
    }

    public String getTodoId() {
        System.out.print("할 일의 ID를 입력하세요: ");
        return scanner.nextLine();
    }

    public String getSelectId() {
        System.out.print("조회할 할 일의 ID를 입력하세요: ");
        return scanner.nextLine();
    }

    public void exit() {
        scanner.close();
    }
}