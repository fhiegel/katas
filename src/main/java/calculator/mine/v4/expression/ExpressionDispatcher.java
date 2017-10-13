package calculator.mine.v4.expression;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;

class ExpressionDispatcher {

    private final Map<Class<? extends Expression>, Function<Expression, ? extends Expression>> expressionToEvaluation = new LinkedHashMap<>();
    private final Expression origin;

    private Function<Expression, ? extends Expression> defaultEvaluation = expression -> new TextExpression(unsupportedExpressionMessage(expression));

    public ExpressionDispatcher(Expression origin) {
        this.origin = origin;
    }

    public <T extends Expression> ExpressionDispatcher when(Class<? extends T> type,
            Function<? super T, ? extends Expression> expressionEvaluation) {
        expressionToEvaluation.put(type, expressionEvaluation.compose(type::cast));
        return this;
    }

    public ExpressionDispatcher otherwise(Function<Expression, ? extends Expression> defaultEvaluation) {
        this.defaultEvaluation = defaultEvaluation;
        return this;
    }

    public Expression dispatch(Expression receiver) {
        Function<Expression, ? extends Expression> expressionMapper = resolveMapper(receiver);
        return expressionMapper.apply(receiver);
    }

    private Function<Expression, ? extends Expression> resolveMapper(Expression receiver) {
        Optional<Function<Expression, ? extends Expression>> expressionMapper = expressionToEvaluation
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().isAssignableFrom(receiver.getClass()))
                .findFirst()
                .map(Entry::getValue);
        return expressionMapper.orElse(defaultEvaluation);
    }

    private String unsupportedExpressionMessage(Expression expression) {
        return "Origin " + origin.getClass().getName() + " cannot handle Expression : expression=" + expression + ", expressionClass="
                + expression.getClass().getName() + ", supported=" + expressionToEvaluation.keySet();
    }

}
