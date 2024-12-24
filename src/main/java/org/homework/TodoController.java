package org.homework;

public class TodoController {
    private final TodoService service = new TodoService(new TodoRepository());

    public void run() {
        while (true) {
            OutputView.showMenu();
            int option = InputView.getOption();

            switch (option) {
                case 1 -> {
                    String description = InputView.getDescription();
                    Todo todo = service.addTodo(description);
                    OutputView.showAddSuccess(todo);
                }
                case 2 -> {
                    int id = InputView.getId();
                    Todo deletedTodo = service.deleteTodoById(id);
                    OutputView.showDeleteResult(deletedTodo);
                }
                case 3 -> {
                    int id = InputView.getId();
                    Todo todo = service.findTodoById(id);
                    OutputView.showTodoDetails(todo);
                }
                case 4 -> {
                    int id = InputView.getId();
                    boolean success = service.completeTodoById(id);
                    OutputView.showCompleteResult(success, id);
                }
                case 5 -> {
                    OutputView.showAllTodos(service.getAllTodos());
                }
                case 6 -> {
                    OutputView.showExitMessage();
                    return;
                }
                default -> OutputView.showInvalidOption();
            }
        }
    }
}
