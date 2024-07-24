package org.example.Objetos;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

public class Usuario {
    String cedula;
    String user;
    String password;
    String nombre;
    String apellido;
    int edad;
    String correo;
    String telefono;
    String domicilio;
    String publico;

    //Constructores
    //(Vacío)
    public Usuario() {
    }

    //(Lleno)
    public Usuario(String cedula, String user, String password, String nombre, String apellido, int edad, String correo, String telefono, String domicilio) {
        this.cedula = cedula;
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    //Setters & Getters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    //Metodos personalizados
    //Calcular mayoría de edad
    public String Calcular_mayoria_edad(int edad){
        if (edad<18){
            this.publico="Menor de edad";
        }else {
            this.publico="Mayor de edad";
        }
        return this.publico;
    }

    //Mostrar información del usuario
    public void Mostrar_usuario(){
        System.out.println("Información de " + this.user);
        System.out.println("Cédula: " + this.cedula);
        System.out.println("Nombre: " + this.nombre + " " + this.apellido);
        System.out.println("Público: " + this.publico);
        System.out.println("Teléfono: "+ this.telefono);
        System.out.println("Dirección: " + this.domicilio);
    }

}
