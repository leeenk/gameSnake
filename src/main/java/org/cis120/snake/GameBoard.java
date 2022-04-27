package org.cis120.snake;

import org.cis120.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

public class GameBoard extends JPanel {

    // 2d array of the block is the game board grid
    private static Block[][] grid;
    private Snake snake = new Snake(new SnakeBlock(170, 170, new Color(219, 20, 235))); // the snake
    private AppleBlock apple= new AppleBlock(170, 200); // the apple that snake feeds on

    // state of the game
    private boolean playing = false; // whether the game is running
    private final JLabel status; // Current status text, i.e. "Running..."

    // Game constants
    public static final int COURT_WIDTH = 450;
    public static final int COURT_HEIGHT = 450;
    public static final int SNAKE_VELOCITY = 1;

    // Update interval for timer, in milliseconds
    public static final int INTERVAL = 35;

    // constructor for GameBoard
    public GameBoard (JLabel status) {

        // 2d array for the game board and the initial location on the 2d array
        grid = new Block[15][15];
        grid[apple.getPx() / 30][apple.getPy() / 30] = apple;
        SnakeBlock head = snake.getSnkBody().peekFirst();
        grid[snake.getPx()][snake.getPy()] = head;


        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Timer timer = new Timer(INTERVAL, e -> tick());
        timer.start();

        setFocusable(true);

        // square should be like snake, movable object
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    snake.setVx(-SNAKE_VELOCITY);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    snake.setVx(SNAKE_VELOCITY);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    snake.setVy(SNAKE_VELOCITY);
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    snake.setVy(-SNAKE_VELOCITY);
                }
            }

            // when key is released, snake should be keep moving forward
            public void keyReleased(KeyEvent e) {
                snake.setVx(30);
                snake.setVy(30);
            }
        });

        this.status = status;
    }


    /**
     * (Re-)set the game to its initial state.
     */
    public void reset() {
        snake = new Snake(new SnakeBlock(170, 170, new Color (219, 20, 235)));
        apple = new AppleBlock(170, 200);

        playing = true;
        status.setText("Running...");

        // Make sure that this component has the keyboard focus
        requestFocusInWindow();
    }

    // put food apple in random places, 15 grid total
    public void putApple() {
        int newX = (int) (Math.random() * 16);
        int newY = (int) (Math.random() * 16);
        apple.setPx(newX);
        apple.setPy(newY);
    }

    /**
     * This method is called every time the timer defined in the constructor
     * triggers.
     */
    void tick() {
        if (playing) {
            // advance the square and snitch in their current direction.
            snake.move();

            // check for the game end conditions:
            // 1. if the snake hit the wall
            // 2. if the snake hit its own body

//            if (snake.hitWall() || snake.intersects(snake)) {
//                playing = false;
//                status.setText("You lose!");
//                // dying motion
//            }

//            // if the snake eats the apple, it gets longer
//            if (snake.intersects(apple)) {
//                // put apple, snake body gets longer
//
//                putApple();
//            }

            // update the display
            repaint();
        }
    }

    // override the extended JPanel class method to tailor to our game court
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color (50, 220, 120));
        g.fillRect(0, 0, 450, 450);
        g.setColor(new Color (6, 138, 52));
        for (int row = 0; row < 450; row += 30) {
            g.drawLine(0, row, 450, row);
            for (int col = 0; col < 450; col += 30) {
                g.drawLine(col, 0, col, 450);
            }
        }
        new SnakeBlock(100, 150, Color.blue).draw(g);
        snake.drawSnake(g);
        // grid[apple.getPx() / 30][apple.getPy() / 30].draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}
