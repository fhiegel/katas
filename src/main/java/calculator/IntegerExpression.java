package calculator;

public class IntegerExpression extends ValuedExpression<Integer> implements ArithmeticExpression {

    public IntegerExpression(Integer value) {
        super(value);
    }

    @Override
    protected ExpressionDispatcher resolve(ExpressionDispatcher dispatcher) {
        return dispatcher.when(AddOperation.class, add -> add.assignLeft(this))
                .when(IntegerExpression.class, this::concat);
    }

    
    private TextExpression concat(ValuedExpression<?> other) {
        return new TextExpression(value() + " " + other.value());
    }
}
