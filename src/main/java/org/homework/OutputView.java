package org.homework;

public class OutputView {
    public void showMenu() {
        System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 완료, 5. 종료");
    }

    public void showAddedTodoMessage(int id) {
        System.out.println("할 일이 추가되었습니다. ID: " + id);
    }

    public void showDeletedTodoMessage(int id) {
        System.out.println("할 일이 삭제되었습니다. ID: " + id);
    }

    public void showTodo(Todo todo) {
        System.out.println(todo);
    }

    public void showTodoNotFoundMessage(int id) {
        System.out.println("해당 ID의 할 일이 없습니다. ID: " + id);
    }

    public void showCompletedTodoMessage(int id) {
        System.out.println("할 일이 완료 처리되었습니다. ID: " + id);
    }

    public void showInvalidOptionMessage() {
        System.out.println("잘못된 입력입니다. 다시 시도하세요.");
    }

    public void showExitMessage() {
        System.out.println("프로그램을 종료합니다.");
    }
}
