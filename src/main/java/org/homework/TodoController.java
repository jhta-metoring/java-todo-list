package org.homework;

public class TodoController {
    private final TodoService service;
    private final InputView inputView;
    private final OutputView outputView;
    private int idCounter = 1;

    public TodoController() {
        TodoRepository repository = new TodoRepository();
        this.service = new TodoService(repository);
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        while (true) {
            outputView.showMenu();
            String choice = inputView.getUserInput();

            switch (choice) {
                case "1":
                    String description = inputView.getTodoDescription();
                    service.addTodo(idCounter, description);
                    outputView.showAddedTodoMessage(idCounter);
                    idCounter++;
                    break;

                case "2":
                    int deleteId = inputView.getTodoId("삭제");
                    if (service.deleteTodoById(deleteId)) {
                        outputView.showDeletedTodoMessage(deleteId);
                    } else {
                        outputView.showTodoNotFoundMessage(deleteId);
                    }
                    break;

                case "3":
                    int viewId = inputView.getTodoId("조회");
                    service.viewTodoById(viewId)
                            .ifPresentOrElse(outputView::showTodo, () -> outputView.showTodoNotFoundMessage(viewId));
                    break;

                case "4":
                    int completeId = inputView.getTodoId("완료 처리");
                    if (service.markTodoAsCompleted(completeId)) {
                        outputView.showCompletedTodoMessage(completeId);
                    } else {
                        outputView.showTodoNotFoundMessage(completeId);
                    }
                    break;

                case "5":
                    outputView.showExitMessage();
                    return;

                default:
                    outputView.showInvalidOptionMessage();
            }
        }
    }
}