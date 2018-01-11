package gameoflife.v3.hexagonal;

import gameoflife.v3.GameOfLifeTestUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HexagonalBoardTest {

    HexagonalBoardRenderer renderer = new HexagonalBoardRenderer();

    @Test
    public void should_render_an_empty_2r_board() {
        HexagonalBoard board_2r = new HexagonalBoard(2);
        assertBoardEqualsFile(board_2r, "2r_empty");
    }

    @Test
    public void should_render_an_empty_3r_board() {
        HexagonalBoard board_3r = new HexagonalBoard(3);
        assertBoardEqualsFile(board_3r, "3r_empty");
    }

    //
    // Utils
    //

    private void assertBoardEqualsFile(HexagonalBoard board, String fileName) {
        String renderedBoard = renderer.render(board);
        String fileContent = getFile(fileName);
        assertThat(renderedBoard).isEqualTo(fileContent);
    }

    String getFile(String fileName) {
        return GameOfLifeTestUtils.getFile(getClass(), fileName);
    }

}