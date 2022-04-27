package org.cis120.snake;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Color.red;

public class AppleBlock extends Block{
    public static final String IMG_FILE = "files/apple.png";
    public static final int SIZE = 33;
    private static BufferedImage img;


    /**
     * Note that, because we don't need to do anything special when constructing
     * a Square, we simply use the superclass constructor called with the
     * correct parameters.
     */
    public AppleBlock(int px, int py) {
        super(px, py, SIZE, SIZE);

        // load image file
        try {
            if (img == null) {
                img = ImageIO.read(new File(IMG_FILE));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, this.getPx() * 30, this.getPy() * 30, this.getWidth(), this.getHeight(), null);
    }
}
