package calculator.parser;

import calculator.exception.ExceptionCode;
import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    public static List<Double> parseNumber(String input){
        String [] operandArr = splitByDelimiter(input);
        return convertStringToDouble(operandArr);
    }

    private static String [] splitByDelimiter(String input){
        return input.split(",|:"); // 기본 구분자 (쉼표 또는 콜론);
    }

    private static List<Double> convertStringToDouble(String[] operandArr){
        List<Double> numList = new ArrayList<>();
        for(int i = 0 ; i < operandArr.length ; i ++) {
            try{
                Double num = Double.parseDouble(operandArr[i]);
                if(num < 0){
                    throw new IllegalArgumentException(ExceptionCode.NUMBER_PARSER_NEGATIVE_EXCEPTION);
                }
                numList.add(Double.parseDouble(operandArr[i]));
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException(ExceptionCode.NUMBER_PARSER_FORMAT_EXCEPTION);
            }
        }
        return numList;
    }

}
