package dog.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        char[] key = {' '};

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Cube.composeCube(key[0]);
                } catch (InterruptedException | AWTException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

        JFrame frame = new JFrame();
        JLabel label = new JLabel("Press a key:");
        frame.add(label);
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                key[0] = e.getKeyChar();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                key[0] = ' ';
                // Not used, but required by KeyListener interface
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not used, but required by KeyListener interface
            }
        });
    }
}