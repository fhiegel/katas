package gameoflife;

import java.util.Random;

import gameoflife.v1.GameOfLife;

public class GameOfLifeRunner {
    
    public static void main(String... arg) {
        System.out.println("OK");
        GameOfLife gameOfLife = new GameOfLife();
        String cellGrid = generateCellGrid(100, 100, 30);
        
        String nMinusOneGrid = "";
        String nMinusTwoGrid = "";
        
        int lifeCycle = 10000;
        for (int cycle = 0; cycle <= lifeCycle; cycle++) {
            System.out.println("========================================");
            System.out.println("=== Cycle : " + cycle);
            System.out.println("========================================");
            System.out.println(cellGrid);
            cellGrid = gameOfLife.nextGeneration(cellGrid);
            if (cellGrid.equals(nMinusOneGrid)) {
                System.out.println("BREAK : n=n-1 " + cycle);
                break;
            }
            if (cellGrid.equals(nMinusTwoGrid)) {
                System.out.println("BREAK : n=n-2 " + cycle);
                break;
            }
            
            nMinusTwoGrid = nMinusOneGrid;
            nMinusOneGrid = cellGrid;
        }
        
    }
    
    private static String generateCellGrid(int columns, int rows, int lifeProba) {
        Random random = new Random();
        StringBuilder cellGridBuilder = new StringBuilder();
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                if (random.nextInt(100) < lifeProba) {
                    cellGridBuilder.append(GameOfLife.LIVING_CELL);
                } else {
                    cellGridBuilder.append(GameOfLife.DEAD_CELL);
                }
            }
            cellGridBuilder.append(GameOfLife.LINE_END);
        }
        return cellGridBuilder.toString();
    }
    
}
