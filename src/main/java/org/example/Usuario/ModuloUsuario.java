package org.example.Usuario;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.Binary;
import org.example.Aministrador.ModuloAdministrador;
import org.example.Login;
import org.example.Objetos.Pelicula;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel Bienvenida;
    String Usuario;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    //Variable de conexión a MongoDB Atlas
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    //Creamos Pelicula
    protected Pelicula pelicula = new Pelicula();


    public ModuloUsuario() {
        // Llama a la función automáticamente después de que el JFrame esté visible
        Timer timer = new Timer(100, e -> mostrar_peliculas());
        timer.setRepeats(false);
        timer.start();

        sala_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                SeleccionaPelicula Panel=new SeleccionaPelicula();
                Panel.setSelectSala("Sala 1");
                Panel.setUsuario(Usuario);
                frame.setContentPane(Panel.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(sala_1)).dispose();

            }
        });
        sala_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                SeleccionaPelicula Panel=new SeleccionaPelicula();
                Panel.setSelectSala("Sala 2");
                Panel.setUsuario(Usuario);
                frame.setContentPane(Panel.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(sala_1)).dispose();
            }
        });
        sala_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                SeleccionaPelicula Panel=new SeleccionaPelicula();
                Panel.setSelectSala("Sala 3");
                Panel.setUsuario(Usuario);
                frame.setContentPane(Panel.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(sala_1)).dispose();
            }
        });
        sala_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                SeleccionaPelicula Panel=new SeleccionaPelicula();
                Panel.setSelectSala("Sala 4");
                Panel.setUsuario(Usuario);
                frame.setContentPane(Panel.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(sala_1)).dispose();
            }
        });
        sala_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                SeleccionaPelicula Panel=new SeleccionaPelicula();
                Panel.setSelectSala("Sala 5");
                Panel.setUsuario(Usuario);
                frame.setContentPane(Panel.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(sala_1)).dispose();
            }
        });
        sala_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                SeleccionaPelicula Panel=new SeleccionaPelicula();
                Panel.setSelectSala("Sala 6");
                Panel.setUsuario(Usuario);
                frame.setContentPane(Panel.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(sala_1)).dispose();
            }
        });
        sala_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                SeleccionaPelicula Panel=new SeleccionaPelicula();
                Panel.setSelectSala("Sala 7");
                Panel.setUsuario(Usuario);
                frame.setContentPane(Panel.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(sala_1)).dispose();
            }
        });
        sala_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                SeleccionaPelicula Panel=new SeleccionaPelicula();
                Panel.setSelectSala("Sala 8");
                Panel.setUsuario(Usuario);
                frame.setContentPane(Panel.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(sala_1)).dispose();
            }
        });
        sala_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                SeleccionaPelicula Panel=new SeleccionaPelicula();
                Panel.setSelectSala("Sala 9");
                Panel.setUsuario(Usuario);
                frame.setContentPane(Panel.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(sala_1)).dispose();
            }
        });
        sala_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                SeleccionaPelicula Panel=new SeleccionaPelicula();
                Panel.setSelectSala("Sala 10");
                Panel.setUsuario(Usuario);
                frame.setContentPane(Panel.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(sala_1)).dispose();
            }
        });
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane( new Login().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(cerrarSesionButton)).dispose();

            }
        });

        misTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                MisTickets misTickets = new MisTickets();
                misTickets.setUsuario(Usuario);
                frame.setContentPane( misTickets.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(cerrarSesionButton)).dispose();
            }
        });
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
        String SalaEncontrada;
        Bienvenida.setText("Bienvenid@ "+Usuario);
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
                SalaEncontrada=(documento.getString("sala"));
                pelicula.setCategoria(documento.getString("categoria"));
                pelicula.setPrecio(documento.getDouble("precio"));

                if(SalaEncontrada.equals("Sala 1")){
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

                if(SalaEncontrada.equals("Sala 2")){
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

                if(SalaEncontrada.equals("Sala 3")){
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

                if(SalaEncontrada.equals("Sala 4")){
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

                if(SalaEncontrada.equals("Sala 5")){
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

                if(SalaEncontrada.equals("Sala 6")){
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

                if(SalaEncontrada.equals("Sala 7")){
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

                if(SalaEncontrada.equals("Sala 8")){
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


                if(SalaEncontrada.equals("Sala 9")){
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

                if(SalaEncontrada.equals("Sala 10")){
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


