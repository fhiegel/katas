package calculator.mine.v4;

import static calculator.mine.v4.Expression.NEUTRAL;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import calculator.mine.v4.AddOperation;
import calculator.mine.v4.Expression;
import calculator.mine.v4.IntegerExpression;
import calculator.mine.v4.TextExpression;

public class ExpressionFeatures {

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
        assertThat(expression.toString()).isEqualTo("one sentence");
    }

    @Test
    public void print_two_integer_expressions_an_one_operation_will_return_readable_result() throws Exception {
        // Given
        Expression one = new IntegerExpression(1);
        Expression two = new IntegerExpression(2);
        Expression add = new AddOperation();

        // When
        Expression result = one.then(add).then(two);

        // Then
        assertThat(result.toString()).isEqualTo("1+2");
    }

    @Test
    public void evaluate_two_integer_expressions_an_one_operation_will_return_readable_result() throws Exception {
        // Given
        Expression one = new IntegerExpression(1);
        Expression two = new IntegerExpression(2);
        Expression add = new AddOperation();

        // When
        Expression result = one.then(add).then(two).evaluate();

        // Then
        assertThat(result.toString()).isEqualTo("3");
    }

    @Test
    public void prints_composite_sum() throws Exception {
        // Given
        Expression one = new IntegerExpression(1);
        Expression two = new IntegerExpression(2);
        Expression four = new IntegerExpression(4);
        Expression add = new AddOperation();
        Expression secondAdd = new AddOperation();

        // When
        Expression result = one.then(add).then(two).then(secondAdd).then(four);

        // Then
        assertThat(result.toString()).isEqualTo("1+2+4");
    }

    @Test
    public void one_plus_two_plus_four_equals_seven() throws Exception {
        // Given
        Expression one = new IntegerExpression(1);
        Expression two = new IntegerExpression(2);
        Expression four = new IntegerExpression(4);
        Expression add = new AddOperation();
        Expression secondAdd = new AddOperation();

        // When
        Expression notEvaluated = one.then(add).then(two).then(secondAdd).then(four);
        Expression result = notEvaluated.evaluate();

        // Then
        assertThat(notEvaluated.toString()).isEqualTo("1+2+4");
        assertThat(result.toString()).isEqualTo("7");
    }

}
