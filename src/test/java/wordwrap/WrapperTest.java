package wordwrap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import junit.framework.Test;

@RunWith(JUnitQuickcheck.class)
public class WrapperTest {
    
    @Property
    public void wrap_should_return_String_with_same_length(String text, int columnNumber) throws Exception {
        String wrappedText = Wrapper.wrap(text, columnNumber);
        
        int textLength = text.length();
        int wrappedTextLength = wrappedText.length();
        
        assertThat(wrappedTextLength).isEqualTo(textLength);
    }
    
    @Property
    public void wrap_should_not_split_single_words(int columnNumber) throws Exception {
        String text = "simpleWord";
        String wrappedText = Wrapper.wrap(text, columnNumber);
        
        assertThat(wrappedText).isEqualTo(text);
    }
    
    @Property
    public void wrap_should_split_two_words_when_column_number_is_smaller_than_text_lenght(int columnNumber) throws Exception {
        String text = "first second";
        Assume.assumeTrue(columnNumber < text.length());
        
        String wrappedText = Wrapper.wrap(text, columnNumber);
        
        assertThat(wrappedText).isEqualTo("first" + Wrapper.LINE_SEPARATOR + "second");
    }
    
    @Property
    public void wrap_should_not_split_two_words_when_column_number_is_greater_than_text_lenght(int columnNumber) throws Exception {
        String text = "first second";
        Assume.assumeTrue(columnNumber >= text.length());
        
        String wrappedText = Wrapper.wrap(text, columnNumber);
        
        assertThat(wrappedText).isEqualTo(text);
    }
    
    @Property
    public void foobarbar(int columnNumber) throws Exception {
        String text = "first second third";
        int firstSpaceIndex = text.indexOf(" ");
        Assume.assumeTrue(firstSpaceIndex < columnNumber);
        Assume.assumeTrue(columnNumber < text.length());
        
        String wrappedText = Wrapper.wrap(text, columnNumber);
        
        assertThat(wrappedText).isEqualTo("first second" + Wrapper.LINE_SEPARATOR + "third");
    }
    
    @org.junit.Test
    public void should_testName() throws Exception {
        assertThat(Wrapper.wrap("first second third", 10)).isEqualTo("first second" + Wrapper.LINE_SEPARATOR + "third");
    }
    
    @org.junit.Test
    public void should_testName2() throws Exception {
        assertThat(Wrapper.wrap("first second third", 5))
                .isEqualTo("first" + Wrapper.LINE_SEPARATOR + "second" + Wrapper.LINE_SEPARATOR + "third");
    }
    
}
