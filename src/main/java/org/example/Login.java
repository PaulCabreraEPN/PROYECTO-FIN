package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import org.example.Aministrador.ModuloAdministrador;
import org.example.Objetos.Usuario;
import org.example.Usuario.ModuloUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
    public JPanel MainPanel;
    private JTextField campoUsuario;
    private JPasswordField campoContrasenia;
    private JCheckBox mostrarContraseñaCheckBox;
    private JComboBox campoRol;
    private JButton ingresarButton;
    private JButton cancelarButton;
    private JLabel texto_inicio;
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    Usuario usuario = new Usuario();

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
                boolean usuariorig = true;
                boolean contraseniarig = true;
                if (rol=="Cliente"){

                    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                        MongoDatabase database = mongoClient.getDatabase("CinePoli");
                        MongoCollection<Document> collection = database.getCollection("Clientes");
                        //Se lee
                        FindIterable<Document> documentos = collection.find();

                        for (Document documento : documentos) {
                            //System.out.println(documento.toJson());
                            usuario.setCedula(documento.getString("cedula"));
                            usuario.setUser(documento.getString("usuario"));
                            usuario.setPassword(documento.getString("contraseña"));
                            usuario.setNombre(documento.getString("nombre"));
                            usuario.setApellido(documento.getString("apellido"));
                            usuario.setCorreo(documento.getString("correo"));
                            usuario.setTelefono(documento.getString("telefono"));
                            usuario.setDomicilio(documento.getString("domicilio"));
                            String categoria = documento.getString("categoría");

                            String contr=generateHash(campoContrasenia.getText());

                            if (usuario.getUser().equals(campoUsuario.getText())){
                                usuariorig=false;
                                if (usuario.getPassword().equals(contr)){
                                    contraseniarig=false;
                                    System.out.println("Ingreso como "+rol);
                                    JFrame frame = new JFrame();
                                    ModuloUsuario moduloUsuario=new ModuloUsuario();
                                    moduloUsuario.setUsuario(usuario.getUser());
                                    frame.setContentPane( moduloUsuario.MainPanel);
                                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    frame.setSize(500, 500);
                                    frame.setVisible(true);
                                    ((JFrame)SwingUtilities.getWindowAncestor(ingresarButton)).dispose();
                                }

                            }

                        }
                        if (usuariorig){
                            JOptionPane.showMessageDialog(null, "Usuario inexistente", "Aviso", JOptionPane.WARNING_MESSAGE);
                        }

                        if (contraseniarig){
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Aviso", JOptionPane.WARNING_MESSAGE);
                        }
                    }

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


    public static String generateHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(input.getBytes());
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
