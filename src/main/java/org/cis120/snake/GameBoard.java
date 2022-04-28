package org.cis120.snake;

import org.cis120.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import java.io.Writer;

public class GameBoard extends JPanel {

   private Block[][] grid = new Block[15][15];

    private SnakeBlock snakeInit = new SnakeBlock(5, 5, new Color(219, 20, 235));
    private Snake snake = new Snake(snakeInit); // the snake
    private AppleBlock apple= new AppleBlock(10, 5); // the apple that snake feeds on

    // state of the game
    private boolean playing = false; // whether the game is running
    private final JLabel status; // Current status text, i.e. "Running..."

    // Game constants
    public static final int COURT_WIDTH = 450;
    public static final int COURT_HEIGHT = 450;

    // Update interval for timer, in milliseconds
    public static final int INTERVAL = 175;

    // constructor for GameBoard
    public GameBoard (JLabel status) {

        fillGrid();
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Timer timer = new Timer(INTERVAL, e -> tick());
        timer.start();

        setFocusable(true);

        // square should be like snake, movable object
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (snake.getDirection() != Direction.LEFT) {
                        snake.setDirection(Direction.LEFT);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (snake.getDirection() != Direction.RIGHT) {
                        snake.setDirection(Direction.RIGHT);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (snake.getDirection() != Direction.DOWN) {
                        snake.setDirection(Direction.DOWN);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (snake.getDirection() != Direction.UP) {
                        snake.setDirection(Direction.UP);
                    }
                }
            }
        });

        this.status = status;
    }

    // helper function for filling the grid
    private void fillGrid() {
        // iterate through the array and fill in the grid
        // 2d array for the game board grid and the initial location on the 2d array
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                grid[row][col] = new SquareBlock(col, row);
            }
        }
        for (SnakeBlock snk : snake.getSnkBody()) {
            if (snk.getPx() < 15 && snk.getPx() >= 0 && snk.getPy() < 15 && snk.getPy() >= 0) {
                grid[snk.getPy()][snk.getPx()] = snk;
            }
        }
        grid[apple.getPy()][apple.getPx()] = apple;
    }

    /**
     * (Re-)set the game to its initial state.
     */
    public void reset() {
        snake = new Snake(new SnakeBlock(5, 5, new Color(219, 20, 235)));
        apple = new AppleBlock(10, 5);

        playing = true;
        status.setText("Running...");

        // Make sure that this component has the keyboard focus
        requestFocusInWindow();
    }

    // pause method
    public void pause() {
        // use buffer writer to take in the text and save
    }

    // resume method
    public void resume() {
        // use buffer reader to pull the text and start the game

    }


    // put food apple in random places, 15 grid total
    public void putApple() {
        int newX = (int) (Math.random() * 15);
        int newY = (int) (Math.random() * 15);
        snake.getHead().getPx();
        snake.getSnkBody().peekLast();
        apple.setPx(newX);
        apple.setPy(newY);
    }

    /**
     * This method is called every time the timer defined in the constructor
     * triggers.
     */
    void tick() {
        if (playing) {
            // advance the snake in their current direction.
            snake.move();
            if (snake.snakeBumpedBlock(apple)) {
                putApple();
                snake.snakeGrow();
                status.setText("Score:" + (snake.getSnakeSize() - 3));
            }

            // clipping so that not out of bound
            SnakeBlock head = snake.getHead();
            if (snake.snakeBumpedSnake() || head.getPx() >= 15 || head.getPx() < 0
                    || head.getPy() >= 15 || head.getPy() < 0) {
                playing = false;
                status.setText("You Lost! \n" + "Score: " + (snake.getSnakeSize() - 3));
                fillGrid();
            }
            repaint();
            fillGrid();
        }
    }

    // override the extended JPanel class method to tailor to our game court
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color (50, 220, 120));
        g.fillRect(0, 0, 450, 450);
        g.setColor(new Color(6, 138, 52));
        for (int row = 0; row < 450; row += 30) {
            g.drawLine(0, row, 450, row);
            for (int col = 0; col < 450; col += 30) {
                g.drawLine(col, 0, col, 450);
            }
        }
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                grid[row][col].draw(g);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}
