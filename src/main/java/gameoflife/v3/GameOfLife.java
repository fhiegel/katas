package gameoflife.v3;


import java.util.Collection;
import java.util.stream.Collectors;

public class GameOfLife {

    final CartesianBoard board;

    public GameOfLife(CartesianBoard board) {
        this.board = board;
    }

    public void addAliveCellAt(CartesianPosition position) {
        board.add(position, Cell.ALIVE);
    }

    public Cell getCellAt(CartesianPosition position) {
        return board.get(position);
    }

    public GameOfLife nextGeneration() {
        CartesianBoard newBoard = new CartesianBoard(board.maxX(), board.maxY());

        for (CartesianPosition position : board.position()) {
            Cell cell = nextGenerationCell(position);
            newBoard.add(position, cell);
        }

        return new GameOfLife(newBoard);
    }

    private Cell nextGenerationCell(CartesianPosition position) {
        Cell cell = board.get(position);
        Collection<Cell> neighbours = board.getNeighbours(position)
                .stream()
                .map(board::get)
                .collect(Collectors.toList());
        return cell.nextGeneration(neighbours);
    }
}
