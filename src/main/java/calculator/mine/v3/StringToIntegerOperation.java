package calculator.mine.v3;

import java.util.function.Function;

enum StringToIntegerOperation {
    PLUS("+", (left, right) -> left + right),
    
    MINUS("-", (left, right) -> left - right),
    
    MULTIPLY("*", (left, right) -> left * right),
    
    POWER("^", (left, right) -> (int) Math.pow(left, right));
    
    private static final String ESCAPE_PREFIX = "\\";
    
    private String regex;
    private String separator;
    private IntegerOperation operation;
    
    private StringToIntegerOperation(String separator, IntegerOperation function) {
        this.regex = ESCAPE_PREFIX + separator;
        this.separator = separator;
        this.operation = function;
    }
    
    @FunctionalInterface
    interface IntegerOperation {
        Integer apply(Integer left, Integer right);
    }
    
    public boolean mayApplyOperation(String appliyableString) {
        if (appliyableString == null || appliyableString.isEmpty()) {
            return false;
        }
        return appliyableString.matches(".+" + regex + ".+");
    }
    
    public Integer apply(String sentence, Function<String, Integer> parser) {
        String left = getLeftOperand(sentence);
        String right = getRightOperand(sentence);
        return operation.apply(parser.apply(left), parser.apply(right));
    }
    
    private String getLeftOperand(String sentence) {
        if (this.equals(POWER)) {
            return sentence.subSequence(0, sentence.lastIndexOf(separator)).toString();
        }
        String[] sentenceAsArray = sentence.split(regex, 2);
        return sentenceAsArray[0];
    }
    
    private String getRightOperand(String sentence) {
        if (this.equals(POWER)) {
            String[] split = sentence.split(regex);
            return split[split.length - 1];
        }
        String[] sentenceAsArray = sentence.split(regex, 2);
        return sentenceAsArray[1];
    }
}