package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assume.assumeTrue;

import org.junit.Test;

public class ExpressionTokenizerTest {

    @Test
    public void should_have_single_token() throws Exception {
        // Given
        ExpressionTokenizer tokenizer = new ExpressionTokenizer("1");

        // When
        boolean hasToken = tokenizer.hasToken();

        // Then
        assertThat(hasToken).isTrue();
    }

    @Test
    public void should_get_single_token() throws Exception {
        // Given
        ExpressionTokenizer tokenizer = new ExpressionTokenizer("1");
        
        // When
        ExpressionToken token = tokenizer.nextToken();
        
        // Then
        assertThat(token).isNotNull();
        assertThat(token.toString()).isEqualTo("1");
    }
    
    @Test
    public void should_get_next_empties_tokenizer() throws Exception {
        // Given
        ExpressionTokenizer tokenizer = new ExpressionTokenizer("1");
        assumeTrue(tokenizer.hasToken());
        
        // When
        tokenizer.nextToken();
        boolean hasToken = tokenizer.hasToken();

        // Then
        assertThat(hasToken).isFalse();
    }
    
    @Test
    public void should_get_multiple_tokens() throws Exception {
        // Given
        ExpressionTokenizer tokenizer = new ExpressionTokenizer("1+2");
        
        // When
        ExpressionToken first = tokenizer.nextToken();
        ExpressionToken second = tokenizer.nextToken();
        ExpressionToken third = tokenizer.nextToken();
        
        // Then
        assertThat(first.toString()).isEqualTo("1");
        assertThat(second.toString()).isEqualTo("+");
        assertThat(third.toString()).isEqualTo("2");
    }

}
