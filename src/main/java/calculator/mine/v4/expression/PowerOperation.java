package calculator.mine.v4.expression;

public class PowerOperation extends AbstractArithmeticOperation {

    public static final PowerOperation EMPTY = new PowerOperation();

    private PowerOperation() {
        super(null, null);
    }

    private PowerOperation(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    @Override
    ArithmeticExpression copy(ArithmeticExpression left, ArithmeticExpression right) {
        return new PowerOperation(left, right);
    }

    @SuppressWarnings("unchecked")
    @Override
    public IntegerExpression evaluate() {
        IntegerExpression evaluatedLeft = left.evaluate();
        IntegerExpression evaluatedRight = right.evaluate();
        return new IntegerExpression((int) Math.pow(evaluatedLeft.value(), evaluatedRight.value()));
    }

    @Override
    protected ExpressionDispatcher configure(ExpressionDispatcher dispatcher) {
        return super.configure(dispatcher).when(MultiplyOperation.class, multiply -> multiply.assignLeft(this));
    }

    @Override
    public String print() {
        return printDelegate(left) + "^" + printDelegate(right);
    }

}
