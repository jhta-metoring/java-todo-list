package org.homework;

public enum Enum {
    Add("1"), AllList("2"), SelectList("3"), Complete("4"), Delete("5"), Exit("6"), False("");

    private final String option;

    Enum(String option) {
        this.option = option;
    }

    public static Enum fromInput(String input) {
        for (Enum op : Enum.values()) {
            if (op.option.equals(input)) {
                return op;
            }
        }
        return False;
    }
}
