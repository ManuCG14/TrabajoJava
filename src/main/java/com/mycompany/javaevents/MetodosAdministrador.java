package com.mycompany.javaevents;

import java.util.List;
import java.util.stream.Collectors;

public class MetodosAdministrador {

    public static void listarEventos(List<Eventos> eventos) {
        for (Eventos e : eventos) {
            System.out.println(e.getTitulo() + " | " + e.getTipo() + " | " + e.getDireccion());
        }
    }

    public static List<Eventos> buscarEventosPorCiudad(List<Eventos> eventos, String ciudad) {
    return eventos.stream()
                 .filter(e -> e.getDireccion().getCiudad().equalsIgnoreCase(ciudad))
                 .collect(Collectors.toList());
}

    public static List<Usuarios> buscarUsuariosPorCorreo(String correo) {
        return Datos.usuarios.stream()
                .filter(u -> u.getCorreo().equalsIgnoreCase(correo))
                .collect(Collectors.toList());
    }

    // Imprime las reservas ordenadas por fecha de reserva (de más recientes a más antiguas)
    public static void imprimirReservasOrdenadas() {
        Datos.reservas.stream()
                .sorted((r1, r2) -> r2.getFechaReserva().compareTo(r1.getFechaReserva()))
                .forEach(r -> System.out.println(r.generarFactura()));
    }

    // Devuelve la lista completa de eventos
    public static List<Eventos> listarEventos() {
        return Datos.eventos;
    }

    // Devuelve la lista completa de reservas
    public static List<Reserva> obtenerReservas() {
        return Datos.reservas;
    }

    // Devuelve la lista completa de usuarios
    public static List<Usuarios> listarUsuarios() {
        return Datos.usuarios;
    }


}
