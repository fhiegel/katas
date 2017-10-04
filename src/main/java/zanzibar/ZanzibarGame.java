package zanzibar;

public class ZanzibarGame {
    
    private DiceThrower diceThrower = new DiceThrower();
    
    /**
     * N'aurait jamais du être visible
     */
    ZanzibarDiceRollResult diceResult(int dice1, int dice2, int dice3) {
        return new ZanzibarDiceRollResult(dice1, dice2, dice3);
    }
    
    public ZanzibarDiceRollResult roll() {
        return diceResult(rollDice(), rollDice(), rollDice());
    }
    
    private int rollDice() {
        return diceThrower.roll();
    }
    
    public ZanzibarDiceRollResult reroll() {
        return diceResult(rollDice(), rollDice(), rollDice());
    }
    
    public ZanzibarDiceRollResult reroll(ZanzibarDiceRollResult previous, int dice) {
        if (!previous.hasDice(dice)) {
            previous.setErrorMessage("Cannot keep inexistant \"" + dice + "\".");
            return previous;
        } else {
            return diceResult(dice, rollDice(), rollDice());
        }
    }
    
    public ZanzibarDiceRollResult reroll(ZanzibarDiceRollResult previous, int dice1, int dice2) {
        if (!previous.hasDice(dice1)) {
            previous.setErrorMessage("Cannot keep inexistant \"" + dice1 + "\".");
            return previous;
        } else if (!previous.hasDice(dice2)) {
            previous.setErrorMessage("Cannot keep inexistant \"" + dice2 + "\".");
            return previous;
        }
        return diceResult(dice1, dice2, rollDice());
    }

    public ZanzibarTurn startTurn() {
        return new ZanzibarTurn(this);
    }
    
}
