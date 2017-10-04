package romannumeral.v1;

public class RomanNumeral {
    private int normalNumber;
    
    public RomanNumeral(int normalNumber) {
        this.normalNumber = normalNumber;
    }
    
    @Override
    public String toString() {
        return handle(normalNumber, 0);
    }
    
    private String handle(int toHandle, int digitIndex) {
        if (digitIndex == RomanDigit.values().length) {
            return "";
        }
        
        // Ajout des digits exacts
        RomanDigit romanDigit = RomanDigit.values()[digitIndex];
        String representation = "";
        int timesToHandle = toHandle / romanDigit.packs;
        for (int i = 1; i <= timesToHandle; i++) {
            representation += romanDigit.representation;
        }
        
        int nextDigitIndex = digitIndex + 1;
        int reste = toHandle % romanDigit.packs;
        
        // Gestion des X avant les cinquantaines
        RomanDigit ten = RomanDigit.TEN;
        
        int packMinusTen = romanDigit.packs - ten.packs;
        if (reste !=0 && reste == packMinusTen && nextDigitIndex < RomanDigit.values().length) {
            RomanDigit nextDigit = ten;
            representation += nextDigit.representation;
            representation += romanDigit.representation;
            return representation + handle(0, nextDigitIndex);
        }
        
        // Gestion des I avant les V et X
        RomanDigit one = RomanDigit.ONE;
        
        int packMinusOne = romanDigit.packs - one.packs;
        if (reste == packMinusOne && nextDigitIndex < RomanDigit.values().length) {
            RomanDigit nextDigit = one;
            representation += nextDigit.representation;
            representation += romanDigit.representation;
            return representation + handle(0, nextDigitIndex);
        }
        
        return representation + handle(reste, nextDigitIndex);
        
    }
    
    enum RomanDigit {
        THOUSAND(1_000, "M"), FIVE_HUNDRED(500, "D"), HUNDRED(100, "C"), FIFTY(50, "L"), TEN(10, "X"), FIVE(5, "V"), ONE(1, "I");
        
        private int packs;
        private String representation;
        
        private RomanDigit(int packs, String representation) {
            this.packs = packs;
            this.representation = representation;
        }
    }
}
