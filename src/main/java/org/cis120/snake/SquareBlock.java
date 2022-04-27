
package org.cis120.snake;

import java.awt.*;

// place holder block for the grid
public class SquareBlock extends Block {
    public static final int SIZE = 30;

    public SquareBlock(int px, int py) {
        super(px, py, SIZE, SIZE);
    }

    @Override
    public void draw(Graphics g) {
    }

}