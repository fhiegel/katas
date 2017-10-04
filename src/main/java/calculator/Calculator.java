package calculator;

public class Calculator {

    public String evaluate(String input) {
        Expression result = Expression.NEUTRAL;
        ExpressionTokenizer tokens = new ExpressionTokenizer(expressionParser(), input);
        while (tokens.hasToken()) {
            ExpressionToken token = tokens.nextToken();
            Expression next = token.expression();
            result = result.then(next);
        }
        
        result = result.evaluate();
        return result.print();
    }

    private ExpressionCompositeParser expressionParser() {
        return new ExpressionCompositeParser()
                .when("\\d+", e -> new IntegerExpression(Integer.valueOf(e)))
                .when("[+]", e -> new AddOperation());
    }

}
