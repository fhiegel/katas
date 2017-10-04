package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class ExpressionDispatcher {

    private final Map<Class<? extends Expression>, Function<Expression, ? extends Expression>> expressionToEvaluation = new HashMap<>();
    private final Expression origin;

    private Function<Expression, ? extends Expression> defaultEvaluation = expression -> {
        throw new IllegalArgumentException(unsupportedExpressionMessage(expression));
    };

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
        return expressionToEvaluation.getOrDefault(receiver.getClass(), defaultEvaluation).apply(receiver);
    }

    private String unsupportedExpressionMessage(Expression expression) {
        return "Origin " + origin.getClass().getName() + " cannot handle Expression : expression=" + expression + ", expressionClass="
                + expression.getClass().getName() + ", supported=" + expressionToEvaluation.keySet();
    }

}
