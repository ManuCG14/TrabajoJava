package com.mycompany.javaevents;

import java.util.ArrayList;
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
    public static void agregarReserva(Reserva r) {
    Datos.reservas.add(r);
}
    // Método para devolver todas las reservas del sistema
    public static List<Reserva> mostrarReservas() {
        return new ArrayList<>(Datos.reservas); // Retornar una copia para evitar modificaciones directas
    }

}
