package org.homework.func;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
    /**
     * Scanner로 입력받은 문자열 값이 숫자(0~9)에 해당하는지 정규식을 통해 확인하는 함수
     *
     * @param inputValue Scanner로 입력받은 문자열 값
     * @return 정규식 통과 여부 ( true | false )
     */
    public static boolean regexNumCheck(String inputValue) {
        String validPattern = "^[0-9]+$";

        Pattern pattern = Pattern.compile(validPattern);

        Matcher matcher = pattern.matcher(inputValue);

        return matcher.matches();
    }
}
