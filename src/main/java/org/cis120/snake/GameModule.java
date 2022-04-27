//package org.cis120.snake;
//
//import java.awt.*;
//
///*assembly of game components,
//    2D array for the structure
//     */
//public class GameModule {
//    // 2d array of the block is the game board
//    private final Block[][] board;
//
//    // the state of the game logic
//    public Snake snake;
//    public AppleBlock apple;
//
//    public GameModule(Snake snake, AppleBlock apple) {
//        board = new Block[15][15];
//        // initialize the board
//        // for each grid, set the color green and light green
//        for (int row = 0; row < 15; row++) {
//            for (int col = 0; col < 15; col++) {
//                if (row % 2 == 0 && col % 2 == 0) {
//                    board[row][col] =
//                            new SquareBlock(col, row, new Color (9, 235, 88));
//
//                } else if (row % 2 != 0 && col % 2 == 0) {
//                    board[row][col] =
//                            new SquareBlock(col, row, new Color (9, 235, 88));
//                } else {
//                    board[row][col] =
//                            new SquareBlock(col, row, new Color (6, 138, 52));
//                }
//            }
//        }
//
//        this.snake = snake;
//        this.apple = apple;
//
//    }
//
//    // getter for the game board
//    public Block[][] getBoard() {
//        return this.board;
//    }
//
//    public void draw(Graphics g) {
//
//        for (int row = 0; row < 15; row++) {
//            for (int col = 0; col < 15; col++) {
//                g.drawLine(col, row, 15 - col, 15 - row);
//            }
//        }
//    }
//}
