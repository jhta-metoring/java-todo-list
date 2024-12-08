package org.homework;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> todoList = new HashMap<>();
        int nextId = 1;

        while (true) {
            System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.println("추가할 할 일을 입력하세요:");
                    String task = sc.nextLine();
                    todoList.put(nextId, task);
                    System.out.println("할 일이 추가되었습니다. ID: " + nextId);
                    nextId++;
                    break;

                case "2":
                    System.out.println("삭제할 할 일의 ID를 입력하세요:");
                    try {
                        int deleteId = Integer.parseInt(sc.nextLine());
                        if (todoList.containsKey(deleteId)) {
                            todoList.remove(deleteId);
                            System.out.println("할 일이 삭제되었습니다. ID: " + deleteId);
                        } else {
                            System.out.println("해당 ID의 할 일이 없습니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    }
                    break;

                case "3":
                    System.out.println("조회할 할 일의 ID를 입력하세요:");
                    try {
                        int viewId = Integer.parseInt(sc.nextLine());
                        if (todoList.containsKey(viewId)) {
                            System.out.println("할 일 ID: " + viewId + " 내용: " + todoList.get(viewId));
                        } else {
                            System.out.println("해당 ID의 할 일이 없습니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    }
                    break;

                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
