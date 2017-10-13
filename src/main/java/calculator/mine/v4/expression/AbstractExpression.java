package calculator.mine.v4.expression;

public abstract class AbstractExpression implements Expression {

    public final Expression then(Expression after) {
        ExpressionDispatcher dispatcher = defaultDispatcher();
        dispatcher = configure(dispatcher);
        return dispatcher.dispatch(after);
    }

    protected ExpressionDispatcher configure(ExpressionDispatcher dispatcher) {
        return dispatcher;
    }

    private ExpressionDispatcher defaultDispatcher() {
        return new ExpressionDispatcher(this)
                .when(NeutralExpression.class, neutral -> this);
    }

    protected final String printDelegate(Expression delegate) {
        return delegate != null ? delegate.print() : "null";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + print() + "}";
    }

}
