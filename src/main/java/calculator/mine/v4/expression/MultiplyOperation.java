package calculator.mine.v4.expression;

public class MultiplyOperation extends AbstractArithmeticOperation {

    public static final MultiplyOperation EMPTY = new MultiplyOperation();

    private MultiplyOperation() {
        super(null, null);
    }

    private MultiplyOperation(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    @Override
    ArithmeticExpression copy(ArithmeticExpression left, ArithmeticExpression right) {
        return new MultiplyOperation(left, right);
    }

    @SuppressWarnings("unchecked")
    @Override
    public IntegerExpression evaluate() {
        IntegerExpression evaluatedLeft = left.evaluate();
        IntegerExpression evaluatedRight = right.evaluate();
        return new IntegerExpression(evaluatedLeft.value() * evaluatedRight.value());
    }

    @Override
    protected ExpressionDispatcher configure(ExpressionDispatcher dispatcher) {
        return super.configure(dispatcher)
                .when(PowerOperation.class, this::assignRight);
    }

    @Override
    public String print() {
        return printDelegate(left) + "*" + printDelegate(right);
    }

}
