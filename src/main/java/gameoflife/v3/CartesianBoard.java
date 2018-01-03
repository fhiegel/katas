package gameoflife.v3;

import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gameoflife.v3.Cell.ALIVE;
import static gameoflife.v3.Cell.DEAD;

public class CartesianBoard {

    private Map<CartesianPosition, Cell> contentByPosition = new HashMap<>();

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

    public void add(CartesianPosition position, Cell content) {
        contentByPosition.put(position, content);
    }

    public Cell get(CartesianPosition position) {
        return contentByPosition.get(position);
    }

    public Collection<CartesianPosition> position() {
        return contentByPosition.keySet();
    }

    public Collection<CartesianPosition> getNeighbours(CartesianPosition position) {
        return contentByPosition.keySet()
                .stream()
                .filter(position::isNextTo)
                .collect(Collectors.toList());
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
                .map(p -> p.x)
                .max(Integer::compare)
                .orElse(0);
    }

    public int maxY() {
        return contentByPosition.keySet()
                .stream()
                .map(p -> p.y)
                .max(Integer::compare)
                .orElse(0);
    }
}
