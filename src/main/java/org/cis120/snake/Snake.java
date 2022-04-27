package org.cis120.snake;

import java.awt.*;
import java.util.LinkedList;

public class Snake {

    private LinkedList<SnakeBlock> body;
    Direction direction;

    public Snake (SnakeBlock initSnake) {
        body = new LinkedList<>();
        SnakeBlock midSnake = new SnakeBlock(
                initSnake.getPx() - 1, initSnake.getPy(), new Color(61, 52, 235));
        SnakeBlock tailSnake = new SnakeBlock(
                midSnake.getPx() -1 , midSnake.getPy(), new Color(61, 52, 235));
        body.addLast(initSnake);
        body.addLast(midSnake);
        body.addLast(tailSnake);
    }

    public int getSnakeSize() {
        return body.size();
    }

    public LinkedList<SnakeBlock> getSnkBody() {
        return this.body;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public void snakeGrow() {
        SnakeBlock currTail = body.peekLast();
        SnakeBlock newTail = new SnakeBlock(currTail.getPx(), currTail.getPy(), new Color(61, 52, 235));
        body.addLast(newTail);
    }

    // clip?

    /**
     * Moves the object by its velocity. Ensures that the object does not go
     * outside its bounds by clipping.
     */
    public void move() {
        SnakeBlock head = this.body.peekFirst();
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


//    /**
//     * Determine whether this game object is currently intersecting another
//     * object.
//     *
//     * Intersection is determined by comparing bounding boxes. If the bounding
//     * boxes overlap, then an intersection is considered to occur.
//     *
//     * @param that The other object
//     * @return Whether this object intersects the other object.
////     */
//    public boolean collides(Block that) {
//        // if snake head (snake block) intersects with other (bloc)
//    }
//
//    /**
//     * Determine whether the game object will hit a wall in the next time step.
//     * If so, return the direction of the wall in relation to this game object.
//     *
//     * @return Direction of impending wall, null if all clear.
//     */
//    public boolean hitWall() {
//        if (this.px + this.vx < 0) {
//            return Direction.LEFT;
//        } else if (this.px + this.vx > 450) {
//            return Direction.RIGHT;
//        }
//
//        if (this.py + this.vy < 0) {
//            return Direction.UP;
//        } else if (this.py + this.vy > 450) {
//            return Direction.DOWN;
//        } else {
//            return null;
//        }
//    }


    // drawSnake
    public void drawSnake (Graphics g) {
        for(SnakeBlock p: body) {
            p.draw(g);
        }
    }


}
