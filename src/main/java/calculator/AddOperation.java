package calculator;

public class AddOperation extends AbstractExpression implements ArithmeticExpression {

    private final ArithmeticExpression left;
    private final ArithmeticExpression right;

    public AddOperation() {
        this(null, null);
    }

    public AddOperation(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    @SuppressWarnings("unchecked")
    @Override
    public IntegerExpression evaluate() {
        IntegerExpression evaluatedLeft = left.evaluate();
        IntegerExpression evaluatedRight = right.evaluate();
        return new IntegerExpression(evaluatedLeft.value() + evaluatedRight.value());
    }

    @Override
    protected ExpressionDispatcher resolve(ExpressionDispatcher dispatcher) {
        return dispatcher.when(AddOperation.class, add -> add.assignLeft(this)).when(IntegerExpression.class, this::assignRight).when(
                ArithmeticExpression.class, this::assignRight);
    }

    public AddOperation assignLeft(ArithmeticExpression left) {
        return new AddOperation(left, right);
    }

    public AddOperation assignRight(ArithmeticExpression right) {
        return new AddOperation(left, right);
    }

    @Override
    public String print() {
        return left.toString() + "+" + right.toString();
    }

}
