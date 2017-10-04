package dices.thrower.v1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DiceParserTest {
    
    private static final int ROLLS = 10_000;
    private static final int PRECISION = 50;
    
    private static final int COUNT_OFFSET = ROLLS / PRECISION;
    private static final double AVERAGE_OFFSET = Double.valueOf(PRECISION * 10) / ROLLS;
    
    private static final double D2_AVERAGE = 1.5;
    
    private static final int D4 = 4;
    private static final double D4_AVERAGE = 2.5;
    
    private static final double D6_AVERAGE = 3.5;
    
    private static final double D8_AVERAGE = 4.5;
    
    private DiceParser diceParser;
    
    @Before
    public void beforeName() throws Exception {
        diceParser = new DiceParser();
    }
    
    @Test
    public void rollDice_1d2_should_return_not_null_dice_result() throws Exception {
        // Arrange
        String diceToRoll = "1d2";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isNotNull();
    }
    
    @Test
    public void rollDice_1d2_should_return_result_greater_than_or_equal_to_ONE() throws Exception {
        // Arrange
        String diceToRoll = "1d2";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isGreaterThanOrEqualTo(1);
    }
    
    @Test
    public void rollDice_1d2_should_return_result_lesser_than_or_equal_to_FOUR() throws Exception {
        // Arrange
        String diceToRoll = "1d2";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isLessThanOrEqualTo(2);
    }
    
    @Test
    public void rollDice_1d2_should_return_expected_average() throws Exception {
        // Arrange
        String diceToRoll = "1d2";
        
        // Act
        Integer sum = 0;
        sum = rollN(diceToRoll, sum, (s, rollResult) -> s += rollResult);
        double average = Double.valueOf(sum) / Double.valueOf(ROLLS);
        
        // Assert
        assertThat(average).isEqualTo(D2_AVERAGE, offset(AVERAGE_OFFSET));
    }
    
    @Test
    public void rollDice_1d2_should_return_expected_result_as_1_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d2";
        int expectedResult = 1;
        long expectedCount = Long.valueOf(ROLLS / 2);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        
        // Assert
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d2_should_return_expected_result_as_2_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d2";
        int expectedResult = 2;
        long expectedCount = Long.valueOf(ROLLS / 2);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        
        // Assert
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d4_should_return_not_null_dice_result() throws Exception {
        // Arrange
        String diceToRoll = "1d4";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isNotNull();
    }
    
    @Test
    public void rollDice_1d4_should_return_result_greater_than_or_equal_to_ONE() throws Exception {
        // Arrange
        String diceToRoll = "1d4";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isGreaterThanOrEqualTo(1);
    }
    
    @Test
    public void rollDice_1d4_should_return_result_lesser_than_or_equal_to_FOUR() throws Exception {
        // Arrange
        String diceToRoll = "1d4";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isLessThanOrEqualTo(4);
    }
    
    @Test
    public void rollDice_1d4_should_return_expected_average() throws Exception {
        // Arrange
        String diceToRoll = "1d4";
        
        // Act
        Integer sum = 0;
        sum = rollN(diceToRoll, sum, (s, rollResult) -> s += rollResult);
        double average = Double.valueOf(sum) / Double.valueOf(ROLLS);
        
        // Assert
        assertThat(average).isEqualTo(D4_AVERAGE, offset(AVERAGE_OFFSET));
    }
    
    @Test
    public void rollDice_1d4_should_return_expected_result_as_1_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d4";
        int expectedResult = 1;
        long expectedCount = Long.valueOf(ROLLS / 4);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        
        // Assert
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d4_should_return_expected_result_as_2_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d4";
        int expectedResult = 2;
        long expectedCount = Long.valueOf(ROLLS / 4);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        
        // Assert
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d4_should_return_expected_result_as_3_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d4";
        int expectedResult = 3;
        long expectedCount = Long.valueOf(ROLLS / 4);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d4_should_return_expected_result_as_4_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d4";
        int expectedResult = 4;
        long expectedCount = Long.valueOf(ROLLS / 4);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d6_should_return_not_null_dice_result() throws Exception {
        // Arrange
        String diceToRoll = "1d6";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isNotNull();
    }
    
    @Test
    public void rollDice_1d6_should_return_result_greater_than_or_equal_to_ONE() throws Exception {
        // Arrange
        String diceToRoll = "1d6";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isGreaterThanOrEqualTo(1);
    }
    
    @Test
    public void rollDice_1d6_should_return_result_lesser_than_or_equal_to_FOUR() throws Exception {
        // Arrange
        String diceToRoll = "1d6";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isLessThanOrEqualTo(6);
    }
    
    @Test
    public void rollDice_1d6_should_return_expected_average() throws Exception {
        // Arrange
        String diceToRoll = "1d6";
        
        // Act
        Integer sum = 0;
        sum = rollN(diceToRoll, sum, (s, rollResult) -> s += rollResult);
        double average = Double.valueOf(sum) / Double.valueOf(ROLLS);
        
        // Assert
        assertThat(average).isEqualTo(D6_AVERAGE, offset(AVERAGE_OFFSET));
    }
    
    @Test
    public void rollDice_1d6_should_return_expected_result_as_1_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d6";
        int expectedResult = 1;
        long expectedCount = Long.valueOf(ROLLS / 6);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d6_should_return_expected_result_as_2_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d6";
        int expectedResult = 2;
        long expectedCount = Long.valueOf(ROLLS / 6);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d6_should_return_expected_result_as_3_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d6";
        int expectedResult = 3;
        long expectedCount = Long.valueOf(ROLLS / 6);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d6_should_return_expected_result_as_4_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d6";
        int expectedResult = 4;
        long expectedCount = Long.valueOf(ROLLS / 6);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d6_should_return_expected_result_as_5_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d6";
        int expectedResult = 5;
        long expectedCount = Long.valueOf(ROLLS / 6);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d6_should_return_expected_result_as_6_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d6";
        int expectedResult = 6;
        long expectedCount = Long.valueOf(ROLLS / 6);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d8_should_return_not_null_dice_result() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isNotNull();
    }
    
    @Test
    public void rollDice_1d8_should_return_result_greater_than_or_equal_to_ONE() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isGreaterThanOrEqualTo(1);
    }
    
    @Test
    public void rollDice_1d8_should_return_result_lesser_than_or_equal_to_FOUR() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isLessThanOrEqualTo(8);
    }
    
    @Test
    public void rollDice_1d8_should_return_expected_average() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        
        // Act
        Integer sum = 0;
        sum = rollN(diceToRoll, sum, (s, rollResult) -> s += rollResult);
        double average = Double.valueOf(sum) / Double.valueOf(ROLLS);
        
        // Assert
        assertThat(average).isEqualTo(D8_AVERAGE, offset(AVERAGE_OFFSET));
    }
    
    @Test
    public void rollDice_1d8_should_return_expected_result_as_1_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        int expectedResult = 1;
        long expectedCount = Long.valueOf(ROLLS / 8);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d8_should_return_expected_result_as_2_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        int expectedResult = 2;
        long expectedCount = Long.valueOf(ROLLS / 8);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d8_should_return_expected_result_as_3_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        int expectedResult = 3;
        long expectedCount = Long.valueOf(ROLLS / 8);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d8_should_return_expected_result_as_4_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        int expectedResult = 4;
        long expectedCount = Long.valueOf(ROLLS / 8);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d8_should_return_expected_result_as_5_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        int expectedResult = 5;
        long expectedCount = Long.valueOf(ROLLS / 8);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d8_should_return_expected_result_as_6_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        int expectedResult = 6;
        long expectedCount = Long.valueOf(ROLLS / 8);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d8_should_return_expected_result_as_7_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        int expectedResult = 7;
        long expectedCount = Long.valueOf(ROLLS / 8);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d8_should_return_expected_result_as_8_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "1d8";
        int expectedResult = 8;
        long expectedCount = Long.valueOf(ROLLS / 8);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        
        // Assert
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_2d2_should_return_not_null_dice_result() throws Exception {
        // Arrange
        String diceToRoll = "2d2";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isNotNull();
    }
    
    @Test
    public void rollDice_2d2_should_return_result_greater_than_or_equal_to_TWO() throws Exception {
        // Arrange
        String diceToRoll = "2d2";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isGreaterThanOrEqualTo(2);
    }
    
    @Test
    public void rollDice_2d2_should_return_result_lesser_than_or_equal_to_FOUR() throws Exception {
        // Arrange
        String diceToRoll = "2d2";
        
        // Act
        Integer diceResult = diceParser.rollDice(diceToRoll);
        
        // Assert
        assertThat(diceResult).isLessThanOrEqualTo(4);
    }
    
    @Test
    public void rollDice_2d2_should_return_expected_average() throws Exception {
        // Arrange
        String diceToRoll = "2d2";
        
        // Act
        Integer sum = 0;
        sum = rollN(diceToRoll, sum, (s, rollResult) -> s += rollResult);
        double average = Double.valueOf(sum) / Double.valueOf(ROLLS);
        
        // Assert
        assertThat(average).isEqualTo(2 * D2_AVERAGE, offset(AVERAGE_OFFSET));
    }
    
    @Test
    public void rollDice_2d2_should_return_expected_result_as_2_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "2d2";
        int expectedResult = 2;
        long expectedCount = Long.valueOf(ROLLS / 4);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        
        // Assert
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_2d2_should_return_expected_result_as_3_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "2d2";
        int expectedResult = 3;
        long expectedCount = Long.valueOf(ROLLS / 2);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        
        // Assert
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_2d2_should_return_expected_result_as_4_counts_for_10_000_rolls() throws Exception {
        // Arrange
        String diceToRoll = "2d2";
        int expectedResult = 4;
        long expectedCount = Long.valueOf(ROLLS / 4);
        
        // Act
        Collection<Integer> diceResults = new ArrayList<Integer>();
        rollN(diceToRoll, d -> diceResults.add(d));
        long actualCountOfExpectedResults = diceResults.stream().filter(in -> in == expectedResult).count();
        
        // Assert
        assertThat(actualCountOfExpectedResults).isBetween(expectedCount - COUNT_OFFSET, expectedCount + COUNT_OFFSET);
    }
    
    @Test
    public void rollDice_1d4plus1_should_call_diceThrower_and_add_one() throws Exception {
        // Arrange
        DiceThrower diceThrower = mockDiceThrower();
        when(diceThrower.rollDice(D4)).thenReturn(4);
        
        // Act
        Integer diceResult = diceParser.rollDice("1d4+1");
        
        // Assert
        assertThat(diceResult).isEqualTo(5);
    }
    
    @Test
    public void rollDice_1d4minus1_should_call_diceThrower_and_substract_one() throws Exception {
        // Arrange
        DiceThrower diceThrower = mockDiceThrower();
        when(diceThrower.rollDice(D4)).thenReturn(4);
        
        // Act
        Integer diceResult = diceParser.rollDice("1d4-1");
        
        // Assert
        assertThat(diceResult).isEqualTo(3);
    }
    
    // ---------------------------
    // --- Utilitaires
    // ---------------------------
    
    private <R> R rollN(String diceToRoll, R result, DiceAccumulator<R> onResultOperation) {
        R mutableResult = result;
        for (int i = 1; i <= ROLLS; i++) {
            mutableResult = onResultOperation.accept(diceParser.rollDice(diceToRoll), mutableResult);
        }
        return mutableResult;
    }
    
    private void rollN(String diceToRoll, Consumer<Integer> diceConsumer) {
        for (int i = 1; i <= ROLLS; i++) {
            diceConsumer.accept(diceParser.rollDice(diceToRoll));
        }
    }
    
    private DiceThrower mockDiceThrower() {
        DiceThrower diceThrower = Mockito.mock(DiceThrower.class);
        diceParser = new DiceParser(diceThrower);
        return diceThrower;
    }
    
    @FunctionalInterface
    public static interface DiceAccumulator<R> {
        R accept(Integer diceResult, R result);
    }
}
