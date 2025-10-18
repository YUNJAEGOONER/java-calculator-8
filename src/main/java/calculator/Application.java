package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static String getInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static char getCustomDelimiter(String input){
        return input.charAt(2);
    }

    public static String convertCustomToNormalDelimiter(String input, char cDelimiter){
        input = input.substring(5); //custom 구분자를 위한 문자들 지우기
        return input.replace(cDelimiter, ','); //custom 구분자를 일반 구분자로 변경
    }

    public static List<Double> checkAvailableAndSplit(String input){
        String [] operandArr = input.split(",|:"); // 기본 구분자 (쉼표 또는 콜론);
        List<Double> numList = new ArrayList<>();
        for(int i = 0 ; i < operandArr.length ; i ++) {
            try{
                numList.add(Double.parseDouble(operandArr[i]));
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException(e.getCause());
            }
        }
        return numList;
    }

    public static double getSum(List<Double> arr){
        double sum = 0;
        for(int i = 0 ; i < arr.size() ; i ++ ){
            sum += arr.size();
        }
        return sum;
    }

    public static boolean isNumber(char num){
        return ('0' <= num && num <= '9');
    }

    public static boolean startWithCustomDelimiter(String input){
        return (input.length() >= 4 && input.startsWith("//") && input.contains("\\n"));
    }

    //맨 앞이 숫자로 시작하거나 custom 문자를 위한
    public static void checkAvailableInput(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException("수식을 입력하지 않았습니다.");
        }
        if(!(isNumber(input.charAt(0)) || startWithCustomDelimiter(input))) { //시작을 검사
            throw new IllegalArgumentException("수식은 양의 정수 또는 //(커스텀 구분자)\\n로 시작되어야 합니다");
        }
        if(!isNumber(input.charAt(input.length() - 1))){ // 끝을 검사
            throw new IllegalArgumentException("수식은 양의 정수로 끝나야 합니다.");
        }
    }

    public static void main(String[] args) {

        String input = getInput();

        checkAvailableInput(input);

        if(startWithCustomDelimiter(input)){
            char customDelimiter = getCustomDelimiter(input);
            System.out.println("customDelimiter = " + customDelimiter);
            input = convertCustomToNormalDelimiter(input, customDelimiter);
        }

        List<Double> operandList = checkAvailableAndSplit(input);
        double result = getSum(operandList);
        System.out.println("결과 : " + result);
    }
}
