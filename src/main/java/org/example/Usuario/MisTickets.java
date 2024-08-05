package org.example.Usuario;

import com.mongodb.client.*;
import org.bson.Document;
import org.example.Objetos.Ticket;
import org.example.Objetos.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MisTickets {
    public JPanel MainPanel;
    private JTextField nombreDeLaPeliculaTextField;
    private JButton buscarButton;
    private JButton button1;
    String Usuario;
    String connectionString = "mongodb+srv://cabrerasebastian2904:27326460pOl@cluster0.ootv4pb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    Ticket ticket = new Ticket();

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public MisTickets() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean encontrar = false;
                System.out.println(encontrar);
                //Se establece la conexión con la Base de Datos
                try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                    MongoDatabase database = mongoClient.getDatabase("CinePoli");
                    MongoCollection<Document> collection = database.getCollection("Tickets");
                    //Se taen los datos de consulta
                    FindIterable<Document> documentos = collection.find();
                    //Se recorren los datos
                    for (Document documento : documentos) {
                        //System.out.println(documento.toJson());
                        ticket.setUsuario(documento.getString("usuario"));
                        ticket.setPelicula(documento.getString("pelicula"));
                        ticket.setIdioma(documento.getString("idioma"));
                        ticket.setSala(documento.getString("sala"));
                        ticket.setButaca(documento.getString("Butaca"));
                        ticket.setHorario(documento.getString("horario"));
                        Date fecha = documento.getDate("fecha");
                        String texto_fecha = formatter.format(fecha);
                        ticket.setValor_pagar(documento.getDouble("valor_pago"));

                        //Retorna unicamente los valores que se buscan
                        if (ticket.getUsuario().equals(getUsuario()) && ticket.getPelicula().equals(nombreDeLaPeliculaTextField.getText())){
                            encontrar = true;
                            JOptionPane.showMessageDialog(null,  ticket.getPelicula() + "\n Idioma: " + ticket.getIdioma()
                                    +"\n Sala: "+ ticket.getSala()
                                    +"\n Butaca: "+ ticket.getButaca()
                                    +"\n Horario: "+ ticket.getHorario()
                                    +"\n Fecha: "+texto_fecha
                                    +"\n Valor Total $ " + String.valueOf(ticket.getValor_pagar()), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                    if (encontrar.equals(false)){
                        JOptionPane.showMessageDialog(null, "No Tiene TICKETS para esa Película", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }
}
