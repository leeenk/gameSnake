package org.cis120.snake;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

public class Snake {

    private LinkedList<SnakeBlock> body;
    Direction direction = Direction.RIGHT;

    public Snake(SnakeBlock initSnake) {
        body = new LinkedList<>();
        SnakeBlock midSnake = new SnakeBlock(
                initSnake.getPx() - 1, initSnake.getPy(), new Color(61, 52, 235));
        SnakeBlock tailSnake = new SnakeBlock(
                midSnake.getPx() - 1 , midSnake.getPy(), new Color(61, 52, 235));
        body.addLast(initSnake);
        body.addLast(midSnake);
        body.addLast(tailSnake);
    }

    public SnakeBlock getHead() {
        return body.peekFirst();
    }

    public int getSnakeSize() {
        return body.size();
    }

    public LinkedList<SnakeBlock> getSnkBody() {
        return this.body;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public void snakeGrow() {
        SnakeBlock currTail = body.peekLast();
        SnakeBlock newTail = new SnakeBlock(
                currTail.getPx(), currTail.getPy(), new Color(61, 52, 235));
        body.addLast(newTail);
    }

    public boolean snakeBumpedBlock(Block that) {
        return getHead().bumped(that);
    }

    public boolean snakeBumpedSnake() {
        Iterator<SnakeBlock> snkIt = body.iterator();
        SnakeBlock head = snkIt.next();
        while (snkIt.hasNext()) {
            if (snkIt.next().equals(head)) {
                return true;
            }
        }
        return false;
    }

    // clip?

    /**
     * Moves the object by its velocity. Ensures that the object does not go
     * outside its bounds by clipping.
     */
    public void move() {
        SnakeBlock head = getHead();
        SnakeBlock newHead = null;
        if (getDirection() == Direction.LEFT) {
            newHead = new SnakeBlock(head.getPx() - 1, head.getPy(), new Color(219, 20, 235));
        } else if (getDirection() == Direction.RIGHT) {
            newHead = new SnakeBlock(head.getPx() + 1, head.getPy(), new Color(219, 20, 235));
        } else if (getDirection() == Direction.DOWN) {
            newHead = new SnakeBlock(head.getPx(), head.getPy() + 1, new Color(219, 20, 235));
        } else if (getDirection() == Direction.UP) {
            newHead = new SnakeBlock(head.getPx(), head.getPy() - 1, new Color(219, 20, 235));
        }
        //clip();
        body.addFirst(newHead);
        body.removeLast();
    }

    // drawSnake, does not need one since we draw it from the grid
    public void drawSnake(Graphics g) {
        for (SnakeBlock p: body) {
            p.draw(g);
        }
    }

}
