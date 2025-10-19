package calculator.exception;

public class ExceptionCode {
    public static final String NUMBER_PARSER_FORMAT_EXCEPTION = "숫자로 변환할 수 없는 형태입니다";
    public static final String NUMBER_PARSER_NEGATIVE_EXCEPTION = "양수가 포함된 수식만 계산이 가능합니다.";

    public static final String INPUT_BLANK_EXCEPTION = "수식을 입력해야 합니다.";
    public static final String INPUT_NOT_BLANK_EXCEPTION = "수식에 공백이 입력되어서는 안됩니다.";
    public static final String INPUT_START_EXCEPTION = "수식은 양의 정수 또는 //(커스텀 구분자)\\n로 시작되어야 합니다";
    public static final String INPUT_END_NUMBER_EXCEPTION = "수식은 정수로 끝나야 합니다.";

}
