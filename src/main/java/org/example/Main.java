package org.example;

import javax.swing.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane( new Login().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);


    }
}




