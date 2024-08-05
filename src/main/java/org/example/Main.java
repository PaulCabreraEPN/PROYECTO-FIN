package org.example;

import javax.swing.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane( new Login().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        // Obtiene el dispositivo de gráficos
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        if (gd.isFullScreenSupported()) {
            frame.setUndecorated(true); // Quita los bordes y la barra de título
            gd.setFullScreenWindow(frame);
        } else {
            System.err.println("Pantalla completa no es soportada");
            frame.setSize(800, 600); // Tamaño por defecto si pantalla completa no es soportada
            frame.setVisible(true);
        }*/

        frame.setVisible(true);
    }
}




