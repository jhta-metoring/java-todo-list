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

    /**
     * Scanner로부터 옵션 번호를 입력 받아 그에 해당하는 Option객체를 반환하는 함수
     *
     * @param optionNum Scanner로 입력받은 inputValue값
     * @return 번호에 해당하는 Option객체
     */
    public static Option getOptionByNum(int optionNum) {
        Option result = null;

        for (Option option : Option.values()) {
            if (option.getOptionNum() == optionNum) {
                result = option;
            }
        }

        return result;
    }

    /**
     * Option에 등록되어 있는 메뉴들의 번호를 배열로 반환하는 함수 ( 옵션 번호가 순차적으로 등록되지 않을 가능성이 있어 그러한 경우를 비교하기 위해 사용함 )
     *
     * @return int[]
     */
    public static int[] getIntArrOfOptionNum() {
        Option[] options = Option.values();
        int[] validOptionNumbers = new int[options.length];
        for (int i = 0; i < options.length; i++) {
            validOptionNumbers[i] = options[i].getOptionNum();
        }

        return validOptionNumbers;
    }

    /**
     * 사용자가 선택 가능한 메뉴 목록을 콘솔에 출력하는 함수
     */
    public static void printOptions() {
        Option[] options = Option.values();

        System.out.print("옵션을 선택하세요: ");

        for (int i = 0; i < options.length; i++) {
            Option option = options[i];
            String format = i < options.length - 1 ? "%s.%s, " : "%s.%s ~> ";

            System.out.printf(format, option.getOptionNum(), option.getOptionName());
        }
    }
}
