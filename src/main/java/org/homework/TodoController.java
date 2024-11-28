package org.homework;

public class TodoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final TodoService todoService = new TodoService();

    public void run() {
        while (true) {
            try {
                String input = inputView.inputMenu();
                InputMenu inputMenu = InputMenu.of(input);
                switch (inputMenu) {
                    case ADD:
                        add();
                        break;
                    case DELETE:
                        delete();
                        break;
                    case VIEW:
                        view();
                        break;
                    case EXIT:
                        break;
                }
            } catch (RuntimeException ex) {
                outputView.exception(ex);
            }

        }
    }

    private void view() {
        String inputId = inputView.inputView();
        long id = Long.parseLong(inputId);
        Todo todo = todoService.getTodo(id);
        outputView.printTodo(todo);
    }

    private void delete() {
        String inputId = inputView.inputDelete();
        long id = Long.parseLong(inputId);
        todoService.removeTodo(id);
        outputView.deleteTodo(id);
    }

    private void add() {
        String contents = inputView.inputTodo();
        Todo todo = todoService.addTodo(contents);
        outputView.addTodo(todo);
    }
}
