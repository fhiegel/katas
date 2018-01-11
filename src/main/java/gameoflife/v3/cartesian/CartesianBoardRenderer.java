package gameoflife.v3.cartesian;

import gameoflife.v3.Board;
import gameoflife.v3.Cell;

public class CartesianBoardRenderer {

    public static final String LINE = System.lineSeparator();

    public String render(Board board) {
        CartesianBoard cartesianBoard = (CartesianBoard) board;
        return renderCartesianBoard(cartesianBoard);
    }

    private String renderCartesianBoard(CartesianBoard cartesianBoard) {
        StringBuilder out = new StringBuilder();
        for (int y = 0; y <= cartesianBoard.maxY(); y++) {
            if (y > 0) {
                out.append(LINE);
            }
            for (int x = 0; x <= cartesianBoard.maxX(); x++) {
                Cell cell = cartesianBoard.get(CartesianPosition.of(x, y));
                out.append(renderCell(cell));
            }
        }

        return out.toString();
    }

    private char renderCell(Cell cell) {
        if (cell.isAlive()) {
            return 'o';
        }
        return '.';
    }
}
