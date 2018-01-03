package gameoflife.v3;

import org.junit.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class CartesianPositionTest {

    @Test
    public void should_get_all_neighbours() {
        CartesianBoard board = new CartesianBoard(4, 4);

        Collection<CartesianPosition> neighbours = board.getNeighbours(CartesianPosition.of(2, 1));

        assertThat(neighbours).containsExactlyInAnyOrder(
                CartesianPosition.of(1, 0),
                CartesianPosition.of(1, 1),
                CartesianPosition.of(1, 2),
                CartesianPosition.of(2, 0),
                CartesianPosition.of(2, 2),
                CartesianPosition.of(3, 0),
                CartesianPosition.of(3, 1),
                CartesianPosition.of(3, 2));
    }

    @Test
    public void should_neighbours_be_next_to_a_position() {
        CartesianPosition starting = CartesianPosition.of(2, 1);

        assertThat(CartesianPosition.of(1, 0).isNextTo(starting)).isTrue();
        assertThat(CartesianPosition.of(1, 1).isNextTo(starting)).isTrue();
        assertThat(CartesianPosition.of(1, 2).isNextTo(starting)).isTrue();
        assertThat(CartesianPosition.of(2, 0).isNextTo(starting)).isTrue();
        assertThat(CartesianPosition.of(2, 2).isNextTo(starting)).isTrue();
        assertThat(CartesianPosition.of(3, 0).isNextTo(starting)).isTrue();
        assertThat(CartesianPosition.of(3, 1).isNextTo(starting)).isTrue();
        assertThat(CartesianPosition.of(3, 2).isNextTo(starting)).isTrue();
    }
}