package calculator.rpn.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class ReversePolishNotationCalculatorTest {

    private ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();

    @Test
    public void should_one_return_one() throws Exception {
        // Given
        String input = "1";

        // When
        String result = calculator.evaluate(input);

        // Then
        assertThat(result).isEqualTo("1");
    }

    @Test
    public void should_one_one_return_one_one() throws Exception {
        // Given
        String input = "1 1";

        // When
        String result = calculator.evaluate(input);

        // Then
        assertThat(result).isEqualTo("1 1");
    }

    @Ignore
    @Test
    public void should_three_minus_two_return_one() throws Exception {
        // Given
        String input = "3 2 -";

        // When
        String result = calculator.evaluate(input);

        // Then
        assertThat(result).isEqualTo("1");
    }

    @Ignore
    @Test
    public void should_three_two_plus_return_five() throws Exception {
        // Given
        String input = "3 2 +";

        // When
        String result = calculator.evaluate(input);

        // Then
        assertThat(result).isEqualTo("1");
    }

    @Ignore
    @Test
    public void should_one_two_three_plus_plus_return_six() throws Exception {
        // Given
        String input = "1 2 3 + +";

        // When
        String result = calculator.evaluate(input);

        // Then
        assertThat(result).isEqualTo("4");
    }

    @Ignore
    @Test
    public void should_one_two_plus_three_plus_return_six() throws Exception {
        // Given
        String input = "1 2 + 3 +";

        // When
        String result = calculator.evaluate(input);

        // Then
        assertThat(result).isEqualTo("4");
    }

}
