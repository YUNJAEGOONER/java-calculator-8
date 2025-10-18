package calculator.operator;
import java.util.List;

public class Adder {

    public static Double sum(List<Double> arr){
        return arr.stream().mapToDouble(number -> number).sum();
    }

}
