package org.example.Objetos;

public class Pelicula {
    String codigo;
    String titulo;
    String sinopsis;
    String genero;
    String categoria;
    String sala;
    double precio;
    byte [] imagen;

    //Constructores
    public Pelicula() {
    }

    public Pelicula(String codigo, String titulo, String sinopsis, String categoria, String sala, double precio, byte[] imagen) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.categoria = categoria;
        this.sala = sala;
        this.precio = precio;
        this.imagen = imagen;
    }

    //Setters & Getters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    //Métodos
    public void Mostrar_pelicula(){
        System.out.println("Información de " + this.titulo);
        System.out.println("Código: " + this.codigo);
        System.out.println("Sinopsis: " + this.sinopsis);
        System.out.println("Género: " + this.genero);
        System.out.println("Cátalogo: " + this.categoria);
        System.out.println("Precio por Ticket: " + this.precio);
    }
}
