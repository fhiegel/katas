package calculator;

public interface Expression {

    Expression NEUTRAL = new NeutralExpression();

    Expression then(Expression after);

    <T extends Expression> T evaluate();

    String print();

}
