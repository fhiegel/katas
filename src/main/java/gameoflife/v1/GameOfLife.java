package gameoflife.v1;

/**
 * <ol>
 * <li>1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
 * <li>2. Any live cell with more than three live neighbours dies, as if by overcrowding.
 * <li>3. Any live cell with two or three live neighbours lives on to the next generation.
 * <li>4. Any dead cell with exactly three live neighbours becomes a live cell.
 * </ol>
 */
public class GameOfLife {
    
    public static final String LINE_END = "\n";
    public static final Character DEAD_CELL = '.';
    public static final Character LIVING_CELL = '*';
    
    public String nextGeneration(String cellGridInput) {
        StringBuilder cellGridBuilder = new StringBuilder();
        CellGrid cellGrid = parseCellGrid(cellGridInput);
        
        for (int y = 0; y < cellGrid.rows; y++) {
            for (int x = 0; x < cellGrid.columns; x++) {
                char cell = nextGenerationCell(cellGrid, x, y);
                cellGridBuilder.append(cell);
            }
            cellGridBuilder.append(LINE_END);
        }
        
        return cellGridBuilder.toString();
    }
    
    private CellGrid parseCellGrid(String cellGridInput) {
        return new CellGrid(cellGridInput);
    }
    
    private char nextGenerationCell(CellGrid cellGrid, int x, int y) {
        int nearLivingCellCount = countNearLivingCells(cellGrid, x, y);
        if (nearLivingCellCount == 3) {
            return LIVING_CELL;
        }
        Character actualCell = cellGrid.getCellAt(x, y);
        if (nearLivingCellCount == 2) {
            return actualCell;
        }
        return DEAD_CELL;
    }

    private int countNearLivingCells(CellGrid cellGrid, int x, int y) {
        int nearLivingCellCount = 0;
        for (int xx = -1; xx <= 1; xx++) {
            for (int yy = -1; yy <= 1; yy++) {
                if (xx == 0 && yy == 0) {
                    continue;
                }
                int nearX = x + xx;
                int nearY = y + yy;
                if (LIVING_CELL.equals(cellGrid.getCellAt(nearX, nearY))) {
                    nearLivingCellCount++;
                }
            }
        }
        return nearLivingCellCount;
    }
    
    private static class CellGrid {
        
        String[] grid;
        private int rows;
        private int columns;
        
        public CellGrid(String cellGridInput) {
            grid = cellGridInput.split(LINE_END);
            rows = grid.length;
            columns = grid[0].length();
        }
        
        public Character getCellAt(int x, int y) {
            if (x < 0 || y < 0) {
                return DEAD_CELL;
            }
            if (x >= columns || y >= rows) {
                return DEAD_CELL;
            }
            return grid[y].charAt(x);
        }
        
    }
    
}
