package org.example.Aministrador;

import org.example.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModuloAdministrador {
    public JPanel MainPanel;
    private JButton clientesButton;
    private JButton peliculasButton;
    private JButton cerrarSesionButton;

    public ModuloAdministrador() {
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane( new Login().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(cerrarSesionButton)).dispose();
            }
        });
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane( new Gestion_Usuarios().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(cerrarSesionButton)).dispose();
            }
        });
        peliculasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane( new Gestionar_Peliculas().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(cerrarSesionButton)).dispose();
            }
        });
    }
}
