package org.example.Aministrador;

import com.mongodb.client.*;
import org.bson.Document;
import org.example.Objetos.Pelicula;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bson.Document;
import org.bson.types.Binary;


public class Buscar_Peliculas {
    public JPanel MainPanel;
    private JTextField campo_codigo;
    private JButton consultarButton;
    private JLabel imagen;
    //Variable de conexión a MongoDB Atlas
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    //Creamos Pelicula
    Pelicula pelicula = new Pelicula();

    public Buscar_Peliculas() {
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                    MongoDatabase database = mongoClient.getDatabase("CinePoli");
                    MongoCollection<Document> collection = database.getCollection("Peliculas");
                    //Se lee
                    FindIterable<Document> documentos = collection.find();
                    for (Document documento : documentos) {
                        //Busco la existencia del Codigo
                        pelicula.setCodigo(documento.getString("codigo"));
                        Binary binaryContent = documento.get("imagen", Binary.class);
                        byte[] contenido_imagen=binaryContent.getData();

                        // Convertir los bytes de vuelta a una imagen
                        ByteArrayInputStream bais = new ByteArrayInputStream(contenido_imagen);
                        BufferedImage newImage = ImageIO.read(bais);

                        // Mostrar la imagen en el JLabel
                        ImageIcon icon = new ImageIcon(newImage);
                        imagen.setIcon(icon);

                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
