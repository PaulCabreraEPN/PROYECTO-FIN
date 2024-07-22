package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class Login {
    public JPanel MainPanel;
    private JTextField campoUsuario;
    private JPasswordField campoContrasenia;
    private JCheckBox mostrarContraseñaCheckBox;
    private JComboBox campoRol;
    private JButton ingresarButton;
    private JButton cancelarButton;

    public Login() {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoUsuario.setText(null);
                campoContrasenia.setText(null);
                mostrarContraseñaCheckBox.setSelected(false);
            }
        });
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rol= (String) campoRol.getSelectedItem();
                if (rol=="Cliente"){
                    System.out.println("Ingreso como "+rol);
                }else {
                    System.out.println("Ingreso como el "+rol);
                    JFrame frame = new JFrame();
                    frame.setContentPane( new ModuloAdministrador().MainPanel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(500, 500);
                    frame.setVisible(true);
                }
            }
        });
    }
}
