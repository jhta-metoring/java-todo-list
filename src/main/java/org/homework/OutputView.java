package org.homework;

import java.util.Map;

public class OutputView {
    public static void showMenu() {
        System.out.println("\n========= 할 일 관리 프로그램 =========");
        System.out.println("1. 추가");
        System.out.println("2. 삭제");
        System.out.println("3. 조회");
        System.out.println("4. 완료 처리");
        System.out.println("5. 전체 목록");
        System.out.println("6. 종료");
    }

    public static void showAddSuccess(Todo todo) {
        System.out.println("[추가 완료] " + todo);
    }

    public static void showDeleteResult(Todo todo) {
        if (todo != null) {
            System.out.println("[삭제 완료] " + todo);
        } else {
            System.out.println("[오류] 해당 ID가 존재하지 않습니다.");
        }
    }

    public static void showTodoDetails(Todo todo) {
        if (todo != null) {
            System.out.println("[조회 결과] " + todo);
        } else {
            System.out.println("[오류] 해당 ID가 존재하지 않습니다.");
        }
    }

    public static void showCompleteResult(boolean success, int id) {
        if (success) {
            System.out.println("[완료 처리] ID: " + id);
        } else {
            System.out.println("[오류] 해당 ID가 존재하지 않습니다.");
        }
    }

    public static void showAllTodos(Map<Integer, Todo> todos) {
        if (todos.isEmpty()) {
            System.out.println("[알림] 등록된 할 일이 없습니다.");
        } else {
            todos.values().forEach(System.out::println);
        }
    }

    public static void showInvalidOption() {
        System.out.println("[오류] 유효하지 않은 옵션입니다.");
    }

    public static void showExitMessage() {
        System.out.println("프로그램을 종료합니다.");
    }
}
