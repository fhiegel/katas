package romannumeral.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RomanNumeralTest {
    
    @Test
    public void should_print_I_for_one() {
        RomanNumeral romanNumeral = new RomanNumeral(1);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("I");
    }
    
    @Test
    public void should_print_II_for_two() {
        RomanNumeral romanNumeral = new RomanNumeral(2);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("II");
    }

    @Test
    public void should_print_III_for_three() {
        RomanNumeral romanNumeral = new RomanNumeral(3);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("III");
    }
    
    @Test
    public void should_print_V_for_five() {
        RomanNumeral romanNumeral = new RomanNumeral(5);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("V");
    }
    
    @Test
    public void should_print_X_for_ten() {
        RomanNumeral romanNumeral = new RomanNumeral(10);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("X");
    }
    
    @Test
    public void should_print_XX_for_twenty() {
        RomanNumeral romanNumeral = new RomanNumeral(20);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("XX");
    }
    
    @Test
    public void should_print_L_for_fifty() {
        RomanNumeral romanNumeral = new RomanNumeral(50);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("L");
    }
    
    @Test
    public void should_print_C_for_hundred() {
        RomanNumeral romanNumeral = new RomanNumeral(100);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("C");
    }
    
    @Test
    public void should_print_CC_for_two_hundred() {
        RomanNumeral romanNumeral = new RomanNumeral(200);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("CC");
    }
    
    @Test
    public void should_print_D_for_five_hundred() {
        RomanNumeral romanNumeral = new RomanNumeral(500);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("D");
    }

    @Test
    public void should_print_M_for_one_thousand() {
        RomanNumeral romanNumeral = new RomanNumeral(1_000);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("M");
    }
    
    @Test
    public void should_print_MM_for_two_thousand() {
        RomanNumeral romanNumeral = new RomanNumeral(2_000);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("MM");
    }
    
    @Test
    public void should_print_VI_for_six() {
        RomanNumeral romanNumeral = new RomanNumeral(6);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("VI");
    }
    
    @Test
    public void should_print_VII_for_seven() {
        RomanNumeral romanNumeral = new RomanNumeral(7);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("VII");
    }
    
    @Test
    public void should_print_XI_for_eleven() {
        RomanNumeral romanNumeral = new RomanNumeral(11);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("XI");
    }
    
    @Test
    public void should_print_LI_for_51() {
        RomanNumeral romanNumeral = new RomanNumeral(51);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("LI");
    }
    
    @Test
    public void should_print_CI_for_101() {
        RomanNumeral romanNumeral = new RomanNumeral(101);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("CI");
    }
    
    @Test
    public void should_print_DI_for_501() {
        RomanNumeral romanNumeral = new RomanNumeral(501);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("DI");
    }
    
    @Test
    public void should_print_MI_for_1001() {
        RomanNumeral romanNumeral = new RomanNumeral(1001);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("MI");
    }
    
    @Test
    public void should_print_XVI_for_16() {
        RomanNumeral romanNumeral = new RomanNumeral(16);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("XVI");
    }
    
    @Test
    public void should_print_XVII_for_17() {
        RomanNumeral romanNumeral = new RomanNumeral(17);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("XVII");
    }
    
    @Test
    public void should_print_MDCLXVI_for_1666() {
        RomanNumeral romanNumeral = new RomanNumeral(17);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("XVII");
    }
    
    @Test
    public void should_return_IV_for_4() {
        RomanNumeral romanNumeral = new RomanNumeral(4);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("IV");
    }
    
    @Test
    public void should_return_IX_for_9() {
        RomanNumeral romanNumeral = new RomanNumeral(9);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("IX");
    }
    
    @Test
    public void should_return_XIX_for_19() {
        RomanNumeral romanNumeral = new RomanNumeral(19);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("XIX");
    }
    
    @Test
    public void should_return_XL_for_40() {
        RomanNumeral romanNumeral = new RomanNumeral(40);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("XL");
    }
    
    @Test
    public void should_return_XC_for_90() {
        RomanNumeral romanNumeral = new RomanNumeral(90);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("XC");
    }
    
    @Test
    public void should_return_XCIX_for_99() {
        RomanNumeral romanNumeral = new RomanNumeral(99);
        
        String romanNumber = romanNumeral.toString();
        
        assertThat(romanNumber).isEqualTo("XCIX");
    }
}
