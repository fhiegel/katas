package calculator.mine.v4.expression;

public class MinusOperation extends AbstractArithmeticOperation {

    public static final MinusOperation EMPTY = new MinusOperation();

    private MinusOperation() {
        super(null, null);
    }

    private MinusOperation(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    @Override
    ArithmeticExpression copy(ArithmeticExpression left, ArithmeticExpression right) {
        return new MinusOperation(left, right);
    }

    @SuppressWarnings("unchecked")
    @Override
    public IntegerExpression evaluate() {
        IntegerExpression evaluatedLeft = left.evaluate();
        IntegerExpression evaluatedRight = right.evaluate();
        return new IntegerExpression(evaluatedLeft.value() - evaluatedRight.value());
    }

    @Override
    public String print() {
        return printDelegate(left) + "-" + printDelegate(right);
    }

}
