package org.homework;

public enum EnumClass {
    Add("1"), Delete("2"), Select("3"), Exit("4"), False("");

    private final String option;

    EnumClass(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
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