package gameoflife.v3.cartesian;

import gameoflife.v3.Position;

import java.util.Objects;

public class CartesianPosition implements Position {
    final int x;
    final int y;

    private CartesianPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isNextTo(Position position) {
        CartesianPosition cartesian = (CartesianPosition) position;
        return !equals(cartesian)
                && (x >= cartesian.x - 1)
                && (x <= cartesian.x + 1)
                && (y >= cartesian.y - 1)
                && (y <= cartesian.y + 1);
    }

    public static CartesianPosition of(int x, int y) {
        return new CartesianPosition(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartesianPosition that = (CartesianPosition) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "CartesianPosition{" + "x=" + x + ", y=" + y + '}';
    }
}
