package com.mycompany.javaevents;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reserva implements Serializable {
    private Clientes cliente;
    private Eventos evento;
    private FechaHora fechaEvento;
    private LocalDateTime fechaReserva;
    private int cantidad;
    private double total;

    public Reserva(Clientes cliente, Eventos evento, FechaHora fechaEvento, int cantidad, double total) {
        this.cliente = cliente;
        this.evento = evento;
        this.fechaEvento = fechaEvento;
        this.fechaReserva = LocalDateTime.now();
        this.cantidad = cantidad;
        this.total = total;
    }

    public String generarFactura() {
        return """
        ---------------------------
        FACTURA DE RESERVA - JavaEvents
        Fecha reserva: %s
        Cliente: %s
        Evento: %s
        Fecha evento: %s
        Entradas: %d
        Total pagado: %.2f €
        ---------------------------
        """.formatted(fechaReserva, cliente.getNombre(), evento.getTitulo(),
                fechaEvento, cantidad, total);
    }

    public LocalDateTime getFechaReserva() { return fechaReserva; }
    public Clientes getCliente() { return cliente; }
    public Eventos getEvento() { return evento; }
}
