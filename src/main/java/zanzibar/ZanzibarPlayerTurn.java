package zanzibar;

public class ZanzibarPlayerTurn {
    
    private String name;
    private ZanzibarGame zanzibarGame;
    private ZanzibarDiceRollResult diceRollResult;
    
    public ZanzibarPlayerTurn(ZanzibarGame zanzibarGame, String name) {
        this.zanzibarGame = zanzibarGame;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void roll() {
        diceRollResult = zanzibarGame.roll();
    }
    
    public ZanzibarDiceRollResult getDiceResult() {
        return diceRollResult;
    }
    
}
