package calculator.mine.v2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import calculator.mine.v2.StringCalculator;

public class StringCalculatorTest {
    
    private StringCalculator calculator;
    
    @Before
    public void initializeCalculator() throws Exception {
        calculator = new StringCalculator();
    }
    
    @Test
    public void should_returns_zero_for_empty() throws Exception {
        // Arrange
        String sentence = "";
        
        // Act
        Integer result = calculator.calc(sentence);
        
        // Assert
        assertThat(result).isEqualTo(0);
    }
    
    @Test
    public void should_returns_zero_for_zero() throws Exception {
        // Arrange
        String sentence = "0";
        
        // Act
        Integer result = calculator.calc(sentence);
        
        // Assert
        assertThat(result).isEqualTo(0);
    }
    
    @Test
    public void should_returns_one_for_one() throws Exception {
        // Arrange
        String sentence = "1";
        
        // Act
        Integer result = calculator.calc(sentence);
        
        // Assert
        assertThat(result).isEqualTo(1);
    }
    
    @Test
    public void should_simply_add_two_numbers() throws Exception {
        // Arrange
        String sentence = "1+1";
        
        // Act
        Integer result = calculator.calc(sentence);
        
        // Assert
        assertThat(result).isEqualTo(2);
    }
    
    @Test
    public void should_simply_add_three_numbers() throws Exception {
        // Arrange
        String sentence = "1+1+2";
        
        // Act
        Integer result = calculator.calc(sentence);
        
        // Assert
        assertThat(result).isEqualTo(4);
    }
    
    @Test
    public void should_simply_multiply_two_numbers() throws Exception {
        // Arrange
        String sentence = "2*2";
        
        // Act
        Integer result = calculator.calc(sentence);
        
        // Assert
        assertThat(result).isEqualTo(4);
    }
    
    @Test
    public void should_simply_multiply_three_numbers() throws Exception {
        // Arrange
        String sentence = "2*2*2";
        
        // Act
        Integer result = calculator.calc(sentence);
        
        // Assert
        assertThat(result).isEqualTo(8);
    }
    
    @Test
    public void should_add_and_multiply_three_numbers_with_left_to_right() throws Exception {
        // Arrange
        String sentence = "2*2+3";
        
        // Act
        Integer result = calculator.calc(sentence);
        
        // Assert
        assertThat(result).isEqualTo(7);
    }
    
    
    @Test
    public void should_add_and_multiply_three_numbers_with_multiplication_priority() throws Exception {
        // Arrange
        String sentence = "2+2*3";
        
        // Act
        Integer result = calculator.calc(sentence);
        
        // Assert
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void should_add_and_multiply_four_numbers_with_multiplication_priority() throws Exception {
        // Arrange
        String sentence = "2+2*3+3";
        
        // Act
        Integer result = calculator.calc(sentence);
        
        // Assert
        assertThat(result).isEqualTo(11);
    }
    
    @Test
    public void should_simply_substract_two_numbers() throws Exception {
        // Arrange
        String sentence = "1-1";
        
        // Act
        Integer result = calculator.calc(sentence);
        
        // Assert
        assertThat(result).isEqualTo(0);
    }
    
}
