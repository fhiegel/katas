package zanzibar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ZanzibarDiceRollResult implements Comparable<ZanzibarDiceRollResult> {
    
    private static final int ZANZIBAR_SCORE = 8;
    private static final int TRIPLE_ONE_SCORE = 7;
    private static final int SUITE_SCORE = 2;
    private static final int DEFAULT_SCORE = 1;
    
    private List<Integer> rolls;
    private String errorMessage;
    
    public ZanzibarDiceRollResult(int dice1, int dice2, int dice3) {
        this(Arrays.asList(dice1, dice2, dice3));
    }
    
    public ZanzibarDiceRollResult(List<Integer> rolls) {
        this.rolls = rolls;
        Collections.sort(rolls);
    }
    
    
    private Integer getHighestDiceResult() {
        return rolls.get(2);
    }
    
    private Integer getIntermediateDiceResult() {
        return rolls.get(1);
    }
    
    private Integer getLowestDiceResult() {
        return rolls.get(0);
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public int score() {
        if (isZanzibar()) {
            return ZANZIBAR_SCORE;
        }
        if (isTripleOne()) {
            return TRIPLE_ONE_SCORE;
        }
        if (isTriple() || isToAces()) {
            return getHighestDiceResult();
        }
        if (isSuite()) {
            return SUITE_SCORE;
        }
        return DEFAULT_SCORE;
    }
    
    public boolean isZanzibar() {
        return getLowestDiceResult() == 1 && getIntermediateDiceResult() == 2 && getHighestDiceResult() == 4;
    }
    
    public boolean isToAces() {
        return getLowestDiceResult() == 1 && getIntermediateDiceResult() == 1;
    }
    
    public boolean isTripleOne() {
        return getHighestDiceResult() == 1;
    }
    
    public boolean isTriple() {
        return getLowestDiceResult() == getIntermediateDiceResult() && getIntermediateDiceResult() == getHighestDiceResult();
    }
    
    public boolean isSuite() {
        return getLowestDiceResult() + 1 == getIntermediateDiceResult() && getIntermediateDiceResult() + 1 == getHighestDiceResult();
    }
    
    @Override
    public int compareTo(ZanzibarDiceRollResult o) {
        int scoreComparison = score() - o.score();
        if (scoreComparison != 0) {
            return scoreComparison;
        }
        if (isToAces() && o.isTriple()) {
            return -1;
        }
        if (isTriple() && o.isToAces()) {
            return 1;
        }
        return getHighestDiceResult() - o.getHighestDiceResult();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rolls == null) ? 0 : rolls.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ZanzibarDiceRollResult other = (ZanzibarDiceRollResult) obj;
        if (rolls == null) {
            if (other.rolls != null)
                return false;
        } else if (!rolls.equals(other.rolls))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("{");
        sb.append(getHighestDiceResult());
        sb.append(getIntermediateDiceResult());
        sb.append(getLowestDiceResult());
        sb.append("}");
        return sb.toString();
    }
    
    public boolean hasDice(int dice) {
        return rolls.contains(dice);
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
