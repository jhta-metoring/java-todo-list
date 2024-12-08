package org.homework;

import java.util.HashMap;
import java.util.Scanner;

public class TodoList {
    public static void main(String[] args) {
        HashMap<Integer, String> list = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int count = 1;

        while (true) {
            System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("추가할 할 일을 입력하세요: ");
                    String addList = scanner.nextLine();
                    list.put(count, addList);
                    System.out.println("할 일이 추가되었습니다. ID: " + count);
                    count++;
                    break;

                case "2":
                    System.out.print("삭제할 할 일의 ID를 입력하세요: ");
                    try {
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        if (list.get(deleteId) != null) {
                            System.out.println("삭제된 할 일: " + list.get(deleteId));
                            list.remove(deleteId);
                        } else {
                            System.out.println("해당 ID의 할 일이 없습니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                    }
                    break;

                case "3":
                    System.out.print("조회할 할 일의 ID를 입력하세요: ");
                    try {
                        int selectId = Integer.parseInt(scanner.nextLine());
                        String toDo = list.get(selectId);
                        if (toDo != null) {
                            System.out.println("할 일 ID: " + selectId + " 내용: " + toDo);
                        } else {
                            System.out.println("해당 ID의 할 일이 없습니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                    }
                    break;

                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}
