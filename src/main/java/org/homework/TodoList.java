package org.homework;

import java.util.HashMap;
import java.util.Scanner;

public class TodoList {
    public static void main(String[] args) {
        HashMap<Integer, String> todoList = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int count = 1;

        while (true) {
            System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
            String input = scanner.nextLine();
            EnumClass operation = EnumClass.fromInput(input);

            switch (operation) {
                case Add:
                    System.out.print("추가할 할 일을 입력하세요: ");
                    String todo = scanner.nextLine();
                    todoList.put(count, todo);
                    System.out.println("할 일이 추가되었습니다. ID: " + count);
                    count++;
                    break;

                case Delete:
                    System.out.print("삭제할 할 일의 ID를 입력하세요: ");
                    try {
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        if (todoList.containsKey(deleteId)) {
                            System.out.println("삭제된 할 일: " + todoList.get(deleteId));
                            todoList.remove(deleteId);
                        } else {
                            System.out.println("해당 ID의 할 일이 없습니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                    }
                    break;

                case Select:
                    System.out.print("조회할 할 일의 ID를 입력하세요: ");
                    try {
                        int viewId = Integer.parseInt(scanner.nextLine());
                        if (todoList.containsKey(viewId)) {
                            System.out.println("할 일 ID: " + viewId + " 내용: " + todoList.get(viewId));
                        } else {
                            System.out.println("해당 ID의 할 일이 없습니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                    }
                    break;

                case Exit:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;

                case False:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                    break;

                default:
                    System.out.println("알 수 없는 오류가 발생했습니다.");
                    break;
            }
        }
    }
}