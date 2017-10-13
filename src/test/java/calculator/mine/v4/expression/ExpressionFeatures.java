package calculator.mine.v4.expression;

import static calculator.mine.v4.expression.Expression.NEUTRAL;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import calculator.mine.v4.expression.Expression;
import calculator.mine.v4.expression.TextExpression;

public class ExpressionFeatures {

    static final Expression one = new IntegerExpression(1);
    static final Expression two = new IntegerExpression(2);
    static final Expression three = new IntegerExpression(3);
    static final Expression four = new IntegerExpression(4);
    static final Expression seven = new IntegerExpression(7);
    static final Expression add =  AddOperation.EMPTY;
    static final Expression minus =  MinusOperation.EMPTY;
    static final Expression multiply = MultiplyOperation.EMPTY;
    static final Expression power = PowerOperation.EMPTY;

    static final TextExpression anExpression = new TextExpression("<any expression>");

    @Test
    public void evaluate_neutral_will_return_initial_expression() throws Exception {
        Expression expression = anExpression.then(Expression.NEUTRAL);
        assertThat(expression).isEqualTo(anExpression);
    }

    @Test
    public void neutral_evaluate_expression_will_return_second_expression() throws Exception {
        Expression expression = NEUTRAL.then(anExpression);
        assertThat(expression).isEqualTo(anExpression);
    }

    @Test
    public void evaluate_two_text_expressions_will_return_expression_concatenation() throws Exception {
        // Given
        TextExpression first = new TextExpression("one");
        TextExpression second = new TextExpression("sentence");

        // When
        Expression expression = first.then(second);

        // Then
        assertThat(expression.print()).isEqualTo("one sentence");
    }

    @Test
    public void print_two_integer_expressions_an_one_operation_will_return_readable_result() throws Exception {
        // When
        Expression result = one.then(add).then(two);

        // Then
        assertThat(result.print()).isEqualTo("1+2");
    }

    @Test
    public void evaluate_two_integer_expressions_an_one_operation_will_return_readable_result() throws Exception {
        // When
        Expression result = one.then(add).then(two).evaluate();

        // Then
        assertThat(result.print()).isEqualTo("3");
    }

    @Test
    public void prints_composite_sum() throws Exception {

        // When
        Expression result = one.then(add).then(two).then(add).then(four);

        // Then
        assertThat(result.print()).isEqualTo("1+2+4");
    }

    @Test
    public void one_plus_two_plus_four_equals_seven() throws Exception {

        // When
        Expression notEvaluated = one.then(add).then(two).then(add).then(four);
        Expression result = notEvaluated.evaluate();

        // Then
        assertThat(notEvaluated.print()).isEqualTo("1+2+4");
        assertThat(result.print()).isEqualTo("7");
    }

    @Test
    public void one_plus_two_multiply_three_equals_seven() throws Exception {
        // When
        Expression notEvaluated = one.then(add).then(two).then(multiply).then(three);
        Expression result = notEvaluated.evaluate();

        // Then
        assertThat(notEvaluated.print()).isEqualTo("1+2*3");
        assertThat(result.print()).isEqualTo("7");
    }

    @Test
    public void one_plus_two_multiply_three_multiply_four_equals_twenty_five() throws Exception {
        // When
        Expression notEvaluated = one.then(add).then(two).then(multiply).then(three).then(multiply).then(four);
        Expression result = notEvaluated.evaluate();

        // Then
        assertThat(notEvaluated.print()).isEqualTo("1+2*3*4");
        assertThat(result.print()).isEqualTo("25");
    }

    @Test
    public void one_plus_two_multiply_three_plus_four_equals_eleven() throws Exception {
        // When
        Expression notEvaluated = one.then(add)
                .then(two)
                .then(multiply)
                .then(three)
                .then(add)
                .then(four);
        Expression result = notEvaluated.evaluate();

        // Then
        assertThat(notEvaluated.print()).isEqualTo("1+2*3+4");
        assertThat(result.print()).isEqualTo("11");
    }

    @Test
    public void seven_minus_two_multiply_three_equals_one() throws Exception {
        // When
        Expression notEvaluated = seven.then(minus).then(two).then(multiply).then(three);
        Expression result = notEvaluated.evaluate();

        // Then
        assertThat(notEvaluated.print()).isEqualTo("7-2*3");
        assertThat(result.print()).isEqualTo("1");
    }
    
    @Test
    public void two_power_three_multiply_two_power_two_equals_thirty_two() throws Exception {
        // When
        Expression notEvaluated = two.then(power)
                .then(three)
                .then(multiply)
                .then(two)
                .then(power)
                .then(two);
        Expression result = notEvaluated.evaluate();

        // Then
        assertThat(notEvaluated.print()).isEqualTo("2^3*2^2");
        assertThat(result.print()).isEqualTo("32");
    }

}
