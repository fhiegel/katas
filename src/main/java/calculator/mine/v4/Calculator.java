package calculator.mine.v4;

import calculator.mine.v4.expression.AddOperation;
import calculator.mine.v4.expression.BoldTextExpression;
import calculator.mine.v4.expression.Expression;
import calculator.mine.v4.expression.IntegerExpression;
import calculator.mine.v4.expression.MinusOperation;
import calculator.mine.v4.expression.MultiplyOperation;
import calculator.mine.v4.expression.PowerOperation;
import calculator.mine.v4.expression.TextExpression;

public class Calculator {

    public String evaluate(String input) {
        Expression expression = parseExpression(input);
        Expression result = expression.evaluate();
        return result.print();
    }

    private Expression parseExpression(String input) {
        Expression result = Expression.NEUTRAL;
        ExpressionTokenizer tokens = tokenize(input);
        while (tokens.hasToken()) {
            ExpressionToken token = tokens.nextToken();
            Expression next = token.expression();
            result = result.then(next);
        }
        return result;
    }

    private ExpressionTokenizer tokenize(String input) {
        return new ExpressionTokenizer(expressionParser(), input);
    }

    private ExpressionCompositeParser expressionParser() {
        return new ExpressionCompositeParser()
                .when("\\d+", e -> new IntegerExpression(Integer.valueOf(e)))
                .when("[+]", e -> AddOperation.EMPTY)
                .when("([-])(?!-)", e -> MinusOperation.EMPTY)
                .when("[*]", e -> MultiplyOperation.EMPTY)
                .when("[\\^]", e -> PowerOperation.EMPTY)
                .when("--bold", e -> BoldTextExpression.EMPTY)
                .when("\\S+", e -> new TextExpression(e))
                ;
    }

}
