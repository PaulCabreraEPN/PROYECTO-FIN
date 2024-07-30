package org.example.Aministrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gestionar_Peliculas {
    public JPanel MainPanel;
    private JButton button1;
    private JButton registrarButton;
    private JButton actualizarButton;
    private JButton buscarButton;
    private JButton eliminarButton;

    public Gestionar_Peliculas() {
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane( new Registrar_Pelicula().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(registrarButton)).dispose();
            }
        });
    }
}
