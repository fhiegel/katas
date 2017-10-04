package calculator.mine.v4;

public class TextExpression extends ValuedExpression<String> {

    private static final String CONCAT_SEPARATOR = " ";

    public TextExpression(String value) {
        super(value);
    }

    @Override
    protected ExpressionDispatcher resolve(ExpressionDispatcher dispatcher) {
        return dispatcher
                .when(TextExpression.class, this::concat)
                .when(ValuedExpression.class, this::concat);
    }

    private TextExpression concat(ValuedExpression<?> other) {
        return new TextExpression(value() + CONCAT_SEPARATOR + other.value());
    }

}
