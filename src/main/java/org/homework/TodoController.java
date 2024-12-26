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
            outputView.menu();
            String operationInput = inputView.getMenuOperation();
            Enum operation = Enum.fromInput(operationInput);

            switch (operation) {
                case Add:
                    String content = inputView.getTodoContent();
                    service.addTodo(content);
                    outputView.printAdd();
                    break;
                case AllList:
                    outputView.printToDoList(service.getToDoList());
                    break;
                case SelectList:
                    String selectId = inputView.getSelectId();
                    outputView.printSelect(service.getTodoById(selectId));
                    break;
                case Complete:
                    String id = inputView.getTodoId();
                    outputView.printComplete(service.completeTodoById(id));
                    break;
                case Delete:
                    String deleteId = inputView.getTodoId();
                    outputView.printDelete(service.deleteTodoById(deleteId));
                    break;
                case Exit:
                    outputView.printExit();
                    inputView.exit();
                    return;
                case False:
                    outputView.printFalse();
                    break;
                default:
                    outputView.printError();
                    break;
            }
        }
    }
}

