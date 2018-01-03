package gameoflife.v3;

import org.junit.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static gameoflife.v3.CartesianBoardRenderer.LINE;
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
    public void whatever() {
        CartesianBoard board = parseFromFile("10x10_with_cells");
        GameOfLife generation = new GameOfLife(board);

        generation = generation.nextGeneration();

        assertBoardEqualsFile(generation.board, "10x10_with_cells_n1");
    }

    //
    // Utils
    //

    private CartesianBoard parseFromFile(String fileName) {
        return CartesianBoard.parse(getFile(fileName));
    }


    String getFile(String fileName) {
        try {
            URL url = getClass().getResource(fileName);
            Path path = Paths.get(url.toURI());
            return Files.readAllLines(path).stream().collect(Collectors.joining(LINE));
        } catch (Exception e) {
            throw new RuntimeException("Cannot read file" + fileName, e);
        }
    }

    private void assertBoardEqualsFile(CartesianBoard board, String fileName) {
        String renderedBoard = new CartesianBoardRenderer().render(board);
        assertThat(renderedBoard).isEqualTo(getFile(fileName));
    }

}
