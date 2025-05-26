package com.mycompany.javaevents;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MetodosClientes {

    private static List<Clientes> clientes = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();

    private static final String ARCHIVO_CLIENTES = "clientes.dat";

    // Cargar clientes desde archivo al iniciar la app
    public static void cargarClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES))) {
            clientes = (List<Clientes>) ois.readObject();
            System.out.println("Clientes cargados: " + clientes.size());
        } catch (IOException | ClassNotFoundException e) {
            clientes = new ArrayList<>(); // Si falla la carga, inicializa vacía
            System.out.println("No se pudo cargar clientes. Se inicia lista vacía.");
        }
    }

    // Guardar clientes al cerrar la app
    public static void guardarClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            oos.writeObject(clientes);
            System.out.println("Clientes guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error guardando clientes: " + e.getMessage());
        }
    }

    // Registro de clientes
    public static boolean registrarCliente(Clientes cliente) {
        Optional<Clientes> existente = clientes.stream()
                .filter(c -> c.getCorreo().equalsIgnoreCase(cliente.getCorreo()))
                .findFirst();
        if (existente.isPresent()) return false;
        clientes.add(cliente);
        return true;
    }

    // Login
    public static Clientes login(String correo, String clave) {
        return clientes.stream()
                .filter(c -> c.getCorreo().equalsIgnoreCase(correo) && c.getClave().equals(clave))
                .findFirst()
                .orElse(null);
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
                .filter(r -> r.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    // Modificar datos del cliente
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
        return clientes.removeIf(c -> c.getCorreo().equalsIgnoreCase(correo));
    }
}

