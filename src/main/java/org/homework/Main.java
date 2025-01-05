package org.homework;

public class Main {
    public static void main(String[] args) {
        TodoRepository repository = new TodoRepository();
        TodoService service = new TodoService(repository);
        TodoController controller = new TodoController(service);
        controller.run();
    }
}
