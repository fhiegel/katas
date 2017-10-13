package calculator.mine.v4.expression;

abstract class AbstractArithmeticOperation extends AbstractExpression implements ArithmeticExpression {

    protected final ArithmeticExpression left;
    protected final ArithmeticExpression right;

    public AbstractArithmeticOperation() {
        this(null, null);
    }

    protected AbstractArithmeticOperation(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    protected ExpressionDispatcher configure(ExpressionDispatcher dispatcher) {
        return dispatcher
                .when(AddOperation.class, add -> add.assignLeft(this))
                .when(MinusOperation.class, minus -> minus.assignLeft(this))
                .when(PowerOperation.class, pow -> pow.assignLeft(this))
                .when(MultiplyOperation.class, this::assignRight)
                .when(IntegerExpression.class, this::assignRight)
                .when(AbstractArithmeticOperation.class, this::assignRight)
                .when(ArithmeticExpression.class, this::assignRight);
    }

    ArithmeticExpression assignLeft(ArithmeticExpression left) {
        ArithmeticExpression effectiveLeft = this.left == null ? left : (ArithmeticExpression) this.left.then(left);
        return copy(effectiveLeft, right);
    }

    ArithmeticExpression assignRight(ArithmeticExpression right) {
        ArithmeticExpression effectiveRight = this.right == null ? right : (ArithmeticExpression) this.right.then(right);
        return copy(left, effectiveRight);
    }
    
    abstract ArithmeticExpression copy(ArithmeticExpression left, ArithmeticExpression right);

}
