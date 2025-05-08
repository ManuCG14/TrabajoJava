package com.mycompany.javaevents;

import java.util.ArrayList;
import java.util.List;

public class Eventos {
    
    private String titulo;  
    private TipoEvento tipo;
    private Direccion direccion;  
    private List<FechaHora> fechasHoras;
    private double precio;
    private double calificacion;
    private String portada; //Es un string porque hay q poner el nombre del archivo

    public Eventos(String titulo, TipoEvento tipo, Direccion direccion, double precio, String portada) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.precio = precio;
        this.portada = portada;
        this.calificacion = 0.0;
        this.fechasHoras = new ArrayList<>();
    }
   
    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void addFechaHora(FechaHora fechaHora) {
        fechasHoras.add(fechaHora);
    }

    public List<FechaHora> getFechasHoras() {
        return fechasHoras;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Evento: " + titulo + "\n" +
               "Tipo: " + tipo + "\n" +
               "Dirección: " + direccion + "\n" +
               "Fechas: " + fechasHoras + "\n" +
               "Precio entrada: " + precio + " €\n" +
               "Imagen portada: " + portada + "\n" +
               "Calificación media: " + calificacion + " / 5";
    }
}
