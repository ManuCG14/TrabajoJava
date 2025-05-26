package JavaEventsApp;

import com.mycompany.javaevents.*;
import interfaz.Principal;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
        MetodosClientes.cargarClientes(); // <--- Cargar clientes aquí si es necesario

        // Mostrar la interfaz principal
        Principal princ = new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);

        System.out.println("\nBienvenido a JavaEvents");
        System.out.println("Cargados: " + usuarios.size() + " usuarios, " + eventos.size() + " eventos y " + reservas.size() + " reservas.");

        // Agregar hook de guardado al cerrar la ventana
        princ.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                guardarDatos();
                MetodosClientes.guardarClientes(); // <--- Guardar clientes si aplica
                System.out.println("Datos guardados correctamente.");
                System.exit(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private static void cargarDatos() {
        Object u = Datos.cargar(USUARIOS_FILE);
        Object e = Datos.cargar(EVENTOS_FILE);
        Object r = Datos.cargar(RESERVAS_FILE);

        if (u != null) usuarios = (List<Usuarios>) u;
        if (e != null) eventos = (List<Eventos>) e;
        if (r != null) reservas = (List<Reserva>) r;
    }

    private static void guardarDatos() {
        Datos.guardar(USUARIOS_FILE, usuarios);
        Datos.guardar(EVENTOS_FILE, eventos);
        Datos.guardar(RESERVAS_FILE, reservas);
    }

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
