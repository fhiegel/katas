package gameoflife.v3.cartesian;

import gameoflife.v3.Board;
import gameoflife.v3.Cell;
import gameoflife.v3.Position;

import java.util.*;
import java.util.stream.Collectors;

import static gameoflife.v3.Cell.ALIVE;
import static gameoflife.v3.Cell.DEAD;

public class CartesianBoard implements Board {

    private Map<Position, Cell> contentByPosition = new HashMap<>();

    private CartesianBoard() {
    }

    public CartesianBoard(int x, int y) {
        initializeBoard(x, y);
    }

    private void initializeBoard(final int maxX,
                                 final int maxY) {
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                add(CartesianPosition.of(x, y), DEAD);
            }
        }
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
        return contentByPosition.keySet()
                .stream()
                .filter(position::isNextTo)
                .collect(Collectors.toList());
    }

    @Override
    public Board emptyCopy() {
        return new CartesianBoard(maxX(), maxY());
    }

    public static CartesianBoard parse(String input) {
        CartesianBoard board = new CartesianBoard();
        int y = 0;
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();
            for (int x = 0; x < next.length(); x++) {
                board.add(CartesianPosition.of(x, y), 'o' == next.charAt(x) ? ALIVE : DEAD);
            }
            y++;
        }
        return board;
    }

    public int maxX() {
        return contentByPosition.keySet()
                .stream()
                .map(CartesianPosition.class::cast)
                .map(p -> p.x)
                .max(Integer::compare)
                .orElse(0);
    }

    public int maxY() {
        return contentByPosition.keySet()
                .stream()
                .map(CartesianPosition.class::cast)
                .map(p -> p.y)
                .max(Integer::compare)
                .orElse(0);
    }
}
