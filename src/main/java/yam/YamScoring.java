package yam;

import java.util.Arrays;
import java.util.List;

public class YamScoring {
    
    private static final int INVALID_SCORE = 0;
    
    public static int getScore(String strategy, int diceOne, int diceTwo, int diceThree, int diceFour, int diceFive) {
        List<Integer> dices = Arrays.asList(diceOne, diceTwo, diceThree, diceFour, diceFive);
        switch (strategy) {
            case "one":
                return computeSum(dices, 1);
            case "two":
                return computeSum(dices, 2);
            case "three":
                return computeSum(dices, 3);
            case "four":
                return computeSum(dices, 4);
            case "five":
                return computeSum(dices, 5);
            case "six":
                return computeSum(dices, 6);
            case "small_straight":
                boolean dicesMatchesSmallStraight = dices.containsAll(Arrays.asList(1, 2, 3, 4, 5));
                if (dicesMatchesSmallStraight) {
                    return 15;
                }
                return INVALID_SCORE;
            case "yahtzee":
                boolean dicesMatchesYahtzee = dices.stream().allMatch(dice -> dice == dices.get(0));
                if (dicesMatchesYahtzee) {
                    return 50;
                }
                return INVALID_SCORE;
            case "chance":
                int sum = 0;
                for (Integer dice : dices) {
                    sum += dice;
                }
                return sum;
            default:
                break;
        }
        return INVALID_SCORE;
    }
    
    private static int computeSum(List<Integer> dices, int diceValue) {
        int sum = 0;
        for (Integer dice : dices) {
            if (dice == diceValue) {
                sum += diceValue;
            }
        }
        return sum;
    }
    
}