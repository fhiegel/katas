package gameoflife.v3;

import gameoflife.v3.cartesian.CartesianBoard;
import gameoflife.v3.cartesian.CartesianBoardRenderer;
import gameoflife.v3.cartesian.CartesianPosition;
import gameoflife.v3.hexagonal.HexagonalBoard;
import gameoflife.v3.hexagonal.HexagonalBoardRenderer;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeTest {

    private CartesianBoard board_2x2 = new CartesianBoard(2, 2);
    private CartesianBoard board_3x3 = new CartesianBoard(3, 3);

    @Test
    public void a_cell_with_zero_live_neighbours_dies() {
        GameOfLife generation = new GameOfLife(board_2x2);
        generation.addAliveCellAt(CartesianPosition.of(1, 1));

        generation = generation.nextGeneration();

        Cell cell = generation.getCellAt(CartesianPosition.of(1, 1));
        assertThat(cell.isAlive()).isFalse();
    }

    @Test
    public void an_alive_cell_with_two_live_neighbours_lives() {
        GameOfLife generation = new GameOfLife(board_2x2);
        generation.addAliveCellAt(CartesianPosition.of(1, 1));
        generation.addAliveCellAt(CartesianPosition.of(0, 1));
        generation.addAliveCellAt(CartesianPosition.of(1, 0));

        generation = generation.nextGeneration();

        Cell cell = generation.getCellAt(CartesianPosition.of(1, 1));
        assertThat(cell.isAlive()).isTrue();
    }

    @Test
    public void an_alive_cell_with_four_live_neighbours_dies() {
        GameOfLife generation = new GameOfLife(board_3x3);
        generation.addAliveCellAt(CartesianPosition.of(1, 1));
        generation.addAliveCellAt(CartesianPosition.of(0, 1));
        generation.addAliveCellAt(CartesianPosition.of(1, 0));
        generation.addAliveCellAt(CartesianPosition.of(1, 2));
        generation.addAliveCellAt(CartesianPosition.of(2, 1));

        generation = generation.nextGeneration();

        Cell cell = generation.getCellAt(CartesianPosition.of(1, 1));
        assertThat(cell.isAlive()).isFalse();
    }

    @Test
    public void a_dead_cell_with_three_live_neighbours_becomes_alive() {
        GameOfLife generation = new GameOfLife(board_2x2);
        generation.addAliveCellAt(CartesianPosition.of(1, 1));
        generation.addAliveCellAt(CartesianPosition.of(0, 1));
        generation.addAliveCellAt(CartesianPosition.of(1, 0));

        generation = generation.nextGeneration();

        Cell cell = generation.getCellAt(CartesianPosition.of(0, 0));
        assertThat(cell.isAlive()).isTrue();
    }

    @Test
    public void a_dead_cell_with_two_live_neighbours_stays_dead() {
        GameOfLife generation = new GameOfLife(board_2x2);
        generation.addAliveCellAt(CartesianPosition.of(1, 1));
        generation.addAliveCellAt(CartesianPosition.of(0, 1));

        generation = generation.nextGeneration();

        Cell cell = generation.getCellAt(CartesianPosition.of(0, 0));
        assertThat(cell.isAlive()).isFalse();
    }

    @Test
    public void should_parse_and_compute_cartesian_game_of_life() {
        Board board = parseFromFile("cartesian/10x10_with_cells");
        GameOfLife generation = new GameOfLife(board);

        generation = generation.nextGeneration();

        assertBoardEqualsFile((CartesianBoard) generation.board, "cartesian/10x10_with_cells_n1");
    }

    @Test
    public void should_parse_and_compute_hexagonal_game_of_life() {
        Board board = HexagonalBoard.parse(getFile("hexagonal/10r_with_cells"));
        GameOfLife generation = new GameOfLife(board);

        generation = generation.nextGeneration();
        board = generation.board;

        String renderedBoard = new HexagonalBoardRenderer().render(board);
        assertThat(renderedBoard).isEqualTo(getFile("hexagonal/10r_with_cells_n1"));
    }

    //
    // Utils
    //

    private CartesianBoard parseFromFile(String fileName) {
        return CartesianBoard.parse(getFile(fileName));
    }


    String getFile(String fileName) {
        return GameOfLifeTestUtils.getFile(getClass(), fileName);
    }

    private void assertBoardEqualsFile(CartesianBoard board, String fileName) {
        String renderedBoard = new CartesianBoardRenderer().render(board);
        assertThat(renderedBoard).isEqualTo(getFile(fileName));
    }

}