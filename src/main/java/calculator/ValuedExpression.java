package calculator;

import java.util.Objects;

public abstract class ValuedExpression<T> extends AbstractExpression {

    private final T value;

    public ValuedExpression(T value) {
        this.value = Objects.requireNonNull(value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E extends Expression> E evaluate() {
        return (E) this;
    }

    protected final T value() {
        return value;
    }

    @Override
    public String print() {
        return String.valueOf(value);
    }

}
