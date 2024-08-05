package org.example.Objetos;

import java.util.Date;
import java.time.LocalDateTime;

public class Ticket {
    String pelicula;
    String horario;
    String usuario;
    double valor_pagar;
    String butaca;
    LocalDateTime fecha;
    String idioma;
    String sala;

    public Ticket(String pelicula, String horario, String usuario, double valor_pagar, String butaca,  LocalDateTime fecha, String idioma, String sala) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.usuario = usuario;
        this.valor_pagar = valor_pagar;
        this.butaca = butaca;
        this.fecha = fecha;
        this.idioma = idioma;
        this.sala = sala;
    }

    public Ticket() {
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getValor_pagar() {
        return valor_pagar;
    }

    public void setValor_pagar(double valor_pagar) {
        this.valor_pagar = valor_pagar;
    }

    public String getButaca() {
        return butaca;
    }

    public void setButaca(String butaca) {
        this.butaca = butaca;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
