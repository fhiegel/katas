package gameoflife.v3.hexagonal;

import gameoflife.v3.GameOfLifeTestUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Flat vs Point
 * https://github.com/cmelchior/asciihexgrid
 */
public class HexagonalBoardRendererTest {

    private int radius = 2;
    private HexagonalBoardRenderer renderer = new HexagonalBoardRenderer();

    @Test
    public void should_an_hexagon_with_radius_of_2_has_a_first_line_2_cells_length_long() {
        int lineIndex = 1;

        int cells = cellsForLine(lineIndex);

        assertThat(cells).isEqualTo(2);
    }

    @Test
    public void should_an_hexagon_with_radius_of_2_has_a_second_line_3_cells_length_long() {
        int lineIndex = 2;

        int cells = cellsForLine(lineIndex);

        assertThat(cells).isEqualTo(3);
    }

    @Test
    public void should_an_hexagon_with_radius_of_2_has_a_third_line_2_cells_length_long() {
        int lineIndex = 3;

        int cells = cellsForLine(lineIndex);

        assertThat(cells).isEqualTo(2);
    }

    @Test
    public void should_an_hexagon_with_radius_of_2_be_rendered_without_separators() {
        givenRendererWithoutSeparators();

        String renderedBoard = renderer.render(aBoard());

        assertEqualsFileContent(renderedBoard, "2r_empty_without_separator");
    }

    @Test
    public void should_an_hexagon_with_radius_of_3_has_a_first_line_3_cells_length_long() {
        givenHexagonHasRadius(3);
        assertThat(cellsForLine(1)).isEqualTo(3);
    }

    @Test
    public void should_an_hexagon_with_radius_of_3_has_a_second_line_4_cells_length_long() {
        givenHexagonHasRadius(3);
        assertThat(cellsForLine(2)).isEqualTo(4);
    }

    @Test
    public void should_an_hexagon_with_radius_of_3_has_a_third_line_5_cells_length_long() {
        givenHexagonHasRadius(3);
        assertThat(cellsForLine(3)).isEqualTo(5);
    }

    @Test
    public void should_an_hexagon_with_radius_of_3_has_a_fourth_line_4_cells_length_long() {
        givenHexagonHasRadius(3);
        assertThat(cellsForLine(4)).isEqualTo(4);
    }

    @Test
    public void should_an_hexagon_with_radius_of_3_be_rendered_without_separators() {
        givenHexagonHasRadius(3);
        givenRendererWithoutSeparators();

        String renderedBoard = renderer.render(aBoard());

        assertEqualsFileContent(renderedBoard, "3r_empty_without_separator");
    }

    @Test
    public void should_print_first_line_for_a_radius_2() {
        String line = renderLine(1);
        assertThat(line).isEqualTo(" . . ");
    }

    @Test
    public void should_print_second_line_for_a_radius_2() {
        String line = renderLine(2);
        assertThat(line).isEqualTo(". . .");
    }

    @Test
    public void should_render_an_empty_2r_board() {
        String renderedBoard = renderer.render(aBoard());

        assertEqualsFileContent(renderedBoard, "2r_empty");
    }

    @Test
    public void should_print_first_line_for_a_radius_3() {
        givenHexagonHasRadius(3);
        String line = renderLine(1);
        assertThat(line).isEqualTo("  . . .  ");
    }

    @Test
    public void should_print_second_line_for_a_radius_3() {
        givenHexagonHasRadius(3);
        String line = renderLine(2);
        assertThat(line).isEqualTo(" . . . . ");
    }

    @Test
    public void should_print_third_line_for_a_radius_3() {
        givenHexagonHasRadius(3);
        String line = renderLine(3);
        assertThat(line).isEqualTo(". . . . .");
    }

    @Test
    public void should_render_a_big_board() {
        String renderedBoard = renderer.render(aBoard(9));

        assertEqualsFileContent(renderedBoard, "9r_empty");
        renderedBoard = renderer.render(aBoard(10));

        assertEqualsFileContent(renderedBoard, "10r_empty");

        renderedBoard = renderer.render(aBoard(100));
        assertEqualsFileContent(renderedBoard, "100r_empty");
    }

    //
    // Utils
    //

    private void givenRendererWithoutSeparators() {
        renderer = renderer.withCellSeparator("").withEndOfLine("").withOffset("");
    }

    private void givenHexagonHasRadius(int radius) {
        this.radius = radius;
    }

    private void assertEqualsFileContent(String actual, String fileName) {
        String fileContent = getFile(fileName);
        assertThat(actual).isEqualTo(fileContent);
    }


    private String renderLine(int lineIndex) {
        return renderer.line(lineIndex, radius);
    }

    private int cellsForLine(int lineIndex) {
        return renderer.cellsPerLine(lineIndex, radius);
    }

    String getFile(String fileName) {
        return GameOfLifeTestUtils.getFile(getClass(), fileName);
    }

    private HexagonalBoard aBoard() {
        return aBoard(radius);
    }

    private HexagonalBoard aBoard(int radius) {
        return new HexagonalBoard(radius);
    }

}