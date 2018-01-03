package gameoflife.v3;

import gameoflife.v3.*;

import java.util.Random;

public class Runner {

    public static void main(String... arg) {
        CartesianBoard board = initializeBoard(20, 20, 30);
        GameOfLife gameOfLife = new GameOfLife(board);
        CartesianBoardRenderer renderer = new CartesianBoardRenderer();

        String nMinusOneGrid = "";
        String nMinusTwoGrid = "";

        int lifeCycle = 100;
        for (int cycle = 0; cycle <= lifeCycle; cycle++) {
            System.out.println("========================================");
            System.out.println("=== Cycle : " + cycle);
            System.out.println("========================================");

            String nResult = renderer.render(board);
            System.out.println(nResult);


            if (nResult.equals(nMinusOneGrid)) {
                System.out.println("BREAK : n=n-1 " + cycle);
                break;
            }
            if (nResult.equals(nMinusTwoGrid)) {
                System.out.println("BREAK : n=n-2 " + cycle);
                break;
            }

            nMinusTwoGrid = nMinusOneGrid;
            nMinusOneGrid = nResult;

            gameOfLife = gameOfLife.nextGeneration();
            board = gameOfLife.board;
        }

    }

    private static CartesianBoard initializeBoard(int columns, int rows, int lifeProba) {
        Random random = new Random();
        CartesianBoard board = new CartesianBoard(columns, rows);
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                if (random.nextInt(100) < lifeProba) {
                    board.add(CartesianPosition.of(x, y), Cell.ALIVE);
                }
            }
        }
        return board;
    }

}
