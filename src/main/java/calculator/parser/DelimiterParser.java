package calculator.parser;

import calculator.validator.Validator;

public class DelimiterParser {

    public static String parseDelimiter(String input){
        if(Validator.hasCustomDelimiter(input)){
            char customDelimiter = getCustomDelimiter(input);
            input = convertCustomToNormalDelimiter(input, customDelimiter);
        }
        return input;
    }

    private static char getCustomDelimiter(String input){
        return input.charAt(2);
    }

    private static String convertCustomToNormalDelimiter(String input, char cDelimiter){
        input = input.substring(5); //custom 구분자를 위한 문자들 지우기
        return input.replace(cDelimiter, ','); //custom 구분자를 일반 구분자로 변경
    }

}
