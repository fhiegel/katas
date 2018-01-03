package gameoflife.v3;

import java.util.Collection;

public class Cell {
    public static Cell DEAD = new Cell(false);
    public static Cell ALIVE = new Cell(true);
    private final boolean alive;

    private Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public Cell nextGeneration(Collection<Cell> neighbours) {
        long nextAliveCells = neighbours.stream()
                .filter(Cell::isAlive)
                .count();

        if (nextAliveCells == 2 && isAlive()) {
            return ALIVE;
        }
        if (nextAliveCells == 3) {
            return ALIVE;
        }
        return DEAD;
    }

    @Override
    public String toString() {
        return "Cell{" +
                (alive
                        ? "alive"
                        : "dead")
                + '}';
    }
}
