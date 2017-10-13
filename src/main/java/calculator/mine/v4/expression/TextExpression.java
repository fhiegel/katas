package calculator.mine.v4.expression;

public class TextExpression extends ValuedExpression<String> {

    private static final String CONCAT_SEPARATOR = " ";

    public TextExpression(String value) {
        super(value);
    }

    @Override
    protected ExpressionDispatcher configure(ExpressionDispatcher dispatcher) {
        return dispatcher
                .when(BoldTextExpression.class, bold -> bold.wrapText(this))
                .when(TextExpression.class, this::concat)
                .when(ValuedExpression.class, this::concat);
    }

    private TextExpression concat(ValuedExpression<?> other) {
        return new TextExpression(value() + CONCAT_SEPARATOR + other.value());
    }

}
