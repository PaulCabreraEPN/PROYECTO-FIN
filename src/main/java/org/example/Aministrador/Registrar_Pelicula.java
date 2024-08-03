package org.example.Aministrador;

import com.mongodb.client.*;
import org.bson.Document;
import org.example.Objetos.Pelicula;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;

public class Registrar_Pelicula {
    public JPanel MainPanel;
    private JTextField campo_codigo;
    private JTextField campo_titulo;
    private JTextField campo_sinopsis;
    private JComboBox campo_categoria;
    private JButton registrarButton;
    private JButton cancelarButton;
    private JTextField campo_precio;
    private JButton insertar_img;
    private JLabel fin;
    private JComboBox campo_sala;
    private JComboBox campo_genero;
    private JButton regresar_button;
    private JLabel Imagen;
    String ruta;
    //Variable de conexión a MongoDB Atlas
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    //Creamos Pelicula
    Pelicula pelicula = new Pelicula();


    public Registrar_Pelicula() {
        insertar_img.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear el JFileChooser
                JFileChooser fileChooser = new JFileChooser();

                // Crear el filtro de archivos
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen (JPG, PNG)", "jpg");
                fileChooser.setFileFilter(filter);

                // Mostrar el diálogo de abrir archivo
                int result = fileChooser.showOpenDialog(null);

                // Si se selecciona un archivo
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Obtener el archivo seleccionado
                    java.io.File selectedFile = fileChooser.getSelectedFile();
                    try {
                        // Leer la imagen
                        BufferedImage image = ImageIO.read(selectedFile);

                        // Convertir la imagen a un arreglo de bytes
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "jpg", baos); // Aquí se asume que se guarda como JPG
                        byte[] imageBytes = baos.toByteArray();
                        pelicula.setImagen(imageBytes);

                        // Mostrar mensaje confirmando la operación
                        JOptionPane.showMessageDialog(null, "Imagen leída y convertida a bytes con éxito. Tamaño: " + imageBytes.length + " bytes");

                        // Convertir los bytes de vuelta a una imagen
                        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                        BufferedImage newImage = ImageIO.read(bais);

                        // Mostrar la imagen en el JLabel
                        ImageIcon icon = new ImageIcon(newImage);
                        fin.setIcon(icon);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al leer la imagen: " + ex.getMessage());
                    }

                }
            }

        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean vacios=false;
                boolean existencia=false;
                //Salas ocupadas
                String salaOcupada = (String) campo_sala.getSelectedItem();

                //Validar que los campos se encuentren llenos
                if (campo_codigo.getText().equals("")){
                    vacios=true;
                }else {
                    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                        MongoDatabase database = mongoClient.getDatabase("CinePoli");
                        MongoCollection<Document> collection = database.getCollection("Peliculas");
                        //Se lee
                        FindIterable<Document> documentos = collection.find();
                        for (Document documento : documentos) {
                            //Busco la existencia del Codigo
                            pelicula.setCodigo(documento.getString("codigo"));

                            if (campo_codigo.getText().equals(pelicula.getCodigo())){
                                JOptionPane.showMessageDialog(null, "Codigo de Película existente, Por Favor Ingrese uno Nuevo", "Aviso", JOptionPane.WARNING_MESSAGE);
                                existencia=true;
                            }
                        }
                    }
                }

                if (campo_titulo.getText().equals("")){
                    vacios=true;
                }else {
                    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                        MongoDatabase database = mongoClient.getDatabase("CinePoli");
                        MongoCollection<Document> collection = database.getCollection("Peliculas");
                        //Se lee
                        FindIterable<Document> documentos = collection.find();
                        for (Document documento : documentos) {
                            //Busco la existencia del Titulo
                            pelicula.setTitulo(documento.getString("titulo"));

                            if (campo_titulo.getText().equals(pelicula.getTitulo())){
                                JOptionPane.showMessageDialog(null, "Película existente, Por Favor Ingrese uno Nueva", "Aviso", JOptionPane.WARNING_MESSAGE);
                                existencia=true;
                            }
                        }
                    }
                }

                try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                    MongoDatabase database = mongoClient.getDatabase("CinePoli");
                    MongoCollection<Document> collection = database.getCollection("Peliculas");
                    //Se lee
                    FindIterable<Document> documentos = collection.find();
                    for (Document documento : documentos) {
                        //Busco la existencia de la Sala
                        pelicula.setSala(documento.getString("sala"));

                        if (pelicula.getSala().equals(salaOcupada)){
                            JOptionPane.showMessageDialog(null, "Sala Ocupada, Por Favor Ingrese una Diferente", "Aviso", JOptionPane.WARNING_MESSAGE);
                            existencia=true;
                        }
                    }
                }



                if (campo_precio.getText().equals("")){
                    vacios=true;
                }


                if (!vacios && !existencia){
                    String sala = (String) campo_sala.getSelectedItem();
                    String genero = (String) campo_genero.getSelectedItem();
                    String categoria = (String) campo_categoria.getSelectedItem();
                    double precio = Double.parseDouble(campo_precio.getText());
                    pelicula.setCodigo(campo_codigo.getText());
                    pelicula.setTitulo(campo_titulo.getText());
                    pelicula.setSinopsis(campo_sinopsis.getText());
                    pelicula.setSala(sala);
                    pelicula.setPrecio(precio);
                    pelicula.setCategoria(categoria);
                    pelicula.setGenero(genero);

                    //Se establece la conexión con la Base de Datos
                    try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                        MongoDatabase database = mongoClient.getDatabase("CinePoli");
                        MongoCollection<Document> collection = database.getCollection("Peliculas");
                        //Se inserta el nuevo cliente en la base de datos
                        Document documento = new Document("codigo", pelicula.getCodigo())
                                .append("imagen", pelicula.getImagen())
                                .append("titulo", pelicula.getTitulo())
                                .append("sinopsis", pelicula.getSinopsis())
                                .append("genero", pelicula.getGenero())
                                .append("sala", pelicula.getSala())
                                .append("categoria", pelicula.getCategoria())
                                .append("precio", pelicula.getPrecio())
                                ;
                        pelicula.Mostrar_pelicula();
                        collection.insertOne(documento);
                        JOptionPane.showMessageDialog(null, "Película Registrada Con Éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Existen Campos Vacíos o Erroneos. Por favor llenarlos", "Aviso", JOptionPane.WARNING_MESSAGE);
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
