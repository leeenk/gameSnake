package org.cis120.snake;

import java.awt.*;


public abstract class Block {

    /*
     * Current position of the object (in terms of graphics coordinates)
     *
     * Coordinates are given by the upper-left hand corner of the object. This
     * position should always be within bounds:
     * 0 <= px <= maxX 0 <= py <= maxY
     */
    private int px;
    private int py;

    /* Size of object, in pixels. */
    private final int width;
    private final int height;

    /**
     * Constructor
     */
    public Block(int px, int py, int width, int height) {
        this.px = px;
        this.py = py;
        this.width = width;
        this.height = height;
    }

    // **********************************************************************************
    // * GETTERS
    // **********************************************************************************
    public int getPx() {
        return this.px;
    }

    public int getPy() {
        return this.py;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getString() {
        return "hello";
    }

    // **************************************************************************
    // * SETTERS
    // **************************************************************************
    public void setPx(int px) {
        this.px = px;
        clip();
    }

    public void setPy(int py) {
        this.py = py;
        clip();
    }

    // **************************************************************************
    // * UPDATES AND OTHER METHODS
    // **************************************************************************

    public boolean equals(Block that) {
        return (that != null && (this.getPx() == that.getPx()) && (this.getPy() == that.getPy()));
    }
    /**
     * Prevents the object from going outside the bounds of the area
     * designated for the object (i.e. Object cannot go outside the active
     * area the user defines for it).
     */
    private void clip() {
        this.px = Math.min(Math.max(this.px, 0), 450);
        this.py = Math.min(Math.max(this.py, 0), 450);
    }

    // method to see if the two block bumped into each other
    public boolean bumped(Block that) {
        if (this == that) {
            return false;
        }
        return (this.getPx() == that.getPx()) && (this.getPy() == that.getPy());
    }

    /**
     * Default draw method that provides how the object should be drawn in the
     * GUI. This method does not draw anything. Subclass should override this
     * method based on how their object should appear.
     *
     * @param g The <code>Graphics</code> context used for drawing the object.
     *          Remember graphics contexts that we used in OCaml, it gives the
     *          context in which the object should be drawn (a canvas, a frame,
     *          etc.)
     */
    public abstract void draw(Graphics g);

}
