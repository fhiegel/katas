package zanzibar;

import java.util.Comparator;

public class ZanzibarPlayerByScoreComparator implements Comparator<ZanzibarPlayerTurn> {
    
    @Override
    public int compare(ZanzibarPlayerTurn player1, ZanzibarPlayerTurn player2) {
        ZanzibarDiceRollResult result1 = player1.getDiceResult();
        ZanzibarDiceRollResult result2 = player2.getDiceResult();
        return result1.compareTo(result2);
    }
    
}
