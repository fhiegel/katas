package gameoflife.v3.hexagonal;

import gameoflife.v3.Board;

public class HexagonalBoardRenderer {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private static final String EOL = "|";
    private static final String CELL_SEPARATOR = " ";
    private static final String EMPTY_CELL = ".";

    private String offset = CELL_SEPARATOR;
    private String cellSeparator = CELL_SEPARATOR;
    private String endOfLine = EOL;

    public String render(Board board) {
        HexagonalBoard hexagonalBoard = (HexagonalBoard) board;
        return render(hexagonalBoard);
    }

    private String render(HexagonalBoard hexagonalBoard) {
        StringBuilder out = new StringBuilder();

        for (int line = 1; line <= linesCount(hexagonalBoard.radius); line++) {
            if (line > 1) {
                out.append(LINE_SEPARATOR);
            }
            out.append(line(line, hexagonalBoard.radius)).append(endOfLine);
        }
        return out.toString();
    }

    String line(int line, int radius) {
        StringBuilder out = new StringBuilder();

        appendLineOffset(out, line, radius);
        appendLineCells(out, line, radius);
        appendLineOffset(out, line, radius);

        return out.toString();
    }

    private void appendLineCells(StringBuilder out, int line, int radius) {
        for (int cellIndex = 1; cellIndex <= cellsPerLine(line, radius); cellIndex++) {
            if (cellIndex > 1) {
                out.append(cellSeparator);
            }
            out.append(EMPTY_CELL);
        }
    }

    private void appendLineOffset(StringBuilder out, int line, int radius) {
        if ((isEven(line) && isOdd(radius))
                || (isOdd(line) && isEven(radius))) {
            out.append(offset);
        }
        int offsetLimit = (linesCount(radius) - cellsPerLine(line, radius)) / 2;
        for (int offsetIndex = 0; offsetIndex < offsetLimit; offsetIndex++) {
            out.append(cellSeparator);
            out.append(offset);
        }
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    private boolean isOdd(int i) {
        return i % 2 != 0;
    }

    private int linesCount(int radius) {
        return 2 * radius - 1;
    }

    private String cell() {
        return EMPTY_CELL;
    }

    int cellsPerLine(int line, int radius) {
        return (line <= radius)
                ? (linesCount(radius) - radius + line)
                : (linesCount(radius) + radius - line);

    }

    public HexagonalBoardRenderer withCellSeparator(String cellSeparator) {
        this.cellSeparator = cellSeparator;
        return this;
    }

    public HexagonalBoardRenderer withEndOfLine(String endOfLine) {
        this.endOfLine = endOfLine;
        return this;
    }

    public HexagonalBoardRenderer withOffset(String offset) {
        this.offset = offset;
        return this;
    }
}
