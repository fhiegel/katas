package calculator.mine.v4.expression;

public class IntegerExpression extends ValuedExpression<Integer> implements ArithmeticExpression {

    public IntegerExpression(Integer value) {
        super(value);
    }

    @Override
    protected ExpressionDispatcher configure(ExpressionDispatcher dispatcher) {
        return dispatcher
                .when(AddOperation.class, add -> add.assignLeft(this))
                .when(MinusOperation.class, add -> add.assignLeft(this))
                .when(MultiplyOperation.class, add -> add.assignLeft(this))
                .when(PowerOperation.class, add -> add.assignLeft(this))
                .when(IntegerExpression.class, this::concat);
    }

    
    private TextExpression concat(ValuedExpression<?> other) {
        return new TextExpression(value() + " " + other.value());
    }
}
