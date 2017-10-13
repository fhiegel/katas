package calculator.mine.v4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import calculator.mine.v4.expression.Expression;

public class ExpressionCompositeParser {

    private Map<String, ExpressionParser> expressionToEvaluation= new LinkedHashMap<>();

    public ExpressionCompositeParser when(String pattern, Function<String, Expression> parser) {
        expressionToEvaluation.put(pattern, new ExpressionParser(pattern, parser));
        return this;
    }

    public String pattern() {
        return String.join("|", expressionToEvaluation.keySet());
    }

    public ExpressionParser find(String expression) {
        return expressionToEvaluation.values()
                .stream()
                .filter(parser -> parser.handle(expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find parser for expression : " + expression));
    }

}
