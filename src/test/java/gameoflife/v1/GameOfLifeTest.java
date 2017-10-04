package gameoflife.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {
    
    private GameOfLife gameOfLife;
    
    @Before
    public void setUpLife() throws Exception {
        gameOfLife = new GameOfLife();
    }
    
    @Test
    public void _1x1_nextGeneration_should_return_died_cells_when_all_died() throws Exception {
        // Arrange
        String generation = ".\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n");
    }
    
    @Test
    public void _1x1_nextGeneration_should_return_died_cells_when_all_living() throws Exception {
        // Arrange
        String generation = "*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n");
    }
    
    @Test
    public void _2x1_nextGeneration_should_return_died_cells_when_all_died() throws Exception {
        // Arrange
        String generation = "..\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n");
    }
    
    @Test
    public void _2x1_nextGeneration_should_return_died_cells_when_1dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = "*.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n");
    }
    
    @Test
    public void _2x1_nextGeneration_should_return_died_cells_when_2dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = ".*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n");
    }
    
    @Test
    public void _2x1_nextGeneration_should_return_died_cells_when_1to2dot1_cells_are_living() throws Exception {
        // Arrange
        String generation = "**\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n");
    }
    
    @Test
    public void _3x1_nextGeneration_should_return_died_cells_when_all_died() throws Exception {
        // Arrange
        String generation = "...\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("...\n");
    }
    
    @Test
    public void _3x1_nextGeneration_should_return_died_cells_when_1dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = "*..\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("...\n");
    }
    
    @Test
    public void _3x1_nextGeneration_should_return_died_cells_when_2dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = ".*.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("...\n");
    }
    
    @Test
    public void _3x1_nextGeneration_should_return_died_cells_when_3dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = "..*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("...\n");
    }
    
    @Test
    public void _3x1_nextGeneration_should_return_died_cells_when_1to2dot1_cells_are_living() throws Exception {
        // Arrange
        String generation = "**.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("...\n");
    }
    
    @Test
    public void _3x1_nextGeneration_should_return_died_cells_when_2to3dot1_cells_are_living() throws Exception {
        // Arrange
        String generation = ".**\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("...\n");
    }
    
    @Test
    public void _3x1_nextGeneration_should_return_living_cell_at_2dot1_when_1to3dot1_cells_are_living() throws Exception {
        // Arrange
        String generation = "***\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".*.\n");
    }
    
    @Test
    public void _4x1_nextGeneration_should_return_died_cells_when_1dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = "*...\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("....\n");
    }
    
    @Test
    public void _4x1_nextGeneration_should_return_died_cells_when_2dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = ".*..\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("....\n");
    }
    
    @Test
    public void _4x1_nextGeneration_should_return_died_cells_when_3dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = "..*.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("....\n");
    }
    
    @Test
    public void _4x1_nextGeneration_should_return_died_cells_when_4dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = "...*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("....\n");
    }
    
    @Test
    public void _4x1_nextGeneration_should_return_died_cells_when_1to2dot1_cell_are_living() throws Exception {
        // Arrange
        String generation = "**..\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("....\n");
    }
    
    @Test
    public void _4x1_nextGeneration_should_return_died_cells_when_2to3dot1_cell_are_living() throws Exception {
        // Arrange
        String generation = ".**.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("....\n");
    }
    
    @Test
    public void _4x1_nextGeneration_should_return_living_cell_at_2dot1_when_1to3dot1_cell_are_living() throws Exception {
        // Arrange
        String generation = "***.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".*..\n");
    }
    
    @Test
    public void _4x1_nextGeneration_should_return_living_cell_at_3dot1_when_2to4dot1_cell_are_living() throws Exception {
        // Arrange
        String generation = ".***\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..*.\n");
    }
    
    @Test
    public void _4x1_nextGeneration_should_return_living_cell_at_2to3x1_when_1to4dot1_cell_are_living() throws Exception {
        // Arrange
        String generation = "****\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".**.\n");
    }
    
    @Test
    public void _1x2_nextGeneration_should_return_died_cells_when_all_died() throws Exception {
        // Arrange
        String generation = ".\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n");
    }
    
    @Test
    public void _1x2_nextGeneration_should_return_died_cells_when_1dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = "*\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n");
    }
    
    @Test
    public void _1x2_nextGeneration_should_return_died_cells_when_2dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = ".\n*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n");
    }
    
    @Test
    public void _1x2_nextGeneration_should_return_died_cells_when_1to2dot1_cells_are_living() throws Exception {
        // Arrange
        String generation = "*\n*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n");
    }
    
    @Test
    public void _1x3_nextGeneration_should_return_died_cells_when_all_died() throws Exception {
        // Arrange
        String generation = ".\n.\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n");
    }
    
    @Test
    public void _1x3_nextGeneration_should_return_died_cells_when_1dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = "*\n.\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n");
    }
    
    @Test
    public void _1x3_nextGeneration_should_return_died_cells_when_2dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = ".\n*\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n");
    }
    
    @Test
    public void _1x3_nextGeneration_should_return_died_cells_when_3dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = ".\n.\n*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n");
    }
    
    @Test
    public void _1x3_nextGeneration_should_return_died_cells_when_1to2dot1_cells_are_living() throws Exception {
        // Arrange
        String generation = "*\n*\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n");
    }
    
    @Test
    public void _1x3_nextGeneration_should_return_died_cells_when_2to3dot1_cells_are_living() throws Exception {
        // Arrange
        String generation = ".\n*\n*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n");
    }
    
    @Test
    public void _1x3_nextGeneration_should_return_living_cell_at_2dot1_when_1to3dot1_cells_are_living() throws Exception {
        // Arrange
        String generation = "*\n*\n*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n*\n.\n");
    }
    
    @Test
    public void _1x4_nextGeneration_should_return_died_cells_when_1dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = "*\n.\n.\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n.\n");
    }
    
    @Test
    public void _1x4_nextGeneration_should_return_died_cells_when_2dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = ".\n*\n.\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n.\n");
    }
    
    @Test
    public void _1x4_nextGeneration_should_return_died_cells_when_3dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = ".\n.\n*\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n.\n");
    }
    
    @Test
    public void _1x4_nextGeneration_should_return_died_cells_when_4dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = ".\n.\n.\n*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n.\n");
    }
    
    @Test
    public void _1x4_nextGeneration_should_return_died_cells_when_1to2dot1_cell_are_living() throws Exception {
        // Arrange
        String generation = "*\n*\n.\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n.\n");
    }
    
    @Test
    public void _1x4_nextGeneration_should_return_died_cells_when_2to3dot1_cell_are_living() throws Exception {
        // Arrange
        String generation = ".\n*\n*\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n.\n.\n");
    }
    
    @Test
    public void _1x4_nextGeneration_should_return_living_cell_at_2dot1_when_1to3dot1_cell_are_living() throws Exception {
        // Arrange
        String generation = "*\n*\n*\n.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n*\n.\n.\n");
    }
    
    @Test
    public void _1x4_nextGeneration_should_return_living_cell_at_3dot1_when_2to4dot1_cell_are_living() throws Exception {
        // Arrange
        String generation = ".\n*\n*\n*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n.\n*\n.\n");
    }
    
    @Test
    public void _1x4_nextGeneration_should_return_living_cell_at_2to3x1_when_1to4dot1_cell_are_living() throws Exception {
        // Arrange
        String generation = "*\n*\n*\n*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo(".\n*\n*\n.\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_died_cells_when_all_dead() throws Exception {
        // Arrange
        String generation = "..\n..\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n..\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_died_cells_when_1dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = "*.\n..\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n..\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_died_cells_when_1dot2_cell_is_living() throws Exception {
        // Arrange
        String generation = ".*\n..\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n..\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_died_cells_when_2dot1_cell_is_living() throws Exception {
        // Arrange
        String generation = "..\n*.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n..\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_died_cells_when_2dot2_cell_is_living() throws Exception {
        // Arrange
        String generation = "..\n.*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n..\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_died_cells_when_1to2dot1_cell_are_living() throws Exception {
        // Arrange
        String generation = "**\n..\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n..\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_died_cells_when_1to2dot2_cell_are_living() throws Exception {
        // Arrange
        String generation = "..\n**\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n..\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_died_cells_when_1dot1to2_cell_are_living() throws Exception {
        // Arrange
        String generation = "*.\n*.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n..\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_died_cells_when_1dot1_and_2dot2_cells_are_living() throws Exception {
        // Arrange
        String generation = "*.\n.*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n..\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_died_cells_when_1dot2_and_2dot1_cells_are_living() throws Exception {
        // Arrange
        String generation = ".*\n*.\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("..\n..\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_all_living_cells_when_all_cells_are_living() throws Exception {
        // Arrange
        String generation = "**\n**\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("**\n**\n");
    }
    
    @Test
    public void _2x2_nextGeneration_should_return_all_living_cells_when_all_but_one_cells_are_living() throws Exception {
        // Arrange
        String generation = "**\n.*\n";
        
        // Act
        String nextGeneration = gameOfLife.nextGeneration(generation);
        
        // Assert
        assertThat(nextGeneration).isEqualTo("**\n**\n");
    }
    
}
