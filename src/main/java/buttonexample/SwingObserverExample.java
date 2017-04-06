package main.java.buttonexample;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Patrick on 4/5/17.
 */
public class SwingObserverExample {
    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        frame = new JFrame();
        JButton button = new JButton("Should I do it?");
        button.addActionListener(e -> System.out.println("Come on, do it!"));
        button.addActionListener(e -> System.out.println("Don't do it!"));
        frame.getContentPane().add(BorderLayout.CENTER, button);
    }

}
