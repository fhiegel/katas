package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionTokenizer {

    private Queue<ExpressionToken> expressionTokens = new LinkedList<>();

    public ExpressionTokenizer(String expression) {
        this(new ExpressionCompositeParser()
                .when("\\d+", e -> new IntegerExpression(Integer.valueOf(e)))
                .when("[+]", e -> new AddOperation())
                , expression);
    }

    public ExpressionTokenizer(ExpressionCompositeParser parser, String expression) {
        expressionTokens = tokenize(parser, expression);
    }

    private Queue<ExpressionToken> tokenize(ExpressionCompositeParser parser, String expression) {
        Matcher matcher = Pattern.compile(parser.pattern()).matcher(expression);
        return tokenizeAll(parser, matcher);
    }

    private Queue<ExpressionToken> tokenizeAll(ExpressionCompositeParser parser, Matcher matcher) {
        if (matcher.find()) {
            Queue<ExpressionToken> tokens = new LinkedList<>();
            tokens.add(tokenizeCurrent(parser, matcher));
            tokens.addAll(tokenizeAll(parser, matcher));
            return tokens;
        }
        return new LinkedList<>();
    }

    private ExpressionToken tokenizeCurrent(ExpressionCompositeParser parser, Matcher matcher) {
        String extractedExpression = matcher.group();
        ExpressionParser atomicParser = parser.find(extractedExpression);
        return new ExpressionToken(atomicParser, extractedExpression);
    }

    public boolean hasToken() {
        return !expressionTokens.isEmpty();
    }

    public ExpressionToken nextToken() {
        return expressionTokens.poll();
    }

}
