package calculator.mine.v4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

import calculator.mine.v4.Calculator;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void should_return_given_number() throws Exception {
        String input = "1";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("1");
    }

    @Test
    public void one_plus_two_equals_three() throws Exception {
        String input = "1+2";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("3");
    }

    @Test
    public void one_plus_two_plus_three_equals_six() throws Exception {
        String input = "1+2+4";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("7");
    }
    
    @Test
    public void one_and_one_return_one_and_one() throws Exception {
        String input = "1 1";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("1 1");
    }
    
    @Ignore
    @Test
    public void three_minus_two_equals_one() throws Exception {
        String input = "3-2";
        
        String result = calculator.evaluate(input);
        
        assertThat(result).isEqualTo("1");
    }

}
