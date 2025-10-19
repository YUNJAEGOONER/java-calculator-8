package calculator.view;

public class OutputView {

    public static void startCalculator(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void printResult(Double result){
       System.out.printf("결과 : %f", result);
    }

}
