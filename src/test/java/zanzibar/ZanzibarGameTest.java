package zanzibar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

// Erreur 1 : Je ne suis pas parti sur une objet "Dice Result", mais sur l'objet "Game" qui possédait la logique métier
// Erreur 2 : La signature de mes méthodes reroll n'est pas aepxlicite, car on ne sais pas si on doit garder/relacer les valeurs en arguement.
public class ZanzibarGameTest {
    
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    
    @Mock
    private DiceThrower diceThrower;
    
    @InjectMocks
    private ZanzibarGame game;
    
    @Test
    public void should_scores_one_when_scores_any_roll() throws Exception {
        ZanzibarDiceRollResult diceResult = game.diceResult(1, 3, 4);
        assertThat(diceResult.score()).isEqualTo(1);
    }
    
    @Test
    public void should_scores_one_when_get_nenette() throws Exception {
        ZanzibarDiceRollResult diceResult = game.diceResult(1, 2, 2);
        assertThat(diceResult.score()).isEqualTo(1);
    }
    
    @Test
    public void should_scores_two_when_get_any_suite() throws Exception {
        ZanzibarDiceRollResult diceResult = game.diceResult(1, 2, 3);
        assertThat(diceResult.score()).isEqualTo(2);
    }
    
    @Test
    public void should_scores_two_when_get_a_disordered() throws Exception {
        ZanzibarDiceRollResult diceResult = game.diceResult(5, 4, 6);
        assertThat(diceResult.score()).isEqualTo(2);
    }
    
    @Test
    public void should_scores_two_when_get_a_triple_two() throws Exception {
        ZanzibarDiceRollResult diceResult = game.diceResult(2, 2, 2);
        assertThat(diceResult.score()).isEqualTo(2);
    }
    
    @Test
    public void should_scores_four_when_get_a_triple_four() throws Exception {
        ZanzibarDiceRollResult diceResult = game.diceResult(4, 4, 4);
        assertThat(diceResult.score()).isEqualTo(4);
    }
    
    @Test
    public void should_scores_seven_when_get_a_triple_one() throws Exception {
        ZanzibarDiceRollResult diceResult = game.diceResult(1, 1, 1);
        assertThat(diceResult.score()).isEqualTo(7);
    }
    
    @Test
    public void should_scores_five_when_get_a_five_to_aces() throws Exception {
        ZanzibarDiceRollResult diceResult = game.diceResult(1, 5, 1);
        assertThat(diceResult.score()).isEqualTo(5);
    }
    
    @Test
    public void should_scores_eights_when_get_a_421() throws Exception {
        ZanzibarDiceRollResult diceResult = game.diceResult(1, 4, 2);
        assertThat(diceResult.score()).isEqualTo(8);
    }
    
    @Test
    public void should_prints_421_as_421() throws Exception {
        ZanzibarDiceRollResult diceResult = game.diceResult(1, 4, 2);
        assertThat(diceResult.toString()).isEqualTo("ZanzibarDiceRollResult{421}");
    }
    
    @Test
    public void should_a_suite_be_greater_than_a_nofigure() throws Exception {
        ZanzibarDiceRollResult suite = game.diceResult(1, 2, 3);
        ZanzibarDiceRollResult noFigure = game.diceResult(1, 3, 5);
        
        assertThat(suite).isGreaterThan(noFigure);
    }
    
    @Test
    public void should_a_nonfigure_be_greater_than_another_when_it_has_a_greater_highest_dice_roll() throws Exception {
        ZanzibarDiceRollResult noFigureWithSix = game.diceResult(1, 2, 6);
        ZanzibarDiceRollResult noFigure = game.diceResult(4, 5, 5);
        
        assertThat(noFigureWithSix).isGreaterThan(noFigure);
    }
    
    @Test
    public void should_a_triple_be_greater_than_equivalent_aces_figures() throws Exception {
        ZanzibarDiceRollResult triple = game.diceResult(4, 4, 4);
        ZanzibarDiceRollResult diceToAces = game.diceResult(4, 1, 1);
        
        assertThat(triple).isGreaterThan(diceToAces);
    }
    
    @Test
    public void should_roll_throws_tree_d6_an_create_proper_result() throws Exception {
        when(diceThrower.roll()).thenReturn(2, 6, 4);
        
        ZanzibarDiceRollResult result = game.roll();
        
        assertThat(result).isEqualTo(new ZanzibarDiceRollResult(2, 6, 4));
    }
    
    @Test
    public void should_reroll_a_result_create_new_proper_result() throws Exception {
        when(diceThrower.roll()).thenReturn(5, 5, 5);
        
        ZanzibarDiceRollResult result = game.reroll();
        
        assertThat(result).isEqualTo(new ZanzibarDiceRollResult(5, 5, 5));
    }
    
    @Test
    public void should_reroll_a_result_keeping_one_dice_create_new_proper_result() throws Exception {
        when(diceThrower.roll()).thenReturn(5, 5, 5);
        ZanzibarDiceRollResult initialResult = new ZanzibarDiceRollResult(2, 6, 4);
        
        ZanzibarDiceRollResult result = game.reroll(initialResult, 2);
        
        assertThat(result).isEqualTo(new ZanzibarDiceRollResult(2, 5, 5));
    }
    
    @Test
    public void should_reroll_a_result_keeping_two_dices_create_new_proper_result() throws Exception {
        when(diceThrower.roll()).thenReturn(5, 5, 5);
        ZanzibarDiceRollResult initialResult = new ZanzibarDiceRollResult(2, 6, 1);
        
        ZanzibarDiceRollResult actualResult = game.reroll(initialResult, 2, 1);
        
        assertThat(actualResult).isEqualTo(new ZanzibarDiceRollResult(1, 2, 5));
    }
    
    @Test
    public void should_not_reroll_a_dice_you_dont_have() throws Exception {
        when(diceThrower.roll()).thenReturn(5, 5, 5);
        ZanzibarDiceRollResult initialResult = new ZanzibarDiceRollResult(2, 6, 4);
        
        ZanzibarDiceRollResult actualResult = game.reroll(initialResult, 3);
        
        assertThat(actualResult).isEqualTo(initialResult);
        assertThat(actualResult.getErrorMessage()).isEqualTo("Cannot keep inexistant \"3\".");
    }
    
    @Test
    public void should_not_reroll_dices_you_dont_have() throws Exception {
        when(diceThrower.roll()).thenReturn(5, 5, 5);
        ZanzibarDiceRollResult initialResult = new ZanzibarDiceRollResult(2, 6, 4);
        
        ZanzibarDiceRollResult actualResult = game.reroll(initialResult, 3, 5);
        
        assertThat(actualResult).isEqualTo(initialResult);
        assertThat(actualResult.getErrorMessage()).isEqualTo("Cannot keep inexistant \"3\".");
    }
    
    @Test
    public void should_find_a_winner_for_a_turn() throws Exception {
        // Given
        when(diceThrower.roll()).thenReturn(5, 5, 5, 2, 2, 1);
        
        // When
        ZanzibarTurn turn = game.startTurn();
        turn.player("Player One").roll();
        turn.player("Player Two").roll();
        
        
        // Then
        ZanzibarPlayerTurn winner = turn.getWinner();
        assertThat(winner.getName()).isEqualTo("Player One");
    }
}
