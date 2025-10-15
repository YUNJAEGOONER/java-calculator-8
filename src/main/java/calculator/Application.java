package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static String getInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static Character getCustomDelimiter(String input){
        if(input.length() >= 4){
            String customSequence = input.substring(0, 5);
            if(customSequence.matches("//.\\\\n")){ //맨앞이 //구분자\n 인 경우
               return customSequence.charAt(2);
            }
        }
        return null;
    }

    public static String convertCustomToNormalDelimiter(String input, char cDelimiter){
        input = input.substring(5); //custom 구분자를 위한 문자들 지우기
        return input.replace(cDelimiter, ','); //custom 구분자를 일반 구분자로 변경
    }

    public static boolean checkAvailableSequence(String input){
        return input.matches("[0-9:,]+"); // 구분자와 양의 정수로만 구성
    }

    public static String[] checkAvailableAndSplit(String input){

        if(!checkAvailableSequence(input)){
            throw new IllegalArgumentException("수식은 구분자와 양의 정수로만 구성이 되어야 합니다.");
        }

        String [] operandArr = input.split(",|:"); // 기본 구분자 (쉼표 또는 콜론);
        for(int i = 0 ; i < operandArr.length ; i ++) {
            if(operandArr[i] == null){
                throw new IllegalArgumentException("유효하지 않은 입력입니다.(예 - 구분자가 연속되서 등장하면 안됩니다.)");
            }
        }
        return operandArr;
    }

    public static int sumStringArr(String [] arr){
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i ++ ){
            sum += Integer.parseInt(arr[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = getInput();

        Character customDelimiter = getCustomDelimiter(input);

        if(customDelimiter != null){
            input = convertCustomToNormalDelimiter(input, customDelimiter);
        }

        String [] operandArr = checkAvailableAndSplit(input);
        int result = sumStringArr(operandArr);
        System.out.println("결과 : " + result);
    }
}
