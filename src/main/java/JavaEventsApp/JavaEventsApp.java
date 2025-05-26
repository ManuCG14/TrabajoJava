package JavaEventsApp;

import com.mycompany.javaevents.*;
import interfaz.Principal;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class JavaEventsApp {

    public static Clientes clienteLogueado = null;
    private static List<Eventos> eventos = new java.util.ArrayList<>();
    private static List<Reserva> reservas = new java.util.ArrayList<>();

    private static final String EVENTOS_FILE = "eventos.dat";
    private static final String RESERVAS_FILE = "reservas.dat";

    public static void main(String[] args) {
        // Cargar eventos y reservas
        cargarDatos();

        // Cargar clientes desde archivo usando la clase MetodosClientes
        MetodosClientes.cargarClientes();

        // Si no hay clientes cargados, crear un cliente de prueba automáticamente
        if (MetodosClientes.getClientes().isEmpty()) {
            Clientes clientePrueba = new Clientes("cliente@correo.com", "1234", "Cliente Prueba");
            MetodosClientes.registrarCliente(clientePrueba);
            MetodosClientes.guardarClientes();
            System.out.println("Cliente de prueba registrado automáticamente: cliente@correo.com / 1234");
        }

        // Mostrar la interfaz gráfica principal
        Principal princ = new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);

        System.out.println("\nBienvenido a JavaEvents");
        System.out.println("Cargados: " + MetodosClientes.getClientes().size() + " clientes, " + eventos.size() + " eventos y " + reservas.size() + " reservas.");

        // Añadir listener para guardar datos al cerrar la ventana principal
        princ.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                guardarDatos();
                MetodosClientes.guardarClientes();
                System.out.println("Datos guardados correctamente.");
                System.exit(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private static void cargarDatos() {
        Object e = Datos.cargar(EVENTOS_FILE);
        Object r = Datos.cargar(RESERVAS_FILE);

        if (e != null) eventos = (List<Eventos>) e;
        if (r != null) reservas = (List<Reserva>) r;
    }

    private static void guardarDatos() {
        Datos.guardar(EVENTOS_FILE, eventos);
        Datos.guardar(RESERVAS_FILE, reservas);
    }

    public static List<Eventos> getEventos() {
        return eventos;
    }

    public static List<Reserva> getReservas() {
        return reservas;
    }
}

