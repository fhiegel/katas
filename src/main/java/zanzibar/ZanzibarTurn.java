package zanzibar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZanzibarTurn {
    
    private Map<String, ZanzibarPlayerTurn> playersByName = new HashMap<>();
    private Comparator<ZanzibarPlayerTurn> orderPlayerByScore = new ZanzibarPlayerByScoreComparator();
    private ZanzibarGame zanzibarGame;
    
    public ZanzibarTurn(ZanzibarGame zanzibarGame) {
        this.zanzibarGame = zanzibarGame;
    }
    
    public ZanzibarPlayerTurn player(String player) {
        ZanzibarPlayerTurn playerTurn = new ZanzibarPlayerTurn(zanzibarGame, player);
        playersByName.put(player, playerTurn);
        return playerTurn;
    }
    
    public ZanzibarPlayerTurn getWinner() {
        List<ZanzibarPlayerTurn> players = new ArrayList<>(playersByName.values());
        Collections.sort(players, orderPlayerByScore);
        return players.get(players.size() - 1);
    }
    
}
