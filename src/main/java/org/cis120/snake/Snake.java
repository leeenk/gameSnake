package org.cis120.snake;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    private LinkedList<SnakeBlock> body;
    private int px;
    private int py;
    private int vx;
    private int vy;

    public Snake (SnakeBlock initSnake) {
        body = new LinkedList<SnakeBlock>();
        SnakeBlock tailSnake = new SnakeBlock(initSnake.getPx(), initSnake.getPy() + 1, new Color (92, 9, 235));
        body.addLast(initSnake);
        body.addLast(tailSnake);
        this.px = initSnake.getPx();
        this.py = initSnake.getPy();
    }

    public int getSnakeSize() {
        return body.size();
    }

    public LinkedList<SnakeBlock> getSnkBody() {
        return this.body;
    }

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }

    // set vx, vy
    public void setVx(int newVx) {
        vx = newVx;
    }

    public void setVy(int newVy) {
        vy = newVy;
    }

    private void clip() {
        this.px = Math.min(Math.max(this.px, 0), 450);
        this.py = Math.min(Math.max(this.py, 0), 450);
    }


    /**
     * Moves the object by its velocity. Ensures that the object does not go
     * outside its bounds by clipping.
     */
    public void move() {
        this.px += this.vx;
        this.py += this.vy;

        clip();
    }


    /**
     * Determine whether this game object is currently intersecting another
     * object.
     *
     * Intersection is determined by comparing bounding boxes. If the bounding
     * boxes overlap, then an intersection is considered to occur.
     *
     * @param that The other object
     * @return Whether this object intersects the other object.
//     */
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
