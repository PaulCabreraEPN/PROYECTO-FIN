package org.example.Usuario;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.Binary;
import org.example.Objetos.Pelicula;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SeleccionaPelicula {
    public JPanel MainPanel;
    private JLabel texto_titulo;
    private JLabel poster;
    private JLabel texto_sinopsis;
    private JLabel texto_sala;
    private JLabel texto_genero;
    private JLabel texto_categoria;
    private JLabel texto_precio;
    private JButton comprarButton;
    private JComboBox campo_tickets;
    private JComboBox campo_horario;
    private JComboBox campo_idioma;
    private JLabel texto_pelicula;
    private JButton regresar_button;
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    String SelectSala;
    Pelicula pelicula = new Pelicula();
    String Usuario;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getSelectSala() {
        return SelectSala;
    }

    public void setSelectSala(String selectSala) {
        SelectSala = selectSala;
    }

    public SeleccionaPelicula(){
        // Llama a la función automáticamente después de que el JFrame esté visible
        Timer timer = new Timer(100, e -> mostarPelicula());
        timer.setRepeats(false);
        timer.start();
        regresar_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane( new ModuloUsuario().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(regresar_button)).dispose();
            }
        });
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hora= (String) campo_horario.getSelectedItem();
                String idioma= (String) campo_idioma.getSelectedItem();
                String tickets = (String) campo_tickets.getSelectedItem();
                int intTickets = Integer.parseInt(tickets);

                JFrame frame = new JFrame();
                Sala Panel=new Sala();
                Panel.setMisala(SelectSala);
                Panel.setHora_pelicula(hora);
                Panel.setIdioma_pelicula(idioma);
                Panel.setCantidad_tickets(intTickets);
                Panel.setUsuario(Usuario);
                frame.setContentPane(Panel.MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(comprarButton)).dispose();
            }
        });
    }

    //Creamos Pelicula

    public void mostarPelicula(){
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("CinePoli");
            MongoCollection<Document> collection = database.getCollection("Peliculas");
            //Se lee
            FindIterable<Document> documentos = collection.find();
            for (Document documento : documentos) {
                //Busco la existencia del Codigo
                String codigo = documento.getString("codigo");
                String sala = documento.getString("sala");
                Binary binaryContent = documento.get("imagen", Binary.class);
                byte[] imagenP = binaryContent.getData();
                String titulo = documento.getString("titulo");
                String sinopsis = documento.getString("sinopsis");
                String genero = documento.getString("genero");
                String categoria = documento.getString("categoria");
                double precio = documento.getDouble("precio");

                if(sala.equals(SelectSala)){
                    pelicula.setGenero(genero);
                    pelicula.setCodigo(codigo);
                    pelicula.setSala(sala);
                    pelicula.setImagen(imagenP);
                    pelicula.setTitulo(titulo);
                    pelicula.setSinopsis(sinopsis);
                    pelicula.setCategoria(categoria);
                    pelicula.setPrecio(precio);
                    // Convertir los bytes de vuelta a una imagen
                    ByteArrayInputStream bais = new ByteArrayInputStream(pelicula.getImagen());
                    BufferedImage newImage = ImageIO.read(bais);
                    // Mostrar la imagen en el JLabel
                    ImageIcon icon = new ImageIcon(newImage);
                    poster.setIcon(icon);
                    texto_categoria.setText(pelicula.getCategoria());
                    texto_titulo.setText(pelicula.getTitulo());
                    texto_sinopsis.setText(pelicula.getSinopsis());
                    texto_genero.setText(pelicula.getGenero());
                    texto_precio.setText("$"+ String.valueOf(pelicula.getPrecio()));
                    texto_sala.setText(getSelectSala());
                    texto_pelicula.setText(pelicula.getTitulo());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

