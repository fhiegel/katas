package gameoflife.v3;

import java.util.Collection;

public interface Board {

    void add(Position position, Cell content);

    Cell get(Position position);

    Collection<Position> positions();

    Collection<Position> getNeighbours(Position position);

    Board emptyCopy();
}