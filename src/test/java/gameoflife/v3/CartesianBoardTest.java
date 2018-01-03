package gameoflife.v3;

import org.junit.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static gameoflife.v3.CartesianBoardRenderer.LINE;
import static org.assertj.core.api.Assertions.assertThat;

public class CartesianBoardTest {

    private CartesianBoardRenderer renderer = new CartesianBoardRenderer();

    private CartesianBoard board_2x2 = new CartesianBoard(2, 2);
    private CartesianBoard board_3x3 = new CartesianBoard(3, 3);

    @Test
    public void should_render_an_empty_2x2_board() {
        assertBoardEqualsFile(board_2x2, "2x2");
    }

    @Test
    public void should_render_an_empty_3x3_board() {
        assertBoardEqualsFile(board_3x3, "3x3");
    }

    @Test
    public void rendering_an_alive_cell_at_1_1_in_a_2x2_board() {
        board_2x2.add(CartesianPosition.of(1, 1), Cell.ALIVE);
        assertBoardEqualsFile(board_2x2, "2x2_with_alive_at_1_1");
    }

    @Test
    public void parse_then_render_board() {
        String parsed = getFile("10x10_with_cells");

        CartesianBoard board = CartesianBoard.parse(parsed);

        assertBoardEqualsFile(board, "10x10_with_cells");
    }


    //
    // Utils
    //

    private void assertBoardEqualsFile(CartesianBoard board, String fileName) {
        String renderedBoard = renderer.render(board);
        assertThat(renderedBoard).isEqualTo(getFile(fileName));
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

}