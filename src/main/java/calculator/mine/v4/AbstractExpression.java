package calculator.mine.v4;

import java.util.function.Function;

public abstract class AbstractExpression implements Expression {

    public final Expression then(Expression after) {
        ExpressionDispatcher dispatcher = defaultDispatcher();
        dispatcher = resolve(dispatcher);
        return dispatcher.dispatch(after);
    }

    protected ExpressionDispatcher resolve(ExpressionDispatcher dispatcher) {
        return dispatcher;
    }

    private ExpressionDispatcher defaultDispatcher() {
        return new ExpressionDispatcher(this)
                .when(Expression.class, Function.identity())
                .when(NeutralExpression.class, neutral -> this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + print() + "}";
    }
    
}
