package zanzibar;

import java.util.Random;

public class DiceThrower {
    
    public int roll(){
        return rollDice(6);
    }
    
    private int rollDice(int dice) {
        return new Random().ints(1, dice + 1).findAny().getAsInt();
    }
    
}
