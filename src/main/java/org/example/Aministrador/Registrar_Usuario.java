package org.example.Aministrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.MongoClientException;
import com.mongodb.client.*;
import org.bson.Document;
import org.example.Objetos.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Registrar_Usuario {
    //Componentes del JPanel de Registro de Usuarios
    public JPanel MainPanel;
    private JTextField campo_usuario;
    private JPasswordField campo_contrasenia;
    private JTextField campo_apellido;
    private JTextField campo_correo;
    private JTextField campo_telefono;
    private JTextField campo_domicilio;
    private JButton regresarbutton;
    private JButton registrarButton;
    private JButton cancelarButton;
    private JTextField campo_nombre;
    private JTextField campo_cedula;
    private JTextField campo_edad;

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //Variable de conexión a MongoDB Atlas
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    //Se crea un Usuario vacío mediante el objeto
    Usuario usuario = new Usuario();

    public Registrar_Usuario() {
        regresarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane( new Gestion_Usuarios().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(regresarbutton)).dispose();
            }
        });

        //Acción para el botón de registro
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean vacios=false;
                boolean existencia=false;
                //Validar que los campos se encuentren llenos

                if (campo_usuario.getText().equals("")){
                    vacios=true;
                }else {
                    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                        MongoDatabase database = mongoClient.getDatabase("CinePoli");
                        MongoCollection<Document> collection = database.getCollection("Clientes");
                        //Se lee
                        FindIterable<Document> documentos = collection.find();
                        for (Document documento : documentos) {
                            //Busco la existencia del Usuario
                            usuario.setUser(documento.getString("usuario"));

                            if (campo_usuario.getText().equals(usuario.getUser())){
                                JOptionPane.showMessageDialog(null, "Usuario existente, Por Favor Ingrese uno Nuevo", "Aviso", JOptionPane.WARNING_MESSAGE);
                                existencia=true;
                            }
                        }
                    }
                }

                if (campo_contrasenia.getText().equals("")){
                    vacios=true;
                }

                if (campo_nombre.getText().equals("")){
                    vacios=true;
                }

                if (campo_apellido.getText().equals("")){
                    vacios=true;
                }

                if (campo_apellido.getText().equals("")){
                    vacios=true;
                }

                if (campo_cedula.getText().equals("")){
                    vacios=true;
                }else {
                    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                        MongoDatabase database = mongoClient.getDatabase("CinePoli");
                        MongoCollection<Document> collection = database.getCollection("Clientes");
                        //Se lee
                        FindIterable<Document> documentos = collection.find();
                        for (Document documento : documentos) {
                            //Busco la existencia del Usuario
                            usuario.setCedula(documento.getString("cedula"));

                            if (campo_cedula.getText().equals(usuario.getCedula())){
                                JOptionPane.showMessageDialog(null, "La Cédula ingresada ya existe, Por favor Ingrese una Nueva", "Aviso", JOptionPane.WARNING_MESSAGE);
                                existencia=true;
                            }
                        }
                    }
                }

                if (campo_correo.getText().equals("")){
                    vacios=true;
                }else {
                    String email = campo_correo.getText();
                    if (isValidEmail(email)) {
                        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                            MongoDatabase database = mongoClient.getDatabase("CinePoli");
                            MongoCollection<Document> collection = database.getCollection("Clientes");
                            //Se lee
                            FindIterable<Document> documentos = collection.find();
                            for (Document documento : documentos) {
                                //Busco la existencia del Usuario
                                usuario.setCorreo(documento.getString("correo"));
                                if (campo_correo.getText().equals(usuario.getCorreo())){
                                    JOptionPane.showMessageDialog(null, "El Correo Ingresado ya está registrado, Por Favor Ingrese uno Nuevo", "Aviso", JOptionPane.WARNING_MESSAGE);
                                    existencia=true;
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Intoduzca un Correo Válido", "Aviso", JOptionPane.WARNING_MESSAGE);
                        vacios=true;
                    }
                }

                if (campo_telefono.getText().equals("")){
                    vacios=true;
                }

                if (campo_domicilio.getText().equals("")){
                    vacios=true;
                }



                if (!vacios && !existencia){
                    //Se le dan valores al objeto Usuario
                    usuario.setCedula(campo_cedula.getText());
                    usuario.setUser(campo_usuario.getText());
                    //contraseña encriptadad
                    usuario.setPassword(generateHash(campo_contrasenia.getText()));
                    usuario.setNombre(campo_nombre.getText());
                    usuario.setApellido(campo_apellido.getText());
                    usuario.setEdad(Integer.parseInt(campo_edad.getText()));
                    usuario.setCorreo(campo_correo.getText());
                    usuario.setTelefono(campo_telefono.getText());
                    usuario.setDomicilio(campo_domicilio.getText());



                    //Se establece la conexión con la Base de Datos
                    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                        MongoDatabase database = mongoClient.getDatabase("CinePoli");
                        MongoCollection<Document> collection = database.getCollection("Clientes");
                        //Se inserta el nuevo cliente en la base de datos
                        Document documento = new Document("cedula", usuario.getCedula())
                                .append("usuario", usuario.getUser())
                                .append("contraseña", usuario.getPassword())
                                .append("nombre", usuario.getNombre())
                                .append("apellido", usuario.getApellido())
                                .append("edad", usuario.getEdad())
                                .append("categoría", usuario.Calcular_mayoria_edad(usuario.getEdad()))
                                .append("correo", usuario.getCorreo())
                                .append("telefono", usuario.getTelefono())
                                .append("domicilio", usuario.getDomicilio());
                        usuario.Mostrar_usuario();
                        collection.insertOne(documento);
                        JOptionPane.showMessageDialog(null, "Usuario Registrado Con Éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Existen Campos Vacíos o Erroneos. Por favor llenarlos", "Aviso", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
