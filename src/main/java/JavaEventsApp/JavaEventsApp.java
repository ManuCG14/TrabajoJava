package JavaEventsApp;

import com.mycompany.javaevents.*;
import interfaz.Principal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaEventsApp {

    private static List<Usuarios> usuarios = new ArrayList<>();
    private static List<Eventos> eventos = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();

    private static final String USUARIOS_FILE = "usuarios.dat";
    private static final String EVENTOS_FILE = "eventos.dat";
    private static final String RESERVAS_FILE = "reservas.dat";

    public static void main(String[] args) {
        // Cargar todos los datos (incluyendo clientes)
        cargarDatos();
        MetodosClientes.cargarClientes(); // <--- Cargar clientes aquí

        // Mostrar la interfaz principal
        Principal princ = new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);

        System.out.println("\nBienvenido a JavaEvents");
        System.out.println("Cargados: " + usuarios.size() + " usuarios, " + eventos.size() + " eventos y " + reservas.size() + " reservas.");

        // Agregar hook de guardado al cerrar la ventana
        princ.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                guardarDatos();
                MetodosClientes.guardarClientes(); // <--- Guardar clientes al cerrar
                System.out.println("Datos guardados correctamente.");
                System.exit(0);
            }
        });
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
            System.out.println("Guardado " + file + " con " + ((List<?>)data).size() + " elementos.");
        } catch (IOException e) {
            System.err.println("Error guardando " + file + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Object cargarObjeto(String file) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = in.readObject();
            System.out.println("Cargado " + file + " con " + ((List<?>)obj).size() + " elementos.");
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Archivo " + file + " no encontrado o vacío. Se creará nuevo.");
            return null;
        }
    }

    // Métodos para agregar, eliminar y modificar eventos usando la lista estática 'eventos'

    public static void agregarEvento(Eventos evento) {
        eventos.add(evento);
        System.out.println("Evento agregado: " + evento.getTitulo());
    }

    public static boolean eliminarEvento(String titulo) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                eventos.remove(i);
                System.out.println("Evento eliminado: " + titulo);
                return true;
            }
        }
        System.out.println("Evento no encontrado: " + titulo);
        return false;
    }

    public static boolean modificarEvento(String titulo, Eventos nuevoEvento) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                eventos.set(i, nuevoEvento);
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
