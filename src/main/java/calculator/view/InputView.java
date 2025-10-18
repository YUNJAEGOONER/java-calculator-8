package calculator.view;

import calculator.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getInput(){
        String input = Console.readLine();
        Validator.validateInput(input);
        return input;
    }

}
