package org.example.Aministrador;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import org.example.Objetos.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class Buscar_Usuario {
    public JPanel MainPanel;
    private JButton porCédulaButton;
    private JButton porUserNameButton;
    private JTextField textbuscar;
    private JLabel Usuario;
    private JLabel texto_cedula;
    private JLabel texto_usuario;
    private JLabel texto_nombre;
    private JLabel texto_categoria;
    private JLabel texto_telefono;
    private JLabel texto_domicilio;
    private JLabel texto_correo;
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    Usuario usuario = new Usuario();

    public Buscar_Usuario() {
        porCédulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                    MongoDatabase database = mongoClient.getDatabase("CinePoli");
                    MongoCollection<Document> collection = database.getCollection("Clientes");
                    //Se lee
                    FindIterable<Document> documentos = collection.find();

                    for (Document documento : documentos) {
                        //System.out.println(documento.toJson());
                        usuario.setCedula(documento.getString("cedula"));
                        usuario.setUser(documento.getString("usuario"));
                        usuario.setNombre(documento.getString("nombre"));
                        usuario.setApellido(documento.getString("apellido"));
                        usuario.setCorreo(documento.getString("correo"));
                        usuario.setTelefono(documento.getString("telefono"));
                        usuario.setDomicilio(documento.getString("domicilio"));
                        String categoria = documento.getString("categoría");


                        if (textbuscar.getText().equals(usuario.getCedula())){
                            texto_cedula.setText(usuario.getCedula());
                            texto_usuario.setText(usuario.getUser());
                            texto_nombre.setText(usuario.getNombre() + " " + usuario.getApellido());
                            texto_categoria.setText(categoria);
                            texto_correo.setText(usuario.getCorreo());
                            texto_telefono.setText(usuario.getTelefono());
                            texto_domicilio.setText(usuario.getDomicilio());
                        }


                    }
                }

            }
        });


        porUserNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                    MongoDatabase database = mongoClient.getDatabase("CinePoli");
                    MongoCollection<Document> collection = database.getCollection("Clientes");
                    //Se lee
                    FindIterable<Document> documentos = collection.find();

                    for (Document documento : documentos) {
                        //System.out.println(documento.toJson());
                        usuario.setCedula(documento.getString("cedula"));
                        usuario.setUser(documento.getString("usuario"));
                        usuario.setNombre(documento.getString("nombre"));
                        usuario.setApellido(documento.getString("apellido"));
                        usuario.setCorreo(documento.getString("correo"));
                        usuario.setTelefono(documento.getString("telefono"));
                        usuario.setDomicilio(documento.getString("domicilio"));
                        String categoria = documento.getString("categoría");


                        if (textbuscar.getText().equals(usuario.getUser())){
                            texto_cedula.setText(usuario.getCedula());
                            texto_usuario.setText(usuario.getUser());
                            texto_nombre.setText(usuario.getNombre() + " " + usuario.getApellido());
                            texto_categoria.setText(categoria);
                            texto_correo.setText(usuario.getCorreo());
                            texto_telefono.setText(usuario.getTelefono());
                            texto_domicilio.setText(usuario.getDomicilio());
                        }


                    }
                }
            }
        });
    }
}
