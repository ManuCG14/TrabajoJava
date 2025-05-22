package com.mycompany.javaevents;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reserva implements Serializable {
    private Clientes cliente;
    private Eventos evento;
    private LocalDateTime fechaReserva;
    private LocalDateTime fechaEvento;
    private int cantidadEntradas;
    private double total;

    // Constructor
    public Reserva(Clientes cliente, Eventos evento, LocalDateTime fechaEvento, int cantidadEntradas) {
        this.cliente = cliente;
        this.evento = evento;
        this.fechaEvento = fechaEvento;
        this.cantidadEntradas = cantidadEntradas;
        this.fechaReserva = LocalDateTime.now();

        double precioBase = evento.getPrecio() * cantidadEntradas;
        if (cliente.isVIP()) {
            this.total = precioBase * 0.9;
        } else {
            this.total = precioBase;
        }
    }

    // Getters
    public Clientes getCliente() {
        return cliente;
    }

    public Eventos getEvento() {
        return evento;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public LocalDateTime getFechaEvento() {
        return fechaEvento;
    }

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }

    public double getTotal() {
        return total;
    }

    // Generar factura
    public String generarFactura() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        StringBuilder factura = new StringBuilder();
        factura.append("===== FACTURA DE RESERVA =====\n");
        factura.append("Fecha de Reserva: ").append(fechaReserva.format(formatter)).append("\n");
        factura.append("Cliente: ").append(cliente.getNombre()).append("\n");
        factura.append("Correo: ").append(cliente.getCorreo()).append("\n");
        factura.append("VIP: ").append(cliente.isVIP() ? "Sí (10% de descuento)" : "No").append("\n\n");

        factura.append("EVENTO:\n");
        factura.append("Título: ").append(evento.getTitulo()).append("\n");
        factura.append("Tipo: ").append(evento.getTipo()).append("\n");
        factura.append("Fecha del Evento: ").append(fechaEvento.format(formatter)).append("\n");
        factura.append("Precio por entrada: ").append(String.format("%.2f €", evento.getPrecio())).append("\n");
        factura.append("Entradas compradas: ").append(cantidadEntradas).append("\n");
        factura.append("Total pagado: ").append(String.format("%.2f €", total)).append("\n");
        factura.append("==============================\n");

        return factura.toString();
    }

    @Override
    public String toString() {
        return "Reserva para el evento '" + evento.getTitulo() + "' por " + cliente.getNombre() +
                " | Fecha: " + fechaEvento + " | Total: " + total + " €";
    }

    // =============================
    // Métodos de búsqueda de eventos
    // =============================

    public static List<Eventos> buscarPorCiudad(List<Eventos> lista, String ciudad) {
        return lista.stream()
                .filter(e -> e.getDireccion().getCiudad().equalsIgnoreCase(ciudad))
                .collect(Collectors.toList());
    }

    public static List<Eventos> buscarPorTipo(List<Eventos> lista, TipoEvento tipo) {
        return lista.stream()
                .filter(e -> e.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    public static List<Eventos> buscarPorCiudadYTipo(List<Eventos> lista, String ciudad, TipoEvento tipo) {
        return lista.stream()
                .filter(e -> e.getDireccion().getCiudad().equalsIgnoreCase(ciudad)
                        && e.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    // =============================
    // Método para pruebas
    // =============================
    public static void imprimirEventos(List<Eventos> lista) {
        if (lista.isEmpty()) {
            System.out.println("No se encontraron eventos.");
        } else {
            for (Eventos e : lista) {
                System.out.println(e);
            }
        }
    }
}

