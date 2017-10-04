package calculator.string.v1;

public class StringCalculator {
    
    private static final String NUMBER_SEPARATOR = "[,\\n]";
    
    public static int add(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }
        
        Integer result = 0;
        String[] numbers = inputString.split(NUMBER_SEPARATOR);
        for (String number : numbers) {
            result += Integer.valueOf(number);
        }
        return result;
    }
    
}
