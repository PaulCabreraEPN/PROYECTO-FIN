package org.example.Aministrador;

import com.mongodb.client.*;
import org.bson.Document;
import org.example.Objetos.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import com.mongodb.client.result.DeleteResult;

public class Eliminar_Usuario {
    public JPanel MainPanel;
    private JTextField textbuscar;
    private JButton verButton;
    private JLabel info;
    private JButton eliminarButton;
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    Usuario usuario = new Usuario();
    Boolean encontrar = false;

    public Eliminar_Usuario() {
        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encontrar = false;
                info.setText(null);
                //Se establece la conexión con la Base de Datos
                try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                    MongoDatabase database = mongoClient.getDatabase("CinePoli");
                    MongoCollection<Document> collection = database.getCollection("Clientes");
                    //Se taen los datos de consulta
                    FindIterable<Document> documentos = collection.find();
                    //Se recorren los datos
                    for (Document documento : documentos) {

                        usuario.setCedula(documento.getString("cedula"));
                        usuario.setUser(documento.getString("usuario"));

                        //Retorna unicamente los valores que se buscan
                        if (textbuscar.getText().equals(usuario.getUser())){
                            encontrar=true;
                            info.setText("Usuario encontrado");
                        }
                    }

                }

                if (encontrar.equals(false)){
                    info.setText("Usuario NO encontrado");
                }

            }
        });
        MainPanel.addComponentListener(new ComponentAdapter() {
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (encontrar.equals(true)){
                    JOptionPane.showMessageDialog(null, "Este Usuario se borrará permanentemente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                        MongoDatabase database = mongoClient.getDatabase("CinePoli");
                        MongoCollection<Document> collection = database.getCollection("Clientes");
                        Document filtro = new Document("usuario", textbuscar.getText() );
                        DeleteResult resultado = collection.deleteOne(filtro);
                        System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                    }

                }else{
                    info.setText("Usuario NO encontrado");
                }

            }
        });
    }
}
