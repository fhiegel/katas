package yam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

/**
 * The kata consists of creating the rules to score a roll in any of a predefined category. Given a roll and a category, the final solution
 * should output the score for this roll placed in this category.<br>
 * <p>
 * Yahtzee rules description and suggested test cases
 * <p>
 * The following categories exists:
 * <ul>
 * <li>Ones, Twos, Threes, Fours, Fives, Sixes: The player scores the sum of the dice that reads one, two, three, four, five or six,
 * respectively. For example, 1, 1, 2, 4, 4 placed on "fours" gives 8 points.
 * <li>Pair: The player scores the sum of the two highest matching dice. For example, 3, 3, 3, 4, 4 placed on "pair" gives 8.
 * <li>Two pairs: If there are two pairs of dice with the same number, the player scores the sum of these dice. If not, the player scores 0.
 * For example, 1, 1, 2, 3, 3 placed on "two pairs" gives 8.
 * <li>Three of a kind: If there are three dice with the same number, the player scores the sum of these dice. Otherwise, the player scores
 * 0. For example, 3, 3, 3, 4, 5 places on "three of a kind" gives 9.
 * <li>Four of a kind: If there are four dice with the same number, the player scores the sum of these dice. Otherwise, the player scores 0.
 * For example, 2, 2, 2, 2, 5 places on "four of a kind" gives 8.
 * <li>Small straight: If the dice read 1,2,3,4,5, the player scores 15 (the sum of all the dice), otherwise 0.
 * <li>Large straight: If the dice read 2,3,4,5,6, the player scores 20 (the sum of all the dice), otherwise 0.
 * <li>Full house: If the dice are two of a kind and three of a kind, the player scores the sum of all the dice. For example, 1,1,2,2,2
 * placed on "full house" gives 8. 4,4,4,4,4 is not "full house".
 * <li>Yahtzee: If all dice are the have the same number, the player scores 50 points, otherwise 0.
 * <li>Chance: The player gets the sum of all dice, no matter what they read.
 * </ul>
 */
@RunWith(JUnitQuickcheck.class)
public class YamScoringTest {
    
    @Test
    public void score_return_zero_for_OneCategory_when_no_dice_equals_one() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("one", 2, 2, 3, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(0);
    }
    
    @Test
    public void score_return_one_for_OneCategory_when_diceOne_equals_one() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("one", 1, 2, 3, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(1);
    }
    
    @Test
    public void score_return_one_for_OneCategory_when_diceTwo_equals_one() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("one", 2, 1, 3, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(1);
    }
    
    @Test
    public void score_return_one_for_OneCategory_when_diceThree_equals_one() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("one", 2, 3, 1, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(1);
    }
    
    @Test
    public void score_return_two_for_OneCategory_when_diceOne_and_diceThree_equals_one() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("one", 1, 2, 1, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(2);
    }
    
    @Test
    public void score_return_two_for_TwoCategory_when_diceTwo_equals_one() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("two", 1, 2, 3, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(2);
    }
    
    @Test
    public void score_return_four_for_TwoCategory_when_diceTwo_and_diceThree_equals_two() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("two", 1, 2, 2, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(4);
    }
    
    @Test
    public void score_return_three_for_ThreeCategory_when_diceThree_equals_three() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("three", 1, 2, 3, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(3);
    }
    
    @Test
    public void score_return_six_for_ThreeCategory_when_diceTwo_and_diceThree_equals_three() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("three", 1, 3, 3, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(6);
    }
    
    @Test
    public void score_return_four_for_FourCategory_when_diceFour_equals_four() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("four", 1, 2, 3, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(4);
    }
    
    @Test
    public void score_return_eight_for_FourCategory_when_diceTwo_and_diceThree_equals_four() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("four", 1, 4, 4, 5, 6);
        
        // Assert
        assertThat(score).isEqualTo(8);
    }
    
    @Test
    public void score_return_five_for_FiveCategory_when_diceFour_equals_five() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("five", 1, 2, 3, 5, 6);
        
        // Assert
        assertThat(score).isEqualTo(5);
    }
    
    @Test
    public void score_return_ten_for_FiveCategory_when_diceTwo_and_diceThree_equals_five() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("five", 1, 5, 5, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(10);
    }
    
    @Test
    public void score_return_six_for_SixCategory_when_diceFive_equals_six() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("six", 1, 2, 3, 4, 6);
        
        // Assert
        assertThat(score).isEqualTo(6);
    }
    
    @Test
    public void score_return_twelve_for_FiveCategory_when_diceTwo_and_diceThree_equals_six() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("six", 1, 6, 6, 4, 4);
        
        // Assert
        assertThat(score).isEqualTo(12);
    }
    
    @Test
    public void score_return_fifty_for_YahtzeeCategory_when_all_dices_are_equals_to_one() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("yahtzee", 1, 1, 1, 1, 1);
        
        // Assert
        assertThat(score).isEqualTo(50);
    }
    
    @Test
    public void score_return_fifty_for_YahtzeeCategory_when_all_dices_but_one_are_equals() throws Exception {
        // Arrange
        // Act
        int score = YamScoring.getScore("yahtzee", 1, 2, 1, 1, 1);
        
        // Assert
        assertThat(score).isEqualTo(0);
    }
    
    @Test
    public void score_return_fifty_for_YahtzeeCategory_when_all_dices_are_equals_to_two() throws Exception {
        // Arrange
        // Act
        
        int score = YamScoring.getScore("yahtzee", 2, 2, 2, 2, 2);
        // Assert
        assertThat(score).isEqualTo(50);
    }
    
    @Test
    public void score_return_sum_for_chanceCategory_whatever_dices() throws Exception {
        // Arrange
        int diceOne = diceRoll();
        int diceTwo = diceRoll();
        int diceThree = diceRoll();
        int diceFour = diceRoll();
        int diceFive = diceRoll();
        
        // Act
        int score = YamScoring.getScore("chance", diceOne, diceTwo, diceThree, diceFour, diceFive);
        // Assert
        assertThat(score).isEqualTo(diceOne + diceTwo + diceThree + diceFour + diceFive);
    }
    
    @Test
    public void score_return_fifty_for_SmallStraightCategory_when_dices_are_in_small_straight() throws Exception {
        // Arrange
        // Act
        
        int score = YamScoring.getScore("small_straight", 1, 2, 3, 4, 5);
        // Assert
        assertThat(score).isEqualTo(15);
    }
    
    @Test
    public void score_return_zero_for_SmallStraightCategory_when_dices_are_not_small_straight() throws Exception {
        // Arrange
        // Act
        
        int score = YamScoring.getScore("small_straight", 1, 2, 2, 4, 5);
        // Assert
        assertThat(score).isEqualTo(0);
    }
    
    // Utilitaires
    
    private int diceRoll() {
        IntStream ints = new Random().ints(1, 7);
        int diceValue = ints.findAny().getAsInt();
        assertTrue(diceValue > 0 && diceValue <= 6);
        return diceValue;
    }
    
}
