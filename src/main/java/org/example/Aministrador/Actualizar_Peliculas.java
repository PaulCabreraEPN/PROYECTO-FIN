package org.example.Aministrador;

import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
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

public class Actualizar_Peliculas {
    public JPanel MainPanel;
    private JTextField campo_codigo;
    private JButton consultarButton;
    private JLabel imagen;
    private JButton reemplazarButton;
    private JTextField campo_titulo;
    private JTextField campo_precio;
    private JTextField campo_sinopsis;
    private JComboBox campo_genero;
    private JComboBox campo_sala;
    private JComboBox campo_categoria;
    private JButton actualizarButton;
    private JButton regresar_button;

    //Variable de conexión a MongoDB Atlas
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    //Creamos Pelicula
    Pelicula pelicula = new Pelicula();

    public Actualizar_Peliculas() {
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
                        pelicula.setImagen(binaryContent.getData());
                        pelicula.setTitulo(documento.getString("titulo"));
                        pelicula.setSinopsis(documento.getString("sinopsis"));
                        pelicula.setGenero(documento.getString("genero"));
                        pelicula.setSala(documento.getString("sala"));
                        pelicula.setCategoria(documento.getString("categoria"));
                        pelicula.setPrecio(documento.getDouble("precio"));

                        if(campo_codigo.getText().equals(pelicula.getCodigo())){
                            // Convertir los bytes de vuelta a una imagen
                            ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                            BufferedImage newImage = ImageIO.read(bais);
                            // Mostrar la imagen en el JLabel
                            ImageIcon icon = new ImageIcon(newImage);
                            imagen.setIcon(icon);

                            campo_titulo.setText(pelicula.getTitulo());
                            campo_sinopsis.setText(pelicula.getSinopsis());
                            campo_genero.setSelectedItem(pelicula.getGenero());
                            campo_sala.setSelectedItem(pelicula.getSala());
                            campo_categoria.setSelectedItem(pelicula.getCategoria());
                            campo_precio.setText(String.valueOf(pelicula.getPrecio()));

                        }



                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                    boolean existencia=false;
                    MongoDatabase database = mongoClient.getDatabase("CinePoli");
                    MongoCollection<Document> collection = database.getCollection("Peliculas");
                    FindIterable<Document> documentos = collection.find();
                    String genero = (String) campo_genero.getSelectedItem();
                    String categoria = (String) campo_categoria.getSelectedItem();
                    String sala = (String) campo_sala.getSelectedItem();
                    double precio = Double.parseDouble(campo_precio.getText());

                    //Validación de Sala

                    for (Document documento : documentos) {
                        //Busco la existencia de la Sala
                        pelicula.setSala(documento.getString("sala"));
                        pelicula.setCodigo(documento.getString("codigo"));

                        if (!pelicula.getCodigo().equals(campo_codigo.getText())){
                            if (pelicula.getSala().equals(sala)) {
                                JOptionPane.showMessageDialog(null, "Sala Ocupada, Por Favor Ingrese una Diferente", "Aviso", JOptionPane.WARNING_MESSAGE);
                                existencia = true;
                            }
                        }
                    }



                    //Se taen los datos de consulta
                    Document filtro = new Document("codigo", campo_codigo.getText());

                    if (existencia == false){
                        Document actualizacion = new Document("$set", new Document("titulo", campo_titulo.getText()).append("sinopsis", campo_sinopsis.getText()).append("genero", genero ).append("sala", sala ).append("genero", genero ).append("categoria", categoria ).append("genero", genero ).append("precio", precio ));
                        UpdateResult resultado = collection.updateOne(filtro, actualizacion);
                        JOptionPane.showMessageDialog(null, "Se han actualizado" + resultado.getModifiedCount() + "con éxito.", "Éxito", JOptionPane.WARNING_MESSAGE);
                        System.out.println("Documentos modificados: " + resultado.getModifiedCount());

                    }

                }
            }
        });
        regresar_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame();
                        frame.setContentPane( new Gestionar_Peliculas().MainPanel);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(500, 500);
                        frame.setVisible(true);
                        ((JFrame)SwingUtilities.getWindowAncestor(regresar_button)).dispose();

            }
        });
    }
}
