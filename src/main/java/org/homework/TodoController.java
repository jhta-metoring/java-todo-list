package org.homework;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. 전체 할 일 보기 | 2. 새로운 할 일 추가 | 3. 키워드 검색 | 4. 종료");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        printTodos(service.getUpcomingTodos());
                        break;
                    case 2:
                        System.out.print("제목 입력: ");
                        String title = scanner.nextLine();
                        System.out.print("설명 입력: ");
                        String description = scanner.nextLine();
                        System.out.print("마감일 입력 (yyyy-MM-dd): ");
                        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
                        service.addTodo(new Todo(0, title, description, dueDate));
                        break;
                    case 3:
                        System.out.print("검색할 키워드 입력: ");
                        String keyword = scanner.nextLine();
                        List<Todo> results = service.searchTodosByKeyword(keyword);
                        if (results.isEmpty()) {
                            System.out.println("검색 결과가 없습니다.");
                        } else {
                            printTodos(results);
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("올바른 번호를 입력해주세요.");
                }
            }
        } catch (Exception e) {
            System.out.println("에러 발생: " + e.getMessage());
        }
    }

    private void printTodos(List<Todo> todos) {
        todos.forEach(System.out::println);
    }
}
