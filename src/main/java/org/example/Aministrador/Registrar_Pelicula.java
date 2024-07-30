package org.example.Aministrador;

import javax.swing.*;
import java.awt.event.ComponentAdapter;

public class Registrar_Pelicula {
    public JPanel MainPanel;
    private JTextField campo_codigo;
    private JTextField campo_titulo;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton registrarButton;
    private JButton cancelarButton;
    private JTextField textField2;

    public Registrar_Pelicula() {
        MainPanel.addComponentListener(new ComponentAdapter() {
        });
    }
}
