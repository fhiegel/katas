package gameoflife.v3.hexagonal;

import gameoflife.v3.Board;
import gameoflife.v3.Cell;
import gameoflife.v3.Position;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HexagonalBoard implements Board {

    int radius;
    private Map<Position, Cell> contentByPosition = new HashMap<>();

    public HexagonalBoard(int radius) {
        this.radius = radius;
    }

    public static Board parse(String file) {
        return new HexagonalBoard(0);
    }

    @Override
    public void add(Position position, Cell content) {
        contentByPosition.put(position, content);
    }

    @Override
    public Cell get(Position position) {
        return contentByPosition.get(position);
    }

    @Override
    public Collection<Position> positions() {
        return contentByPosition.keySet();
    }

    @Override
    public Collection<Position> getNeighbours(Position position) {
        return null;
    }

    @Override
    public Board emptyCopy() {
        return new HexagonalBoard(radius);
    }
}
