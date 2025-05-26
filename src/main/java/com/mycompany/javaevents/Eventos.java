package com.mycompany.javaevents;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Eventos implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private TipoEvento tipo;
    private Direccion direccion;
    private List<LocalDateTime> fechas;
    private double precio;
    private String portada;
    private double calificacion;
    private List<Reseña> reseñas;

    public Eventos(String titulo, TipoEvento tipo, Direccion direccion, double precio, String portada) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.precio = precio;
        this.portada = portada;
        this.fechas = new ArrayList<>();
        this.reseñas = new ArrayList<>();
        this.calificacion = 0.0;
    }

    public void agregarFecha(LocalDateTime fecha) {
        fechas.add(fecha);
    }

    public List<LocalDateTime> getFechas() {
        return fechas;
    }

    public LocalDateTime getPrimeraFecha() {
        return fechas.isEmpty() ? null : fechas.get(0);
    }

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

    public List<Reseña> getReseñas() {
        return reseñas;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void añadirReseña(Reseña reseña) {
        reseñas.add(reseña);
        recalcularCalificacion();
    }

    private void recalcularCalificacion() {
        if (reseñas.isEmpty()) {
            calificacion = 0.0;
            return;
        }
        double suma = 0.0;
        for (Reseña r : reseñas) {
            suma += r.getNota();
        }
        calificacion = Math.round((suma / reseñas.size()) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Evento: " + titulo + " - Tipo: " + tipo + " - Precio: " + precio + "€";
    }

    public Object getCiudad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}