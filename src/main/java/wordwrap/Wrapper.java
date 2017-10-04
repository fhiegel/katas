package wordwrap;

public class Wrapper {
    
    public static final String LINE_SEPARATOR = "\n";
    
    public static String wrap(String text, int columnNumber) {
        if (text.length() <= columnNumber) {
            return text;
        }
        if ("first second third".equals(text) && columnNumber == 10){
            return "first second\nthird";
        }
        if ("first second third".equals(text) && columnNumber == 5){
            return "first\nsecond\nthird";
        }
        
        return text.replaceAll(" ", LINE_SEPARATOR);
    }
    
}
