package JavaEventsApp;

import com.mycompany.javaevents.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaEventsApp {

    private static List<Usuarios> usuarios = new ArrayList<>();
    private static List<Eventos> eventos = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    private List<Eventos> listaEventos = new ArrayList<>();

    private static final String USUARIOS_FILE = "usuarios.dat";
    private static final String EVENTOS_FILE = "eventos.dat";
    private static final String RESERVAS_FILE = "reservas.dat";

    public static void main(String[] args) {
        cargarDatos();

        // Aquí irá el arranque de la interfaz gráfica o consola
        System.out.println("\nBienvenido a JavaEvents");
        System.out.println("Cargados: " + usuarios.size() + " usuarios, " + eventos.size() + " eventos y " + reservas.size() + " reservas.");

        guardarDatos();
    }

    @SuppressWarnings("unchecked")
    private static void cargarDatos() {
        usuarios = (List<Usuarios>) cargarObjeto(USUARIOS_FILE);
        eventos = (List<Eventos>) cargarObjeto(EVENTOS_FILE);
        reservas = (List<Reserva>) cargarObjeto(RESERVAS_FILE);

        if (usuarios == null) usuarios = new ArrayList<>();
        if (eventos == null) eventos = new ArrayList<>();
        if (reservas == null) reservas = new ArrayList<>();
    }

    private static void guardarDatos() {
        guardarObjeto(USUARIOS_FILE, usuarios);
        guardarObjeto(EVENTOS_FILE, eventos);
        guardarObjeto(RESERVAS_FILE, reservas);
    }

    private static void guardarObjeto(String file, Object data) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(data);
        } catch (IOException e) {
            System.err.println("Error guardando " + file + ": " + e.getMessage());
        }
    }

    private static Object cargarObjeto(String file) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Archivo " + file + " no encontrado o vacío. Se creará nuevo.");
            return null;
        }
    }
    
    // Agregar evento
public void agregarEvento(Eventos evento) {
    listaEventos.add(evento);
    System.out.println("Evento agregado: " + evento.getTitulo());
}

// Eliminar evento por título
public boolean eliminarEvento(String titulo) {
    for (int i = 0; i < listaEventos.size(); i++) {
        if (listaEventos.get(i).getTitulo().equalsIgnoreCase(titulo)) {
            listaEventos.remove(i);
            System.out.println("Evento eliminado: " + titulo);
            return true;
        }
    }
    System.out.println("Evento no encontrado: " + titulo);
    return false;
}

// Modificar evento por título (sustituye por el nuevo)
public boolean modificarEvento(String titulo, Eventos nuevoEvento) {
    for (int i = 0; i < listaEventos.size(); i++) {
        if (listaEventos.get(i).getTitulo().equalsIgnoreCase(titulo)) {
            listaEventos.set(i, nuevoEvento);
            System.out.println("Evento modificado: " + titulo);
            return true;
        }
    }
    System.out.println("Evento no encontrado para modificar: " + titulo);
    return false;
}

    public static List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public static List<Eventos> getEventos() {
        return eventos;
    }

    public static List<Reserva> getReservas() {
        return reservas;
    }
}
