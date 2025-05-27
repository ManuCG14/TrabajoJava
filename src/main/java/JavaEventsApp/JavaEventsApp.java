package JavaEventsApp;

import com.mycompany.javaevents.*;
import static com.mycompany.javaevents.Datos.eventos;
import static com.mycompany.javaevents.Datos.reservas;
import interfaz.Principal;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class JavaEventsApp {

    public static Clientes clienteLogueado ;


    public static void main(String[] args) {
        // Cargar datos
    Datos.eventos = GestorFicheros.cargarDatos("eventos.dat");
    Datos.usuarios = GestorFicheros.cargarDatos("usuarios.dat");
    Datos.reservas = GestorFicheros.cargarDatos("reservas.dat");

    // Crear cliente de prueba si no hay clientes
    if (Datos.usuarios == null || Datos.usuarios.isEmpty()) {
        Datos.usuarios = new java.util.ArrayList<>();
        Clientes clientePrueba = new Clientes("cliente@correo.com", "1234", "Cliente Prueba");
        Datos.usuarios.add(clientePrueba);
        System.out.println("Cliente de prueba registrado automáticamente: cliente@correo.com / 1234");
    }

    // Guardar al cerrar
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        GestorFicheros.guardarDatos(Datos.eventos, "eventos.dat");
        GestorFicheros.guardarDatos(Datos.reservas, "reservas.dat");
        GestorFicheros.guardarDatos(Datos.usuarios, "usuarios.dat");
        System.out.println("Datos guardados correctamente.");
    }));

    // Mostrar ventana principal
    Principal princ = new Principal();
    princ.setVisible(true);
    princ.setLocationRelativeTo(null);

    System.out.println("\nBienvenido a JavaEvents");
    System.out.println("Cargados: " + Datos.usuarios.size() + " usuarios, " + Datos.eventos.size() + " eventos y " + Datos.reservas.size() + " reservas.");
}

    @SuppressWarnings("unchecked")

    public static List<Eventos> getEventos() {
        return eventos;
    }

    public static List<Reserva> getReservas() {
        return reservas;
    }
}

