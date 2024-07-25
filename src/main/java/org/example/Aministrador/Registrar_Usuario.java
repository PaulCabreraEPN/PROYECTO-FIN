package org.example.Aministrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.MongoClientException;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.Objetos.Usuario;

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
                //Validar que los campos se encuentren llenos


                //Se le dan valores al objeto Usuario
                usuario.setCedula(campo_cedula.getText());
                usuario.setUser(campo_usuario.getText());
                usuario.setPassword(campo_contrasenia.getText());
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
                    System.out.println("Documento insertado con éxito");
                }
            }
        });
    }
}
