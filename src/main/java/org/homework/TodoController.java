package org.homework;

import java.util.Scanner;

public class TodoController {
    private final TodoService service;
    private final InputView inputView;
    private final OutputView outputView;

    public TodoController() {
        TodoRepository repository = new TodoRepository();
        this.service = new TodoService(repository);
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            outputView.Menu();
            String operationInput = inputView.getMenuOperation(scanner);
            EnumClass operation = EnumClass.fromInput(operationInput);

            switch (operation) {
                case Add:
                    String content = inputView.getTodoContent(scanner);
                    service.addTodo(content);
                    System.out.println("할 일이 추가되었습니다.");
                    break;
                case ToDoList:
                    outputView.ToDoList(service.getToDoList());
                    break;
                case Complete:
                    String id = inputView.getTodoId(scanner);
                    boolean result = service.completeTodoById(id);
                    if (result) {
                        System.out.println("할 일이 완료되었습니다.");
                    } else {
                        System.out.println("해당 ID의 할 일을 찾을 수 없습니다.");
                    }
                    break;
                case Delete:
                    String deleteId = inputView.getTodoId(scanner);
                    boolean result2 = service.deleteTodoById(deleteId);
                    if (result2) {
                        System.out.println("할 일이 삭제되었습니다.");
                    } else {
                        System.out.println("해당 ID의 할 일이 없습니다.");
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

enum EnumClass {
    Add("1"), ToDoList("2"), Complete("3"), Delete("4"), Exit("5"), False("");

    private final String option;
    EnumClass(String option) {
        this.option = option;
    }
    public static EnumClass fromInput(String input) {
        for (EnumClass op : EnumClass.values()) {
            if (op.option.equals(input)) {
                return op;
            }
        }
        return False;
    }
}
