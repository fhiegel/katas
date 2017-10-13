package calculator.mine.v4.expression;

public class BoldTextExpression extends TextExpression {

    public static final BoldTextExpression EMPTY = new BoldTextExpression(null);

    private TextExpression text;

    private BoldTextExpression(TextExpression text) {
        super("*");
        this.text = text;
    }

    @SuppressWarnings("unchecked")
    @Override
    public TextExpression evaluate() {
        TextExpression evaluate = text.evaluate();
        return new TextExpression(value() + evaluate.value() + value());
    }

    @Override
    protected ExpressionDispatcher configure(ExpressionDispatcher dispatcher) {
        return super.configure(dispatcher).when(TextExpression.class, this::wrapText);
    }

    TextExpression wrapText(TextExpression text) {
        TextExpression effectiveText = this.text == null ? text : (TextExpression) this.text.then(text);
        return new BoldTextExpression(effectiveText);
    }

}
