package romannumeral.v2;

public class RomanNumeral {
    
    enum RomanNubmer {
        THOUSAND(1000, "M"),
        NINE_HUNDRED(900, "CM"),
        FIVE_HUNDRED(500, "D"),
        FOUR_HUNDRED(400, "CD"),
        HUNDRED(100, "C"),
        NINTY(90, "XC"),
        FIFTY(50, "L"),
        FOURTY(40, "XL"),
        TEN(10, "X"),
        NINE(9, "IX"),
        FIVE(5, "V"),
        FOUR(4, "IV"),
        ONE(1, "I");
        
        private final int number;
        private final String romanNumber;
        
        private RomanNubmer(int number, String romanNumber) {
            this.number = number;
            this.romanNumber = romanNumber;
        }
        
        public String getRomanNumber() {
            return romanNumber;
        }
        
        public int getNumber() {
            return number;
        }
        
    }
    
    public static String toRomanNumeral(int number) {
        for (RomanNubmer romanNumer : RomanNubmer.values()) {
            if (number >= romanNumer.getNumber()) {
                return romanNumer.getRomanNumber() + toRomanNumeral(number - romanNumer.getNumber());
            }
        }
        return "";
    }
    
}
