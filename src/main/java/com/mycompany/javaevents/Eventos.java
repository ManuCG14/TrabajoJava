package com.mycompany.javaevents;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Eventos implements Serializable {
     private String titulo;
    private TipoEvento tipo;
    private Direccion direccion;
    private List<LocalDateTime> fechas; // Lista de fechas
    private double precio;
    private String portada; // puede ser ruta de imagen
    private double calificacion;

    public Eventos(String titulo, TipoEvento tipo, Direccion direccion, double precio, String portada) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.precio = precio;
        this.portada = portada;
        this.fechas = new ArrayList<>();
        this.calificacion = 0.0;
    }

    // Métodos para trabajar con fechas
    public void agregarFecha(LocalDateTime fecha) {
        fechas.add(fecha);
    }

    public List<LocalDateTime> getFechas() {
        return fechas;
    }

    public LocalDateTime getPrimeraFecha() {
        return fechas.isEmpty() ? null : fechas.get(0);
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getPortada() {
        return portada;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Evento: " + titulo + " - Tipo: " + tipo + " - Precio: " + precio + "€";
    }
}