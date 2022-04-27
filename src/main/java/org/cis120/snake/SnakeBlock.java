package org.cis120.snake;

import java.awt.*;

public class SnakeBlock extends Block {
    public static int SIZE = 30;
    private Color color;

    /**
     * Note that, because we don't need to do anything special when constructing
     * a Square, we simply use the superclass constructor called with the
     * correct parameters.
     */
    public SnakeBlock(int px, int py, Color color) {
        super(px, py, SIZE, SIZE);
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(this.getPx() * 30, this.getPy() * 30, this.getWidth(), this.getHeight());
    }
}
