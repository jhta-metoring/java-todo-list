package org.homework;

import java.util.Arrays;

public enum InputMenu {
    // 1. 추가, 2. 삭제, 3. 조회, 4. 종료"
    ADD("1"), DELETE("2"), VIEW("3"), EXIT("4"), NONE("-1");
    private final String input;
    InputMenu(String input) {
        this.input = input;
    }
    public static InputMenu of(String input) {
        return Arrays.stream(values())
                .filter(inputMenu -> inputMenu.input.equals(input))
                .findAny()
                .orElse(NONE);
    }
}
