package calculator.mine.v4.expression;

final class NeutralExpression implements Expression {
    NeutralExpression() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Expression> T evaluate() {
        return ((T) this);
    }

    @Override
    public Expression then(Expression after) {
        return after;
    }

    @Override
    public String toString() {
        return print();
    }

    @Override
    public String print() {
        return "<neutral>";
    }
    
}