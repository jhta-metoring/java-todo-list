package org.homework;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int getOption() {
        System.out.print("옵션을 선택하세요: ");
        return Integer.parseInt(sc.nextLine());
    }

    public static String getDescription() {
        System.out.print("추가할 할 일을 입력하세요: ");
        return sc.nextLine().trim();
    }

    public static int getId() {
        System.out.print("할 일의 ID를 입력하세요: ");
        return Integer.parseInt(sc.nextLine());
    }
}
