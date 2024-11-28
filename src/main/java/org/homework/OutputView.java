package org.homework;

public class OutputView {
    public void printTodo(Todo todo) {
        System.out.println(todo);
    }

    public void addTodo(Todo todo) {
        System.out.println("할 일이 추가되었습니다.");
        System.out.println(todo);
    }

    public void deleteTodo(long id) {
        System.out.println("할 일이 삭제되었습니다. ID: " + id);
    }

    public void exception(RuntimeException ex) {
        System.out.println(ex.getMessage());
    }
}
