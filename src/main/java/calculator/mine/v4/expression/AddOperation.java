package calculator.mine.v4.expression;

public class AddOperation extends AbstractArithmeticOperation {

    public static final AddOperation EMPTY = new AddOperation();

    private AddOperation() {
        this(null, null);
    }

    private AddOperation(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    @Override
    ArithmeticExpression copy(ArithmeticExpression left, ArithmeticExpression right) {
        return new AddOperation(left, right);
    }

    @SuppressWarnings("unchecked")
    @Override
    public IntegerExpression evaluate() {
        IntegerExpression evaluatedLeft = left.evaluate();
        IntegerExpression evaluatedRight = right.evaluate();
        return new IntegerExpression(evaluatedLeft.value() + evaluatedRight.value());
    }

    @Override
    public String print() {
        return printDelegate(left) + "+" + printDelegate(right);
    }

}
