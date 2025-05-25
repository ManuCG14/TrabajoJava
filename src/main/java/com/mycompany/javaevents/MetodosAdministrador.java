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

    public static List<Usuarios> buscarUsuariosPorCorreo(List<Usuarios> usuarios, String correo) {
        return usuarios.stream()
                .filter(u -> u.getCorreo().equalsIgnoreCase(correo))
                .collect(Collectors.toList());
    }

    public static void mostrarReservas(List<Reserva> reservas) {
        reservas.stream()
                .sorted((r1, r2) -> r2.getFechaReserva().compareTo(r1.getFechaReserva()))
                .forEach(r -> System.out.println(r.generarFactura()));
    }

    public static List<Reserva> mostrarReservas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static List<Eventos> listarEventos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static List<Usuarios> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

