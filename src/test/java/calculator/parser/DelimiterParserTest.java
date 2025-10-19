package calculator.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterParserTest {

    @Test
    @DisplayName("구분자를 파싱하는 메서드 - customDelimiter가 존재하고 정수로 이루어진 경우")
    void parseDelimiter() {

        //given
        String input = "//*\\n12*14*15";

        //when
        String parsedInput = DelimiterParser.parseDelimiter(input);

        //then
        assertAll(
                () -> assertThat(parsedInput).isEqualTo("12,14,15"),
                () -> assertThat(parsedInput).matches("^[0-9,]+")
        );

    }

    @Test
    @DisplayName("구분자를 파싱하는 메서드 - customDelimiter가 존재하고 소수가 포함된 경우")
    void parseDelimiterWithDouble() {

        //given
        String input = "//*\\n1.2*14*1.5";

        //when
        String parsedInput = DelimiterParser.parseDelimiter(input);

        //then
        assertAll(
                () -> assertThat(parsedInput).isEqualTo("1.2,14,1.5"),
                () -> assertThat(parsedInput).matches("^[0-9,.]+")
        );

    }
}