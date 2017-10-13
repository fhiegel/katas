package calculator.mine.v4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

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

    @Test
    public void three_minus_two_equals_one() throws Exception {
        String input = "3-2";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("1");
    }

    @Test
    public void nine_minus_five_minus_three_equals_one() throws Exception {
        String input = "9-5-3";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("1");
    }

    @Test
    public void two_multiply_three_equals_six() throws Exception {
        String input = "2*3";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("6");
    }

    @Test
    @Ignore
    public void two_x_three_equals_six() throws Exception {
        String input = "2x3";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("6");
    }

    @Test
    public void two_multiply_three_plus_four_equals_ten() throws Exception {
        String input = "2*3+4";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("10");
    }

    @Test
    public void two_plus_three_multiply_four_minus_five_equals_nine() throws Exception {
        String input = "2+3*4-5";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("9");
    }

    @Test
    public void returns_one_when_string_two_power_zero_given() throws Exception {
        String sentence = "2^0";

        String result = calculator.evaluate(sentence);

        assertThat(result).isEqualTo("1");
    }

    @Test
    public void returns_one_when_string_two_power_one_given() throws Exception {
        String sentence = "2^1";

        String result = calculator.evaluate(sentence);

        assertThat(result).isEqualTo("2");
    }

    @Test
    public void returns_64_when_string_two_power_six_given() throws Exception {
        String sentence = "2^6";

        String result = calculator.evaluate(sentence);

        assertThat(result).isEqualTo("64");
    }

    @Test
    public void returns_64_when_string_two_power_three_power_two_given() throws Exception {
        String sentence = "2^3^2";

        String result = calculator.evaluate(sentence);

        assertThat(result).isEqualTo("64");
    }

    @Test
    public void returns_32_when_string_two_power_three_multiply_two_power_two_given() throws Exception {
        String sentence = "2^3*2^2";

        String result = calculator.evaluate(sentence);

        assertThat(result).isEqualTo("32");
    }

    @Test
    public void should_return_given_text() throws Exception {
        String input = "Some text";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("Some text");
    }

    @Test
    public void should_return_given_bold_text() throws Exception {
        String input = "Some text --bold";

        String result = calculator.evaluate(input);

        assertThat(result).isEqualTo("*Some text*");
    }

}
