package calculator;

import static calculator.view.OutputView.printResult;
import static calculator.view.OutputView.startCalculator;

import calculator.operator.Adder;
import calculator.parser.DelimiterParser;
import calculator.parser.NumberParser;
import calculator.view.InputView;
import java.util.List;

public class StringCalculator {

    public static void calculate(){
        startCalculator();
        String input = InputView.getInput();
        String delimiterParsedExpression = DelimiterParser.parseDelimiter(input);
        List<Double> numList = NumberParser.parseNumber(delimiterParsedExpression);
        Double result = Adder.sum(numList);
        printResult(result);
    }

}
