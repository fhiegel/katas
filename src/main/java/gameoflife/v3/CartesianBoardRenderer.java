package gameoflife.v3;

public class CartesianBoardRenderer {

    public static final String LINE = System.lineSeparator();

    public String render(CartesianBoard board) {
        StringBuilder out = new StringBuilder();

        for (int y = 0; y <= board.maxY(); y++) {
            if (y > 0) {
                out.append(LINE);
            }
            for (int x = 0; x <= board.maxX(); x++) {
                Cell cell = board.get(CartesianPosition.of(x, y));
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
