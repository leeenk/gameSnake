package org.cis120.snake;

// imports necessary libraries for Java swing

import javax.swing.*;
import java.awt.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class RunSnake implements Runnable {
    public void run() {
        // NOTE : recall that the 'final' keyword notes immutability even for
        // local variables.

        // Top-level frame in which game components live.
        // Be sure to change "TOP LEVEL FRAME" to the name of your game
        final JFrame frame = new JFrame("Snake");
        frame.setLocation(300, 300);

        // Status panel at the bottom (south)
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel status = new JLabel("Running...");
        status_panel.add(status);

        // Main playing area
        final GameBoard board = new GameBoard(status);
        frame.add(board, BorderLayout.CENTER);

        // Reset button
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);

        // Note here that when we add an action listener to the reset button, we
        // define it as an anonymous inner class that is an instance of
        // ActionListener with its actionPerformed() method overridden. When the
        // button is pressed, actionPerformed() will be called.
        final JButton reset = new JButton("Reset");
        // lamda expression : go to game court and call reset
        reset.addActionListener(e -> board.reset());
        control_panel.add(reset);

        final JButton pause = new JButton("Pause");
        pause.addActionListener(e -> board.pause());
        control_panel.add(pause);

        final JButton resume = new JButton("Resume");
        resume.addActionListener(e -> board.resume());
        control_panel.add(resume);



        // instruction display
        String instruction = "Instruction for Snake: \n" + "1. Use the keyboard arrow for up, down, left, right. \n"
                + "2. The more you eat the apples, the loner your body will be. \n"
                + "3. If you hit the wall or your own body, you will die. \n";
        JOptionPane.showMessageDialog(frame, instruction, "Snake Instruction", JOptionPane.OK_OPTION);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start game
        board.reset();
    }
}