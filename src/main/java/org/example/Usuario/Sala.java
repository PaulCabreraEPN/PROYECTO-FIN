package org.example.Usuario;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.Binary;
import org.example.Aministrador.Gestion_Usuarios;
import org.example.Aministrador.ModuloAdministrador;
import org.example.Objetos.Pelicula;
import org.example.Objetos.Ticket;
import org.example.Objetos.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDate;

public class Sala {
    public JPanel MainPanel;
    private JButton A1;
    private JButton A2;
    private JButton A3;
    private JButton A4;
    private JButton A5;
    private JButton A6;
    private JButton B1;
    private JButton B2;
    private JButton B3;
    private JButton B4;
    private JButton B5;
    private JButton B6;
    private JButton C1;
    private JButton C2;
    private JButton C3;
    private JButton C4;
    private JButton C5;
    private JButton D1;
    private JButton D2;
    private JButton D3;
    private JButton D4;
    private JButton D5;
    private JButton D6;
    private JButton E1;
    private JButton E2;
    private JButton E3;
    private JButton E4;
    private JButton E5;
    private JButton E6;
    private JButton F1;
    private JButton F2;
    private JButton F3;
    private JButton F4;
    private JButton F5;
    private JButton F6;
    private JLabel misButacas;
    private JLabel valor_total;
    private JButton C6;
    private JButton confirmarButton;
    private JButton button1;
    String misala;
    String hora_pelicula;
    String idioma_pelicula;
    int cantidad_tickets;
    int tickets_totales;
    double valor_apagar;
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    Pelicula pelicula=new Pelicula();
    Ticket ticket = new Ticket();

    ArrayList <String> tickets_selecionados = new ArrayList<>();

    public String getMisala() {
        return misala;
    }

    public void setMisala(String misala) {
        this.misala = misala;
    }

    public String getHora_pelicula() {
        return hora_pelicula;
    }

    public void setHora_pelicula(String hora_pelicula) {
        this.hora_pelicula = hora_pelicula;
    }

    public String getIdioma_pelicula() {
        return idioma_pelicula;
    }

    public void setIdioma_pelicula(String idioma_pelicula) {
        this.idioma_pelicula = idioma_pelicula;
    }

    public int getCantidad_tickets() {
        return cantidad_tickets;
    }

    public void setCantidad_tickets(int cantidad_tickets) {
        this.cantidad_tickets = cantidad_tickets;
    }

    public Sala(){
        // Llama a la función automáticamente después de que el JFrame esté visible
        Timer timer = new Timer(100, e -> mostrar_inf());
        timer.setRepeats(false);
        timer.start();

        A1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    A1.setEnabled(false);
                    A1.setBackground(new Color(20,76,193));
                    tickets_totales-=1;
                    tickets_selecionados.add("A1");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        A2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    A2.setEnabled(false);
                    A2.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("A2");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        A3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    A3.setEnabled(false);
                    A3.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("A3");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        A4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    A4.setEnabled(false);
                    A4.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("A4");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        A5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    A5.setEnabled(false);
                    A5.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("A5");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        A6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    A6.setEnabled(false);
                    A6.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("A6");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    B1.setEnabled(false);
                    B1.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("B1");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    B2.setEnabled(false);
                    B2.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("B2");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    A5.setEnabled(false);
                    A5.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("B3");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    B4.setEnabled(false);
                    B4.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("B4");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    B5.setEnabled(false);
                    B5.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("B5");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        B6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    B6.setEnabled(false);
                    B6.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("B6");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });


        C1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    C1.setEnabled(false);
                    C1.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("C1");
                    System.out.println(tickets_selecionados);
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        C2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    C2.setEnabled(false);
                    C2.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("C2");
                    System.out.println(tickets_selecionados);
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        C3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    C3.setEnabled(false);
                    C3.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("C3");
                    System.out.println(tickets_selecionados);
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        C4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    C4.setEnabled(false);
                    C4.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("C4");
                    System.out.println(tickets_selecionados);
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        C5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    C5.setEnabled(false);
                    C5.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("C5");
                    System.out.println(tickets_selecionados);
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        C6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    C6.setEnabled(false);
                    C6.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("C6");
                    System.out.println(tickets_selecionados);
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        D1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    D1.setEnabled(false);
                    D1.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("D1");
                    System.out.println(tickets_selecionados);
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        D2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    D2.setEnabled(false);
                    D2.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("D2");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        D3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    D3.setEnabled(false);
                    D3.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("D3");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        D4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    D4.setEnabled(false);
                    D4.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("D4");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        D5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    D5.setEnabled(false);
                    D5.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("D5");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        D6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    D6.setEnabled(false);
                    D6.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("D6");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        E1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    E1.setEnabled(false);
                    E1.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("E1");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        E2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    E2.setEnabled(false);
                    E2.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("E2");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        E3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    E3.setEnabled(false);
                    E3.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("E3");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        E4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    E4.setEnabled(false);
                    E4.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("E4");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        E5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    E5.setEnabled(false);
                    E5.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("E5");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        E6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    E6.setEnabled(false);
                    E6.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("E6");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        F1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    F1.setEnabled(false);
                    F1.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("F1");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        F2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    F2.setEnabled(false);
                    F2.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("F2");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        F3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    F3.setEnabled(false);
                    F3.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("F3");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        F4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    F4.setEnabled(false);
                    F4.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("F4");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        F5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    F5.setEnabled(false);
                    F5.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("F5");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });

        F6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tickets_totales);
                if (tickets_totales>0){
                    F6.setEnabled(false);
                    F6.setBackground(new Color(0,159,255));
                    tickets_totales-=1;
                    tickets_selecionados.add("F6");
                    valor_apagar+=pelicula.getPrecio();
                    misButacas.setText(String.valueOf(tickets_totales));
                    valor_total.setText(String.valueOf(valor_apagar));
                }
            }
        });


        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Seteo el ticket
                ticket.setUsuario("Paul");
                ticket.setFecha(LocalDateTime.now());
                ticket.setHorario(hora_pelicula);
                ticket.setIdioma(idioma_pelicula);
                ticket.setPelicula(pelicula.getTitulo());
                ticket.setValor_pagar(valor_apagar);
                ticket.setSala(misala);

                //Se establece la conexión con la Base de Datos
                try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                    MongoDatabase database = mongoClient.getDatabase("CinePoli");
                    MongoCollection<Document> collection = database.getCollection("Tickets");

                    for (int i = 0; i < tickets_selecionados.size(); i++) {
                        ticket.setButaca(tickets_selecionados.get(i));
                        System.out.println(tickets_selecionados.get(i));

                        //Se inserta los tickets en la base de datos
                        Document documento = new Document("usuario",ticket.getUsuario())
                                .append("pelicula",ticket.getPelicula())
                                .append("idioma",ticket.getIdioma())
                                .append("sala",ticket.getSala())
                                .append("Butaca",ticket.getButaca())
                                .append("horario",ticket.getHorario())
                                .append("fecha",ticket.getFecha())
                                .append("valor_pago",ticket.getValor_pagar());
                        collection.insertOne(documento);
                    }


                    JOptionPane.showMessageDialog(null, "las butacas " + tickets_selecionados + " se han reservado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    JFrame frame = new JFrame();
                    frame.setContentPane( new ModuloUsuario().MainPanel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(500, 500);
                    frame.setVisible(true);
                    ((JFrame)SwingUtilities.getWindowAncestor(button1)).dispose();
                }

            }

        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane( new ModuloUsuario().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(button1)).dispose();
            }
        });
    }

    public void mostrar_inf(){
        System.out.println(cantidad_tickets);
        System.out.println(idioma_pelicula);
        System.out.println(hora_pelicula);
        tickets_totales = getCantidad_tickets();
        misButacas.setText(String.valueOf(tickets_totales));
        valor_total.setText("0");

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

                if(sala.equals(misala)){
                    pelicula.setCodigo(codigo);
                    pelicula.setSala(sala);
                    pelicula.setImagen(imagenP);
                    pelicula.setTitulo(titulo);
                    pelicula.setSinopsis(sinopsis);
                    pelicula.setCategoria(categoria);
                    pelicula.setPrecio(precio);
                }
            }
        }

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("CinePoli");
            MongoCollection<Document> collection = database.getCollection("Tickets");
            //Se lee
            FindIterable<Document> documentos = collection.find();
            for (Document documento : documentos) {
                String butacas_ocupadas = documento.getString("Butaca");
                String hora_ocupada = documento.getString("horario");
                String sala_ocupada = documento.getString("sala");

                if(sala_ocupada.equals(misala) && hora_ocupada.equals(hora_pelicula)){
                    if (butacas_ocupadas.equals("A1")){
                        A1.setEnabled(false);
                        A1.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("A2")){
                        A2.setEnabled(false);
                        A2.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("A3")){
                        A3.setEnabled(false);
                        A3.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("A4")){
                        A4.setEnabled(false);
                        A4.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("A5")){
                        A5.setEnabled(false);
                        A5.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("A6")){
                        A6.setEnabled(false);
                        A6.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("B1")){
                        B1.setEnabled(false);
                        B1.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("B2")){
                        B2.setEnabled(false);
                        B2.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("B3")){
                        B3.setEnabled(false);
                        B3.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("B4")){
                        B4.setEnabled(false);
                        B4.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("B5")){
                        B5.setEnabled(false);
                        B5.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("B6")){
                        B6.setEnabled(false);
                        B6.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("C1")){
                        C1.setEnabled(false);
                        C1.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("C2")){
                        C2.setEnabled(false);
                        C2.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("C3")){
                        C3.setEnabled(false);
                        C3.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("C4")){
                        C4.setEnabled(false);
                        C4.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("C5")){
                        C5.setEnabled(false);
                        C5.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("C6")){
                        C6.setEnabled(false);
                        C6.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("D1")){
                        D1.setEnabled(false);
                        D1.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("D2")){
                        D2.setEnabled(false);
                        D2.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("D3")){
                        D3.setEnabled(false);
                        D3.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("D4")){
                        D4.setEnabled(false);
                        D4.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("D5")){
                        D5.setEnabled(false);
                        D5.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("D6")){
                        D6.setEnabled(false);
                        D6.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("E1")){
                        E1.setEnabled(false);
                        E1.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("E2")){
                        E2.setEnabled(false);
                        E2.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("E3")){
                        E3.setEnabled(false);
                        E3.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("E4")){
                        E4.setEnabled(false);
                        E4.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("E5")){
                        E5.setEnabled(false);
                        E5.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("E6")){
                        E6.setEnabled(false);
                        E6.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("F1")){
                        F1.setEnabled(false);
                        F1.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("F2")){
                        F2.setEnabled(false);
                        F2.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("F3")){
                        F3.setEnabled(false);
                        F3.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("F4")){
                        F4.setEnabled(false);
                        F4.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("F5")){
                        F5.setEnabled(false);
                        F5.setBackground(Color.red);
                    }

                    if (butacas_ocupadas.equals("F6")){
                        F6.setEnabled(false);
                        F6.setBackground(Color.red);
                    }


                }
            }
        }
    }


}
