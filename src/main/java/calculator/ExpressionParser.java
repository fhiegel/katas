package calculator;

import java.util.function.Function;

public class ExpressionParser {

    private String pattern;
    private Function<String, ? extends Expression> parser;

    public ExpressionParser(String pattern, Function<String, Expression> parser) {
        this.pattern = pattern;
        this.parser = parser;
    }

    public boolean handle(String expression) {
        return expression.matches(pattern);
    }

    public Expression parse(String expression) {
        return parser.apply(expression);
    }


}
