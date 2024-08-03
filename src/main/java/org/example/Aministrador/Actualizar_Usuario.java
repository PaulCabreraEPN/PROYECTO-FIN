package org.example.Aministrador;

import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.example.Objetos.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actualizar_Usuario {
    public JPanel MainPanel;
    private JButton cedulaButton;
    private JButton userNameButton;
    private JTextField textbuscar;
    private JTextField texto_telefono;
    private JTextField texto_domicilio;
    private JTextField texto_correo;
    private JLabel texto_nombre;
    private JButton actualizarButton;
    private JLabel texto_usuario;
    private JLabel texto_categoria;
    private JButton regresarbutton;
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    Usuario usuario = new Usuario();


    public Actualizar_Usuario() {
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.Mostrar_usuario();
                try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                    MongoDatabase database = mongoClient.getDatabase("CinePoli");
                    MongoCollection<Document> collection = database.getCollection("Peliculas");
                    //Se taen los datos de consulta
                    Document filtro = new Document("usuario", texto_usuario.getText());
                    Document actualizacion = new Document("$set", new Document("telefono", texto_telefono.getText()).append("correo", texto_correo.getText()).append("domicilio", texto_domicilio.getText()));
                    UpdateResult resultado = collection.updateOne(filtro, actualizacion);

                    System.out.println("Documentos modificados: " + resultado.getModifiedCount());


                }
            }
        });

        cedulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean encontrar = false;
                //Se establece la conexión con la Base de Datos
                try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                    MongoDatabase database = mongoClient.getDatabase("CinePoli");
                    MongoCollection<Document> collection = database.getCollection("Clientes");
                    //Se taen los datos de consulta
                    FindIterable<Document> documentos = collection.find();
                    //Se recorren los datos
                    for (Document documento : documentos) {
                        System.out.println(documento.toJson());
                        usuario.setCedula(documento.getString("cedula"));
                        usuario.setUser(documento.getString("usuario"));
                        usuario.setNombre(documento.getString("nombre"));
                        usuario.setApellido(documento.getString("apellido"));
                        usuario.setCorreo(documento.getString("correo"));
                        usuario.setTelefono(documento.getString("telefono"));
                        usuario.setDomicilio(documento.getString("domicilio"));
                        String categoria = documento.getString("categoría");

                        //Retorna unicamente los valores que se buscan
                        if (textbuscar.getText().equals(usuario.getCedula())){
                            texto_usuario.setText(usuario.getUser());
                            texto_nombre.setText(usuario.getNombre() + " " + usuario.getApellido());
                            texto_categoria.setText(categoria);
                            texto_correo.setText(usuario.getCorreo());
                            texto_telefono.setText(usuario.getTelefono());
                            texto_domicilio.setText(usuario.getDomicilio());
                        }
                    }
                    if (encontrar.equals(false)){
                        System.out.println("Usuario Inexistente");
                    }
                }
            }
        });
        userNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean encontrar = false;
                //Se establece la conexión con la Base de Datos
                try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                    MongoDatabase database = mongoClient.getDatabase("CinePoli");
                    MongoCollection<Document> collection = database.getCollection("Clientes");
                    //Se taen los datos de consulta
                    FindIterable<Document> documentos = collection.find();
                    //Se recorren los datos
                    for (Document documento : documentos) {
                        System.out.println(documento.toJson());
                        usuario.setCedula(documento.getString("cedula"));
                        usuario.setUser(documento.getString("usuario"));
                        usuario.setNombre(documento.getString("nombre"));
                        usuario.setApellido(documento.getString("apellido"));
                        usuario.setCorreo(documento.getString("correo"));
                        usuario.setTelefono(documento.getString("telefono"));
                        usuario.setDomicilio(documento.getString("domicilio"));
                        String categoria = documento.getString("categoría");

                        //Retorna unicamente los valores que se buscan
                        if (textbuscar.getText().equals(usuario.getUser())){
                            texto_usuario.setText(usuario.getUser());
                            texto_nombre.setText(usuario.getNombre() + " " + usuario.getApellido());
                            texto_categoria.setText(categoria);
                            texto_correo.setText(usuario.getCorreo());
                            texto_telefono.setText(usuario.getTelefono());
                            texto_domicilio.setText(usuario.getDomicilio());
                        }
                    }
                    if (encontrar.equals(false)){
                        System.out.println("Usuario Inexistente");
                    }
                }
            }
        });
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
    }
}
