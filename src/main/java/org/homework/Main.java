package org.homework;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, String> todos = new HashMap<>();
        Option[] options = Option.values();

        String validPattern = "^[1-" + options.length + "]$";
        Pattern pattern = Pattern.compile(validPattern);

        int selectedOption = 0;
        while (selectedOption != 4) {
            System.out.print("옵션을 선택하세요: ");

            for (int i = 0; i < options.length; i++) {
                Option option = options[i];
                String format = i < options.length - 1 ? "%s.%s, " : "%s.%s ~> ";
                System.out.printf(format, option.getOptionNum(), option.getOptionName());
            }

            String inputValue = scanner.nextLine();
            Matcher matcher = pattern.matcher(inputValue);

            if ( matcher.matches() ) {
                selectedOption = Integer.parseInt(inputValue);
                // TODO: 2024/12/08
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }
}