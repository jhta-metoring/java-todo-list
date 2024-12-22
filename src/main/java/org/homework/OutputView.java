package org.homework;

import java.util.List;

public class OutputView {
    public void Menu() {
        System.out.println("Menu");
        System.out.println("1) ToDoList 추가");
        System.out.println("2) ToDoList 조회");
        System.out.println("3) 할 일 완료");
        System.out.println("4) 할 일 삭제");
        System.out.println("5) 종료");
    }

    public void ToDoList(List<Todo> list) {
        System.out.println("ToDoList");
        if (list.isEmpty()) {
            System.out.println("할 일이 없습니다.");
        } else {
            for (Todo todo : list) {
                System.out.println(todo.getId() + ": " + todo);
            }
        }
    }

}
