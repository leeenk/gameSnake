package org.cis120.snake;

import org.junit.jupiter.api.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {


    @Test
    public void test(){
        assertNotEquals("CIS 120", "CIS 160");
    }

    SnakeBlock head = new SnakeBlock(3, 3, Color.GREEN);
    private Snake snake = new Snake(head);

    @Test
    public void testHead() {
        assertEquals(head, snake.getHead());
    }


    @Test
    public void gettersWork() {
        assertEquals(200, snake.getHead().getPx());
        assertEquals(200, snake.getHead().getPy());
    }

    @Test
    public void settersWork() {
        snake.getHead().setPx(3);
        assertEquals(300, snake.getHead().getPx());
    }
}
