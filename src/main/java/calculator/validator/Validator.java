package calculator.validator;

import calculator.exception.ExceptionCode;

public class Validator {

    public static void validateInput(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException(ExceptionCode.INPUT_BLANK_EXCEPTION);
        }
        if(input.contains(" ")){
            throw new IllegalArgumentException(ExceptionCode.INPUT_NOT_BLANK_EXCEPTION);
        }
        if(!(isNumber(input.charAt(0)) || hasCustomDelimiter(input))) { //시작을 검사
            throw new IllegalArgumentException(ExceptionCode.INPUT_START_EXCEPTION);
        }
        if(!isNumber(input.charAt(input.length() - 1))){ // 끝을 검사
            throw new IllegalArgumentException(ExceptionCode.INPUT_END_NUMBER_EXCEPTION);
        }
    }

    private static boolean isNumber(char num){
        return ('0' <= num && num <= '9');
    }

    public static boolean hasCustomDelimiter(String input){
        return (input.length() >= 4 && input.startsWith("//") && (input.indexOf("\\n") == 3));
    }

}
