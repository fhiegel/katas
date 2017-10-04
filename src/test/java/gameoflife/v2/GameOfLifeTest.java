package gameoflife.v2;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameOfLifeTest {
    
    private static final String EMPTY_2x2_GRID = "" //
            + ".." + "\n" //
            + ".." + "\n";
    
    private GameOfLife life = new GameOfLife();
    
    @Test
    public void should_nextGen_returns_empty_grid_when_empty_grid_given() throws Exception {
        // When
        String nextGeneration = life.nextGen(EMPTY_2x2_GRID);
        
        // Then
        assertThat(nextGeneration).isEqualTo(EMPTY_2x2_GRID);
    }
    
    @Test
    public void should_nextGen_returns_empty_grid_when_grid__with_one_cell_given() throws Exception {
        // Given
        String grid = "" //
                + ".*\n" //
                + "..\n";
        // When
        String nextGeneration = life.nextGen(grid);
        
        // Then
        assertThat(nextGeneration).isEqualTo(EMPTY_2x2_GRID);
    }
    
    @Test
    public void should_nextGen_returns_full_grid_when_given_a_grid_with_enough_living_cells() throws Exception {
        // Given
        String grid = "" //
                + ".*\n" //
                + "**\n";
        // When
        String nextGeneration = life.nextGen(grid);
        
        // Then
        assertThat(nextGeneration).isEqualTo("**\n**\n");
    }
    
}
