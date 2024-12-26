package org.homework;

import java.util.List;

public class OutputView {
    public void menu() {
        System.out.println("Menu");
        System.out.println("1) ToDoList 추가");
        System.out.println("2) AllList 조회");
        System.out.println("3) SelectList 조회");
        System.out.println("4) 할 일 완료");
        System.out.println("5) 할 일 삭제");
        System.out.println("6) 종료");
    }

    public void printToDoList(List<Todo> list) {
        System.out.println("ToDoList");
        if (list.isEmpty()) {
            System.out.println("할 일이 없습니다.");
        } else {
            for (Todo todo : list) {
                System.out.println(todo.getId() + ": " + todo);
            }
        }
    }

    public void printSelect(String message) {
        System.out.println("조회 결과: " + message);
    }

    public void printAdd() {
        System.out.println("할 일이 추가되었습니다.");
    }

    public void printComplete(String message) {
        System.out.println(message);
    }

    public void printDelete(String message) {
        System.out.println(message);
    }

    public void printExit() {
        System.out.println("프로그램을 종료합니다.");
    }

    public void printFalse() {
        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
    }

    public void printError() {
        System.out.println("알 수 없는 오류가 발생했습니다.");
    }
}
