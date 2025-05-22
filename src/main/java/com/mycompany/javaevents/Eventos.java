package com.mycompany.javaevents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Eventos implements Serializable {
    private String titulo;
    private TipoEvento tipo;
    private Direccion direccion;
    private List<FechaHora> fechas;
    private double precio;
    private String portada;
    private List<Reseña> reseñas;

    public Eventos(String titulo, TipoEvento tipo, Direccion direccion, List<FechaHora> fechas, double precio, String portada) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.fechas = fechas;
        this.precio = precio;
        this.portada = portada;
        this.reseñas = new ArrayList<>();
    }

    public String getTitulo() { return titulo; }
    public TipoEvento getTipo() { return tipo; }
    public Direccion getDireccion() { return direccion; }
    public List<FechaHora> getFechas() { return fechas; }
    public double getPrecio() { return precio; }
    public String getPortada() { return portada; }

    public void añadirReseña(Reseña r) {
        reseñas.add(r);
    }

    public double getCalificacionMedia() {
        if (reseñas.isEmpty()) return 0.0;
        return reseñas.stream().mapToInt(Reseña::getNota).average().orElse(0.0);
    }
}