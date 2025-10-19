package calculator.operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AdderTest {

    @Test
    @DisplayName("반환 받은 숫자 리스트를 모두 더하고 결과를 반환하는 메서드")
    void sum() {

        //given
        List<Double> numList = new ArrayList<>();
        numList.add(1.2);
        numList.add(2.3);
        numList.add(3.4);

        //when
        Double result = Adder.sum(numList);

        //then
        assertThat(result).isEqualTo(6.9);

    }

}