package org.example.Usuario;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.Binary;
import org.example.Objetos.Pelicula;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ModuloUsuario {
    public JPanel MainPanel;
    private JButton cerrarSesionButton;
    private JButton sala_1;
    private JButton sala_2;
    private JButton sala_3;
    private JButton sala_5;
    private JButton sala_4;
    private JButton sala_6;
    private JButton sala_7;
    private JButton sala_8;
    private JButton sala_9;
    private JButton sala_10;
    private JButton misTicketsButton;
    private JLabel titulo_sala_1;
    private JLabel titulo_sala_2;
    private JLabel titulo_sala_3;
    private JLabel titulo_sala_4;
    private JLabel titulo_sala_5;
    private JLabel titulo_sala_6;
    private JLabel titulo_sala_7;
    private JLabel titulo_sala_8;
    private JLabel titulo_sala_9;
    private JLabel titulo_sala_10;
    //Variable de conexión a MongoDB Atlas
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    //Creamos Pelicula
    Pelicula pelicula = new Pelicula();

    public ModuloUsuario() {
        // Llama a la función automáticamente después de que el JFrame esté visible
        Timer timer = new Timer(100, e -> mostrar_peliculas());
        timer.setRepeats(false);
        timer.start();
    }



    public void mostrar_peliculas(){
        sala_1.setEnabled(false);
        sala_2.setEnabled(false);
        sala_3.setEnabled(false);
        sala_4.setEnabled(false);
        sala_5.setEnabled(false);
        sala_6.setEnabled(false);
        sala_7.setEnabled(false);
        sala_8.setEnabled(false);
        sala_9.setEnabled(false);
        sala_10.setEnabled(false);
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("CinePoli");
            MongoCollection<Document> collection = database.getCollection("Peliculas");
            //Se lee
            FindIterable<Document> documentos = collection.find();
            for (Document documento : documentos) {
                //Busco la existencia del Codigo
                pelicula.setCodigo(documento.getString("codigo"));
                Binary binaryContent = documento.get("imagen", Binary.class);
                pelicula.setImagen(binaryContent.getData());
                pelicula.setTitulo(documento.getString("titulo"));
                pelicula.setSinopsis(documento.getString("sinopsis"));
                pelicula.setGenero(documento.getString("genero"));
                pelicula.setSala(documento.getString("sala"));
                pelicula.setCategoria(documento.getString("categoria"));
                pelicula.setPrecio(documento.getDouble("precio"));

                if(pelicula.getSala().equals("Sala 1")){
                    // Convertir los bytes de vuelta a una imagen
                    ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                    BufferedImage newImage = ImageIO.read(bais);
                    // Mostrar la imagen en el JLabel
                    ImageIcon icon = new ImageIcon(newImage);
                    sala_1.setIcon(icon);
                    sala_1.setEnabled(true);
                    sala_1.setText(null);
                    titulo_sala_1.setText(pelicula.getTitulo());
                }

                if(pelicula.getSala().equals("Sala 2")){
                    // Convertir los bytes de vuelta a una imagen
                    ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                    BufferedImage newImage = ImageIO.read(bais);
                    // Mostrar la imagen en el JLabel
                    ImageIcon icon = new ImageIcon(newImage);
                    sala_2.setIcon(icon);
                    sala_2.setEnabled(true);
                    sala_2.setText(null);
                    titulo_sala_2.setText(pelicula.getTitulo());
                }

                if(pelicula.getSala().equals("Sala 3")){
                    // Convertir los bytes de vuelta a una imagen
                    ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                    BufferedImage newImage = ImageIO.read(bais);
                    // Mostrar la imagen en el JLabel
                    ImageIcon icon = new ImageIcon(newImage);
                    sala_3.setIcon(icon);
                    sala_3.setEnabled(true);
                    sala_3.setText(null);
                    titulo_sala_3.setText(pelicula.getTitulo());
                }

                if(pelicula.getSala().equals("Sala 4")){
                    // Convertir los bytes de vuelta a una imagen
                    ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                    BufferedImage newImage = ImageIO.read(bais);
                    // Mostrar la imagen en el JLabel
                    ImageIcon icon = new ImageIcon(newImage);
                    sala_4.setIcon(icon);
                    sala_4.setEnabled(true);
                    sala_4.setText(null);
                    titulo_sala_4.setText(pelicula.getTitulo());
                }

                if(pelicula.getSala().equals("Sala 5")){
                    // Convertir los bytes de vuelta a una imagen
                    ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                    BufferedImage newImage = ImageIO.read(bais);
                    // Mostrar la imagen en el JLabel
                    ImageIcon icon = new ImageIcon(newImage);
                    sala_5.setIcon(icon);
                    sala_5.setEnabled(true);
                    sala_5.setText(null);
                    titulo_sala_5.setText(pelicula.getTitulo());
                }

                if(pelicula.getSala().equals("Sala 6")){
                    // Convertir los bytes de vuelta a una imagen
                    ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                    BufferedImage newImage = ImageIO.read(bais);
                    // Mostrar la imagen en el JLabel
                    ImageIcon icon = new ImageIcon(newImage);
                    sala_6.setIcon(icon);
                    sala_6.setEnabled(true);
                    sala_6.setText(null);
                    titulo_sala_6.setText(pelicula.getTitulo());
                }

                if(pelicula.getSala().equals("Sala 7")){
                    // Convertir los bytes de vuelta a una imagen
                    ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                    BufferedImage newImage = ImageIO.read(bais);
                    // Mostrar la imagen en el JLabel
                    ImageIcon icon = new ImageIcon(newImage);
                    sala_7.setIcon(icon);
                    sala_7.setEnabled(true);
                    sala_7.setText(null);
                    titulo_sala_7.setText(pelicula.getTitulo());
                }

                if(pelicula.getSala().equals("Sala 8")){
                    // Convertir los bytes de vuelta a una imagen
                    ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                    BufferedImage newImage = ImageIO.read(bais);
                    // Mostrar la imagen en el JLabel
                    ImageIcon icon = new ImageIcon(newImage);
                    sala_8.setIcon(icon);
                    sala_8.setEnabled(true);
                    sala_8.setText(null);
                    titulo_sala_8.setText(pelicula.getTitulo());
                }


                if(pelicula.getSala().equals("Sala 9")){
                    // Convertir los bytes de vuelta a una imagen
                    ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                    BufferedImage newImage = ImageIO.read(bais);
                    // Mostrar la imagen en el JLabel
                    ImageIcon icon = new ImageIcon(newImage);
                    sala_9.setIcon(icon);
                    sala_9.setEnabled(true);
                    sala_9.setText(null);
                    titulo_sala_9.setText(pelicula.getTitulo());
                }

                if(pelicula.getSala().equals("Sala 10")){
                    // Convertir los bytes de vuelta a una imagen
                    ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                    BufferedImage newImage = ImageIO.read(bais);
                    // Mostrar la imagen en el JLabel
                    ImageIcon icon = new ImageIcon(newImage);
                    sala_10.setIcon(icon);
                    sala_10.setEnabled(true);
                    sala_10.setText(null);
                    titulo_sala_10.setText(pelicula.getTitulo());
                }


            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }




}


