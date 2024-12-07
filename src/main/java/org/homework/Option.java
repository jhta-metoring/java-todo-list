package org.homework;

public enum Option {
    ADD(1, "추가"),
    DELETE(2, "삭제"),
    VIEW(3, "조회"),
    EXIT(4, "종료");

    private final int optionNum;
    private final String optionName;

    Option(int optionNum, String optionName) {
        this.optionNum = optionNum;
        this.optionName = optionName;
    }

    public int getOptionNum() {
        return optionNum;
    }

    public String getOptionName() {
        return optionName;
    }

    public static Option getOptionNameByNum(int optionNum) {
        for (Option option : Option.values()) {
            System.out.println("===> option : ");
            System.out.println(option);
            if (option.getOptionNum() == optionNum) {
                return option;
            }
        }

        return null;
    }
}
