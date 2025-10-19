package calculator.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

import calculator.exception.ExceptionCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("입력된 스트링의 유효성을 검사 - 공백이 들어오는 경우")
    void validateInputNotBlank() {
        //given
        String input = " ";

        //when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () ->Validator.validateInput(input)
        );

        //then
        assertThat(e.getMessage()).isEqualTo(ExceptionCode.INPUT_BLANK_EXCEPTION);
    }

    @Test
    @DisplayName("수식에는 공백이 포함 될 수 없다.")
    void validateInputBlankNotAllowed() {
        //given
        String input = "//*\\n13* 14";

        //when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () ->Validator.validateInput(input)
        );

        //then
        assertThat(e.getMessage()).isEqualTo(ExceptionCode.INPUT_NOT_BLANK_EXCEPTION);
    }

    @Test
    @DisplayName("수식은 커스텀 구분자를 위한 문자열 또는 숫자로 시작해야한다.")
    void validateInputStartWithWiredCharacter(){
        //given
        String input = "~12,13,14";

        //when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () ->Validator.validateInput(input)
        );

        //then
        assertThat(e.getMessage()).isEqualTo(ExceptionCode.INPUT_START_EXCEPTION);
    }

    @Test
    @DisplayName("수식은 숫자로 끝나야한다.")
    void validateInputEndWithNumber(){
        //given
        String input = "12,13,14,";

        //when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () ->Validator.validateInput(input)
        );

        //then
        assertThat(e.getMessage()).isEqualTo(ExceptionCode.INPUT_END_NUMBER_EXCEPTION);
    }


    @Test
    @DisplayName("커스텀 문자열 형태를 올바르게 가지고 있는 경우")
    void hasCustomDelimiter() {
        //given
        String input = "//&\\n12,13,14,";

        //when
        Boolean result = Validator.hasCustomDelimiter(input);

        //then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("커스텀 구분자는 2글자 이상이 될 수 없다.")
    void hasCustomDelimiterStringNotAllowed() {
        //given
        String input = "//&@\\n12,13,14,";

        //when
        Boolean result = Validator.hasCustomDelimiter(input);

        //then
        assertThat(result).isEqualTo(false);
    }
}