package dices.thrower.v1;

import java.util.Arrays;

public class DiceParser {
    
    private static final String ADD_SEPARATOR = "\\+";
    private static final String MINUS_SEPARATOR = "\\-";
    private static final String DICE_SEPARATOR = "d";
    
    private DiceThrower diceThrower;
    
    public DiceParser() {
        this(new DiceThrower());
    }
    
    DiceParser(DiceThrower diceThrower) {
        this.diceThrower = diceThrower;
    }
    
    /**
     * Effecture le parsing, et les lancer de éds.
     * @param dicesDescription
     * @return
     */
    public Integer rollDice(String dicesDescription) {
        
        String[] diceDetails = dicesDescription.replaceAll(MINUS_SEPARATOR, ADD_SEPARATOR + MINUS_SEPARATOR).split(ADD_SEPARATOR);
        
        int sum = 0;
        for (String diceDescription : Arrays.asList(diceDetails)) {
            if (diceDescription.contains(DICE_SEPARATOR)) {
                sum += rollSingleDice(diceDescription);
            } else {
                sum += Integer.parseInt(diceDescription);
            }
        }
        return sum;
    }
    
    private Integer rollSingleDice(String diceDescription) {
        String[] diceDetails = diceDescription.split(DICE_SEPARATOR);
        int diceRolls = Integer.parseInt(diceDetails[0]);
        int diceValue = Integer.parseInt(diceDetails[1]);
        
        int sum = 0;
        for (int i = 1; i <= diceRolls; i++) {
            sum += rollDiceValue(diceValue);
        }
        return sum;
    }
    
    private int rollDiceValue(int dice) {
        return diceThrower.rollDice(dice);
    }
    
}
