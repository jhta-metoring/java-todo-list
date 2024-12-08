package org.homework.func;

import java.util.HashMap;
import java.util.Scanner;

public class Todo {
    /**
     * 새로운 할 일을 추가하는 함수
     *
     * @param scanner Scanner
     * @param todos   할일 목록
     */
    public static void addTodo(Scanner scanner, HashMap<Integer, String> todos) {
        System.out.print("새로운 할 일을 입력해주세요 ~> ");
        String newTodo = scanner.nextLine();
        int newTodoId = getNewTodoId(todos);
        todos.put(newTodoId, newTodo);

        System.out.println("할 일이 추가되었습니다. ID : [" + newTodoId + "]");
    }

    /**
     * 등록되어있는 할 일을 삭제하는 함수
     *
     * @param scanner Scanner
     * @param todos   할일 목록
     */
    public static void deleteTodo(Scanner scanner, HashMap<Integer, String> todos) {
        if (todos.isEmpty()) {
            System.out.println("삭제 가능한 할 일이 존재하지 않습니다.");
            return;
        }

        System.out.print("삭제하려는 할 일의 고유번호(ID)를 입력해주세요 ~> ");
        String inputValue = scanner.nextLine();

        if (Common.regexNumCheck(inputValue)) {
            int todoId = Integer.parseInt(inputValue);

            if (todos.containsKey(todoId)) {
                todos.remove(todoId);
                System.out.println("할 일이 삭제되었습니다. ID : [" + todoId + "]");
            } else {
                System.out.println("해당 ID의 할 일이 없습니다.");
            }
        } else {
            System.out.println("고유번호(ID)는 숫자만 입력 가능합니다.");
        }
    }

    /**
     * 등록되어있는 할 일을 조회하는 함수
     *
     * @param scanner Scanner
     * @param todos   할일 목록
     */
    public static void viewTodo(Scanner scanner, HashMap<Integer, String> todos) {
        if (todos.isEmpty()) {
            System.out.println("조회 가능한 할 일이 존재하지 않습니다.");
            return;
        }

        System.out.print("조회하려는 할 일의 고유번호(ID)를 입력해주세요 ~> ");
        String inputValue = scanner.nextLine();

        if (Common.regexNumCheck(inputValue)) {
            int todoId = Integer.parseInt(inputValue);
            if (todos.containsKey(todoId)) {
                System.out.println("할 일 ID : [" + todoId + "], 내용 : [" + todos.get(todoId) + "]");
            } else {
                System.out.println("해당 ID의 할 일이 없습니다.");
            }
        } else {
            System.out.println("고유번호(ID)는 숫자만 입력 가능합니다.");
        }

    }

    /**
     * 할일 목록의 유무를 먼저 체크하고, 기등록된 목록이 있는 경우 최대값을 구해 새로운 할일 ID를 반환하는 함수
     *
     * @param todos 할일 목록
     * @return 새로운 할 일의 고유 ID
     *
     * TODO : 람다식으로 전환 가능
     */
    public static int getNewTodoId(HashMap<Integer, String> todos) {
        int newId = 1;
        if (!todos.isEmpty()) {
            int maxId = 0;

            // keySet() : HashMap에 저장된 모든 키가 저장된 Set을 반환함
            for (int id : todos.keySet()) {
                if (id > maxId) {
                    maxId = id;
                }
            }

            newId = maxId + 1;
        }

        return newId;
    }
}
