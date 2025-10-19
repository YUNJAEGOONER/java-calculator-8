package calculator.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import calculator.exception.ExceptionCode;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberParserTest {

    @Test
    @DisplayName("양의 정수와 정해진 구분자로 이루어진 경우에는 숫자 리스트를 반환")
    void parseNumber() {
        //given
        String delimiterParsed = "12,133,12,13";

        //when
        List<Double> doubleList = NumberParser.parseNumber(delimiterParsed);

        //when
        assertAll(
                () -> assertThat(doubleList.size()).isEqualTo(4),
                () -> assertThat(doubleList.contains(133.0)).isEqualTo(true)
        );
    }


    @Test
    @DisplayName("수식에 음수가 포함되어 있는 경우에는 예외가 발생")
    void parseNumberFailNegativeNumber() {
        //given
        String delimiterParsed = "12,-13,12,13";

        //when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> NumberParser.parseNumber(delimiterParsed)
        );

        //when
        assertThat(e.getMessage()).isEqualTo(ExceptionCode.NUMBER_PARSER_NEGATIVE_EXCEPTION);
    }

    @Test
    @DisplayName("연속적인 구분자가 등장하는 경우 - 숫자로 변환할 수 없음")
    void parseNumberFail() {

        //given
        String delimiterParsed = "12,13,,12,13";

        //when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> NumberParser.parseNumber(delimiterParsed)
        );

        //when
        assertThat(e.getMessage()).isEqualTo(ExceptionCode.NUMBER_PARSER_FORMAT_EXCEPTION);
    }

    @Test
    @DisplayName("알 수 없는 구분자가 등장하는 경우 - 숫자로 변환할 수 없음")
    void parseNumberFailUnknownDelimiter() {

        //given
        String delimiterParsed = "12^13:12,13";

        //when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> NumberParser.parseNumber(delimiterParsed)
        );

        //when
        assertThat(e.getMessage()).isEqualTo(ExceptionCode.NUMBER_PARSER_FORMAT_EXCEPTION);
    }


}