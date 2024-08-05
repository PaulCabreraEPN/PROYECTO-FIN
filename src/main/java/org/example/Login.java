package org.example;

import org.example.Aministrador.ModuloAdministrador;
import org.example.Usuario.ModuloUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public JPanel MainPanel;
    private JTextField campoUsuario;
    private JPasswordField campoContrasenia;
    private JCheckBox mostrarContraseñaCheckBox;
    private JComboBox campoRol;
    private JButton ingresarButton;
    private JButton cancelarButton;
    private JLabel texto_inicio;

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
                    JFrame frame = new JFrame();
                    frame.setContentPane( new ModuloUsuario().MainPanel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(500, 500);
                    frame.setVisible(true);
                    ((JFrame)SwingUtilities.getWindowAncestor(ingresarButton)).dispose();
                }else {
                    System.out.println("Ingreso como el "+rol);
                    JFrame frame = new JFrame();
                    frame.setContentPane( new ModuloAdministrador().MainPanel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(500, 500);
                    frame.setVisible(true);
                    ((JFrame)SwingUtilities.getWindowAncestor(ingresarButton)).dispose();
                }
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
