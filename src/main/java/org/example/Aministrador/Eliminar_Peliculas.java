package org.example.Aministrador;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.types.Binary;
import org.example.Objetos.Pelicula;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Eliminar_Peliculas {
    public JPanel MainPanel;
    private JTextField campo_codigo;
    private JButton seleccionarButton;
    private JLabel imagen;
    private JLabel texto_titulo;
    private JButton eliminarButton;
    private JButton regresar_button;
    //Variable de conexión a MongoDB Atlas
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    //Creamos Pelicula
    Pelicula pelicula = new Pelicula();
    //Encontrar
    boolean encontrar = false;

    public Eliminar_Peliculas() {
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encontrar = false;

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

                        if(campo_codigo.getText().equals(pelicula.getCodigo())){
                            // Convertir los bytes de vuelta a una imagen
                            ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                            BufferedImage newImage = ImageIO.read(bais);
                            // Mostrar la imagen en el JLabel
                            ImageIcon icon = new ImageIcon(newImage);
                            imagen.setIcon(icon);
                            texto_titulo.setText(pelicula.getTitulo());
                            encontrar=true;
                        }



                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (encontrar){
                    JOptionPane.showMessageDialog(null, "Este Usuario se borrará permanentemente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                        MongoDatabase database = mongoClient.getDatabase("CinePoli");
                        MongoCollection<Document> collection = database.getCollection("Peliculas");
                        Document filtro = new Document("codigo", campo_codigo.getText() );
                        DeleteResult resultado = collection.deleteOne(filtro);
                        System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                    }

                }else{
                    JOptionPane.showMessageDialog(null, "Pelícua No encontrada.", "Aviso", JOptionPane.WARNING_MESSAGE);

                }

            }
        });
        regresar_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame();
                        frame.setContentPane( new Gestionar_Peliculas().MainPanel);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        frame.setVisible(true);
                        ((JFrame)SwingUtilities.getWindowAncestor(regresar_button)).dispose();

            }
        });
    }
}
