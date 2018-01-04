package gameoflife.v3;


import gameoflife.v3.cartesian.CartesianPosition;

import java.util.Collection;
import java.util.stream.Collectors;

public class GameOfLife {

    final Board board;

    public GameOfLife(Board board) {
        this.board = board;
    }

    public void addAliveCellAt(CartesianPosition position) {
        board.add(position, Cell.ALIVE);
    }

    public Cell getCellAt(CartesianPosition position) {
        return board.get(position);
    }

    public GameOfLife nextGeneration() {
        Board newBoard = board.emptyCopy();

        for (Position position : board.position()) {
            Cell cell = nextGenerationCell(position);
            newBoard.add(position, cell);
        }

        return new GameOfLife(newBoard);
    }

    private Cell nextGenerationCell(Position position) {
        Cell cell = board.get(position);
        Collection<Cell> neighbours = board.getNeighbours(position)
                .stream()
                .map(board::get)
                .collect(Collectors.toList());
        return cell.nextGeneration(neighbours);
    }
}
