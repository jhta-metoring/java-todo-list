package org.homework;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 할 일 관리를 위한 HashMap 생성
        HashMap<Integer, String> todoMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int idCounter = 1; // 고유 ID를 위한 카운터

        while (true) {
            // 사용자에게 옵션 표시
            System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": // 할 일 추가
                    System.out.println("추가할 할 일을 입력하세요:");
                    String task = scanner.nextLine();
                    todoMap.put(idCounter, task);
                    System.out.println("할 일이 추가되었습니다. ID: " + idCounter);
                    idCounter++;
                    break;

                case "2": // 할 일 삭제
                    System.out.println("삭제할 할 일의 ID를 입력하세요:");
                    try {
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        if (todoMap.containsKey(deleteId)) {
                            todoMap.remove(deleteId);
                            System.out.println("할 일이 삭제되었습니다. ID: " + deleteId);
                        } else {
                            System.out.println("해당 ID의 할 일이 없습니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    }
                    break;

                case "3": // 할 일 조회
                    System.out.println("조회할 할 일의 ID를 입력하세요:");
                    try {
                        int viewId = Integer.parseInt(scanner.nextLine());
                        if (todoMap.containsKey(viewId)) {
                            System.out.println("할 일 ID: " + viewId + " 내용: " + todoMap.get(viewId));
                        } else {
                            System.out.println("해당 ID의 할 일이 없습니다.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    }
                    break;

                case "4": // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;

                default: // 잘못된 입력
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}
