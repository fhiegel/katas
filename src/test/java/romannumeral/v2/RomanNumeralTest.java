package romannumeral.v2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RomanNumeralTest {
    
    @Test
    public void roman_I_for_1() throws Exception {
        assertDecimalEqualsRoman(1, "I");
    }
    
    @Test
    public void roman_II_for_2() throws Exception {
        assertDecimalEqualsRoman(2, "II");
    }
    
    @Test
    public void roman_III_for_3() throws Exception {
        assertDecimalEqualsRoman(3, "III");
    }
    
    @Test
    public void roman_IV_for_4() throws Exception {
        assertDecimalEqualsRoman(4, "IV");
    }
    
    @Test
    public void roman_VI_for_6() throws Exception {
        assertDecimalEqualsRoman(6, "VI");
    }
    
    @Test
    public void roman_V_for_5() throws Exception {
        assertDecimalEqualsRoman(5, "V");
    }
    
    @Test
    public void roman_IX_for_9() throws Exception {
        assertDecimalEqualsRoman(9, "IX");
    }
    
    @Test
    public void roman_X_for_10() throws Exception {
        assertDecimalEqualsRoman(10, "X");
    }
    
    @Test
    public void roman_XI_for_11() throws Exception {
        assertDecimalEqualsRoman(11, "XI");
    }
    
    @Test
    public void roman_XIV_for_14() throws Exception {
        assertDecimalEqualsRoman(14, "XIV");
    }
    
    @Test
    public void roman_XV_for_15() throws Exception {
        assertDecimalEqualsRoman(15, "XV");
    }
    
    @Test
    public void roman_XX_for_20() throws Exception {
        assertDecimalEqualsRoman(20, "XX");
    }
    
    @Test
    public void roman_XXX_for_30() throws Exception {
        assertDecimalEqualsRoman(30, "XXX");
    }
    
    @Test
    public void roman_XL_for_40() throws Exception {
        assertDecimalEqualsRoman(40, "XL");
    }
    
    @Test
    public void roman_XLIX_for_49() throws Exception {
        assertDecimalEqualsRoman(49, "XLIX");
    }
    
    @Test
    public void roman_L_for_50() throws Exception {
        assertDecimalEqualsRoman(50, "L");
    }
    
    @Test
    public void roman_LI_for_51() throws Exception {
        assertDecimalEqualsRoman(51, "LI");
    }
    
    @Test
    public void roman_LII_for_52() throws Exception {
        assertDecimalEqualsRoman(52, "LII");
    }
    
    @Test
    public void roman_LIV_for_54() throws Exception {
        assertDecimalEqualsRoman(54, "LIV");
    }
    
    @Test
    public void roman_XCIX_for_99() throws Exception {
        assertDecimalEqualsRoman(99, "XCIX");
    }
    
    @Test
    public void roman_CDXLIV_for_444() throws Exception {
        assertDecimalEqualsRoman(444, "CDXLIV");
    }
    
    @Test
    public void roman_CDXLIX_for_449() throws Exception {
        assertDecimalEqualsRoman(449, "CDXLIX");
    }
    
    @Test
    public void roman_CDXCIV_for_494() throws Exception {
        assertDecimalEqualsRoman(494, "CDXCIV");
    }
    
    @Test
    public void roman_CDXCIX_for_499() throws Exception {
        assertDecimalEqualsRoman(499, "CDXCIX");
    }
    
    @Test
    public void should_print_MDCLXVI_for_1999() {
        assertDecimalEqualsRoman(1999, "MCMXCIX");
    }
    
    @Test
    public void should_print_MDCLXVI_for_1666() {
        assertDecimalEqualsRoman(1666, "MDCLXVI");
    }
    
    // Utilitaires
    
    private void assertDecimalEqualsRoman(int number, String expectedRoman) {
        String romanNumeral = RomanNumeral.toRomanNumeral(number);
        assertThat(romanNumeral).isEqualTo(expectedRoman);
    }
    
    private static void generateTU(int number, String romanNumeral) {
        String codeGenerated = "@Test\n" + "public void roman_" + romanNumeral + "_for_" + number + "() throws Exception {\n"
                + "assertDecimalEqualsRoman(" + number + ",\"" + romanNumeral + "\");\n" + "}\n";
        System.out.println(codeGenerated);
    }
}
