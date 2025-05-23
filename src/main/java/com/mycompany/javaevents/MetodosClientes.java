package com.mycompany.javaevents;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MetodosClientes {

    private static List<Clientes> clientes = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();

    // 2.1 Registro/Login
    public static boolean registrarCliente(Clientes cliente) {
        Optional<Clientes> existente = clientes.stream()
                .filter(c -> c.getCorreo().equalsIgnoreCase(cliente.getCorreo()))
                .findFirst();
        if (existente.isPresent()) return false;
        clientes.add(cliente);
        return true;
    }

    public static Clientes login(String correo, String clave) {
        return clientes.stream()
                .filter(c -> c.getCorreo().equalsIgnoreCase(correo) && c.getClave().equals(clave))
                .findFirst()
                .orElse(null);
    }

    public static List<Eventos> buscarPorTipo(List<Eventos> eventos, TipoEvento tipo) {
        return eventos.stream()
                .filter(e -> e.getTipo() == tipo)
                .collect(Collectors.toList());
    }

    public static List<Eventos> buscarPorCiudad(List<Eventos> eventos, String ciudad) {
        return eventos.stream()
                .filter(e -> e.getDireccion().getCiudad().equalsIgnoreCase(ciudad))
                .collect(Collectors.toList());
    }

    public static List<Eventos> buscarPorCiudadYTipo(List<Eventos> lista, String ciudad, TipoEvento tipo) {
        return lista.stream()
                .filter(e -> e.getDireccion().getCiudad().equalsIgnoreCase(ciudad) && e.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    public static void dejarReseña(Eventos evento, int nota, String comentario) {
        evento.añadirReseña(new Reseña(nota, comentario));
    }

    public static void dejarReseña(Eventos evento, int nota) {
        dejarReseña(evento, nota, "");
    }

    public static List<Reserva> obtenerReservasDeCliente(Clientes cliente) {
        return reservas.stream()
                .filter(r -> r.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    public static boolean modificarDatosCliente(String correo, String nuevaClave, String nuevoNombre) {
        for (Clientes c : clientes) {
            if (c.getCorreo().equalsIgnoreCase(correo)) {
                c.setClave(nuevaClave);
                c.setNombre(nuevoNombre);
                return true;
            }
        }
        return false;
    }
}
