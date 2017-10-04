package calculator.string.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import calculator.string.v1.StringCalculator;

public class StringCalculatorTest {
    
    @Test
    public void empty_string_is_considered_as_zero() throws Exception {
        // Arrange
        String inputString = "";
        
        // Act
        int result = StringCalculator.add(inputString);
        
        // Assert
        assertThat(result).isEqualTo(0);
    }
    
    @Test
    public void one_as_string_return_one() throws Exception {
        // Arrange
        String inputString = "1";
        
        // Act
        int result = StringCalculator.add(inputString);
        
        // Assert
        assertThat(result).isEqualTo(1);
    }
    
    @Test
    public void one_and_one_as_string_return_two() throws Exception {
        // Arrange
        String inputString = "1,1";
        
        // Act
        int result = StringCalculator.add(inputString);
        
        // Assert
        assertThat(result).isEqualTo(2);
    }
    
    @Test
    public void any_numbers_as_string_return_theri_sum() throws Exception {
        // Arrange
        String inputString = "1,2,3,4,5,6,7,8,9";
        
        // Act
        int result = StringCalculator.add(inputString);
        
        // Assert
        assertThat(result).isEqualTo(45);
    }
    
    @Test
    public void one_and_one_with_return_line_return_two() throws Exception {
        // Arrange
        String inputString = "1\n1";
        
        // Act
        int result = StringCalculator.add(inputString);
        
        // Assert
        assertThat(result).isEqualTo(2);
    }
    
    @Test
    public void one_two_three_with_both_return_line_and_coma_return_six() throws Exception {
        // Arrange
        String inputString = "1,2\n3";
        
        // Act
        int result = StringCalculator.add(inputString);
        
        // Assert
        assertThat(result).isEqualTo(6);
    }
    
}
