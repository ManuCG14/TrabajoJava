package JavaEventsApp;

import com.mycompany.javaevents.Clientes;
import com.mycompany.javaevents.Eventos;
import com.mycompany.javaevents.Reserva;
import com.mycompany.javaevents.PersistenciaDatos;
import interfazgrafica.VentanaLogin;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class JavaEventsApp {
    
    public static List<Clientes> listaClientes = new ArrayList<>();
    public static List<Eventos> listaEventos = new ArrayList<>();
    public static List<Reserva> listaReservas = new ArrayList<>();

    public static void main(String[] args) {
        // Cargar datos
        listaClientes = PersistenciaDatos.cargarClientes();
        listaEventos = PersistenciaDatos.cargarEventos();
        listaReservas = PersistenciaDatos.cargarReservas();

        // Lanzar GUI
        SwingUtilities.invokeLater(() -> {
            VentanaLogin login = new VentanaLogin();
            login.setVisible(true);
        });

        // Guardar datos al cerrar la aplicación
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            PersistenciaDatos.guardarClientes(listaClientes);
            PersistenciaDatos.guardarEventos(listaEventos);
            PersistenciaDatos.guardarReservas(listaReservas);
        }));
    }
}
}
