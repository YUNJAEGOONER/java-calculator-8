package calculator.validator;

public class Validator {

    public static void validateInput(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException("수식을 입력하지 않았습니다.");
        }
        if(!(isNumber(input.charAt(0)) || hasCustomDelimiter(input))) { //시작을 검사
            throw new IllegalArgumentException("수식은 양의 정수 또는 //(커스텀 구분자)\\n로 시작되어야 합니다");
        }
        if(!isNumber(input.charAt(input.length() - 1))){ // 끝을 검사
            throw new IllegalArgumentException("수식은 양의 정수로 끝나야 합니다.");
        }
    }

    private static boolean isNumber(char num){
        return ('0' <= num && num <= '9');
    }

    public static boolean hasCustomDelimiter(String input){
        return (input.length() >= 4 && input.startsWith("//") && input.contains("\\n"));
    }

}
