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
            if(customSequence.matches("//.\\\\n")){
                return customSequence.charAt(2);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = getInput();
    }
}
