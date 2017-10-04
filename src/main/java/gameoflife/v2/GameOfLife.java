package gameoflife.v2;

import java.util.ArrayList;
import java.util.Collection;

public class GameOfLife {
    
    public String nextGen(String generationGrid) {
        GameGrid gameGrid = parseGrid(generationGrid);
        gameGrid = gameGrid.nextGen();
        return gameGrid.toString();
    }
    
    private GameGrid parseGrid(String generationGrid) {
        String[] lines = generationGrid.split("\n");
        GameGrid gameGrid = new GameGrid(lines.length, lines[0].length());
        for (int y = 0; y < gameGrid.ymax; y++) {
            for (int x = 0; x < gameGrid.xmax; x++) {
                Cell cell = new Cell(x, y, lines[y].charAt(x));
                gameGrid.addCell(cell);
            }
        }
        return gameGrid;
    }
    
    class GameGrid {
        int xmax;
        int ymax;
        Cell[][] grid;
        Collection<Cell> cells = new ArrayList<>();
        
        public GameGrid(int xmax, int ymax) {
            this.xmax = xmax;
            this.ymax = ymax;
            this.grid = new Cell[ymax][xmax];
        }
        
        private void addCell(Cell cell) {
            grid[cell.y][cell.x] = cell;
            cells.add(cell);
        }
        
        private GameGrid nextGen() {
            for (Cell cell : cells) {
                updateCell(cell);
            }
            return this;
        }
        
        private void updateCell(Cell cell) {
            
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (int y = 0; y < ymax; y++) {
                for (int x = 0; x < xmax; x++) {
                    result.append(grid[y][x].state);
                }
                result.append("\n");
            }
            return result.toString();
        }
    }
    
    class Cell {
        int x;
        int y;
        Character state;
        
        public Cell(int x, int y, char state) {
            this.x = x;
            this.y = y;
            this.state = state;
        }
    }
    
}
