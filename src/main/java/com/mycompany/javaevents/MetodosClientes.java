package com.mycompany.javaevents;

import static JavaEventsApp.JavaEventsApp.clienteLogueado;
import static com.mycompany.javaevents.Datos.usuarios;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

public class MetodosClientes {

    private static List<Clientes> clientes = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();

   private static final String ARCHIVO_RESERVAS = "reservas.dat";

    public static void guardarReservas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_RESERVAS))) {
            oos.writeObject(reservas);
            System.out.println("Reservas guardadas correctamente.");
    } catch (IOException e) {
        System.err.println("Error guardando reservas: " + e.getMessage());
    }
}

    public static void cargarReservas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_RESERVAS))) {
            reservas = (List<Reserva>) ois.readObject();
            System.out.println("Reservas cargadas: " + reservas.size());
    }   catch (IOException | ClassNotFoundException e) {
            reservas = new ArrayList<>();
            System.out.println("No se pudo cargar reservas. Se inicia lista vacía.");
    }
}

    // Registro de clientes
    public static boolean registrarCliente(Clientes cliente) {
        Optional<Clientes> existente = clientes.stream()
                .filter(c -> c.getCorreo().equalsIgnoreCase(cliente.getCorreo()))
                .findFirst();
        if (existente.isPresent()) return false;

        clientes.add(cliente);

        // Añadir también a la lista global de usuarios
        Datos.usuarios.add(cliente);

        return true;
    }

    // Login
    public static Usuarios iniciarSesion(String correo, String clave) {
        for (Usuarios u : Datos.usuarios) {
            if (u.getCorreo().equals(correo) && u.getClave().equals(clave)) {
                return u;
        }
    }
    return null; // Usuario no encontrado
}

    // Búsqueda de eventos por tipo
    public static List<Eventos> buscarPorTipo(List<Eventos> eventos, TipoEvento tipo) {
        return eventos.stream()
                .filter(e -> e.getTipo() == tipo)
                .collect(Collectors.toList());
    }

    // Búsqueda de eventos por ciudad
    public static List<Eventos> buscarPorCiudad(List<Eventos> eventos, String ciudad) {
        return eventos.stream()
                .filter(e -> e.getDireccion().getCiudad().equalsIgnoreCase(ciudad))
                .collect(Collectors.toList());
    }

    // Búsqueda por ciudad y tipo
    public static List<Eventos> buscarPorCiudadYTipo(List<Eventos> lista, String ciudad, TipoEvento tipo) {
        return lista.stream()
                .filter(e -> e.getDireccion().getCiudad().equalsIgnoreCase(ciudad) && e.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    // Dejar reseña
    public static void dejarReseña(Eventos evento, int nota, String comentario) {
        evento.añadirReseña(new Reseña(nota, comentario));
    }

    public static void dejarReseña(Eventos evento, int nota) {
        dejarReseña(evento, nota, "");
    }

    // Obtener reservas por cliente
    public static List<Reserva> obtenerReservasDeCliente(Clientes cliente) {
        return reservas.stream()
            .filter(r -> r.getCliente().getCorreo().equalsIgnoreCase(cliente.getCorreo()))
            .collect(Collectors.toList());
}

    // Modificar datos del cliente
    public static boolean modificarDatosCliente(String correo, String nuevaClave, String nuevoNombre) {
        for (Usuarios u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                u.setClave(nuevaClave);
                u.setNombre(nuevoNombre);
                return true;
            }
        }
        return false;
    }

    // Acceso a la lista de clientes
    public static List<Clientes> getClientes() {
        return clientes;
    }

    // Añadir reserva
    public static void añadirReserva(Reserva reserva) {
        reservas.add(reserva);
    }
    // Borrar cliente por correo (opcional extra)
    public static boolean borrarCliente(String correo) {
        boolean borrado = clientes.removeIf(c -> c.getCorreo().equalsIgnoreCase(correo));
        if (borrado) {
            Datos.usuarios.removeIf(u -> u.getCorreo().equalsIgnoreCase(correo));
        }
        return borrado;
    }

    public static List<Reserva> getReservas() {
    return reservas;
}
}



