package calculator.mine.v2;

public class StringCalculator {
    
    public Integer calc(String sentence) {
        if (sentence.contains("+")) {
            String[] splitSentence = sentence.split("\\+", 2);
            return calc(splitSentence[0]) + calc(splitSentence[1]);
        }
        if (sentence.contains("*")) {
            String[] splitSentence = sentence.split("\\*", 2);
            return calc(splitSentence[0]) * calc(splitSentence[1]);
        }
        return toInteger(sentence);
    }
    
    protected Integer toInteger(String integer) {
        if (integer.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(integer);
    }
    
}
