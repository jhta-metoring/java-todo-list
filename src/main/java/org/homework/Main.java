package org.homework;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    enum Option {
        ADD(1, "추가"),
        DELETE(2, "삭제"),
        VIEW(3, "조회"),
        EXIT(4, "종료");

        private final int code;
        private final String description;

        Option(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        public static Option fromCode(int code) {
            for (Option option : values()) {
                if (option.code == code) {
                    return option;
                }
            }
            throw new IllegalArgumentException("Invalid option code: " + code);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> todoList = new HashMap<>();
        int nextId = 1;

        while (true) {
            System.out.println("\n========= 할 일 관리 프로그램 =========");
            for (Option option : Option.values()) {
                System.out.println(option.getCode() + ". " + option.getDescription());
            }
            System.out.print("옵션을 선택하세요: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                try {
                    Option selectedOption = Option.fromCode(choice);

                    switch (selectedOption) {
                        case ADD -> {
                            System.out.print("추가할 할 일을 입력하세요: ");
                            String task = sc.nextLine().trim();
                            if (!task.isEmpty()) {
                                todoList.put(nextId, task);
                                System.out.println("[추가 완료] ID: " + nextId + ", 내용: " + task);
                                nextId++;
                            } else {
                                System.out.println("[오류] 내용이 비어 있습니다.");
                            }
                        }
                        case DELETE -> {
                            System.out.print("삭제할 할 일의 ID를 입력하세요: ");
                            int deleteId = Integer.parseInt(sc.nextLine());
                            String removedTask = todoList.remove(deleteId);
                            if (removedTask != null) {
                                System.out.println("[삭제 완료] ID: " + deleteId);
                            } else {
                                System.out.println("[오류] 해당 ID가 존재하지 않습니다.");
                            }
                        }
                        case VIEW -> {
                            System.out.print("조회할 할 일의 ID를 입력하세요: ");
                            int viewId = Integer.parseInt(sc.nextLine());
                            String task = todoList.get(viewId);
                            if (task != null) {
                                System.out.println("[조회 결과] ID: " + viewId + ", 내용: " + task);
                            } else {
                                System.out.println("[오류] 해당 ID가 존재하지 않습니다.");
                            }
                        }
                        case EXIT -> {
                            System.out.println("프로그램을 종료합니다.");
                            sc.close();
                            return;
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } catch (NumberFormatException e) {
                System.out.println("[오류] 숫자를 입력해주세요.");
            }
        }
    }
}
