package com.mycompany.javaevents;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaEventsClass {

    private static List<Clientes> clientes = new ArrayList<>();
    private static List<Eventos> eventos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido a JavaEvents");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    registrarCliente();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }
    }

    private static void iniciarSesion() {
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Clave: ");
        String clave = sc.nextLine();

        if (correo.equals(admin.getCorreo()) && clave.equals(admin.getClave())) {
            menuAdministrador();
        } else {
            Clientes cliente = buscarCliente(correo, clave);
            if (cliente != null) {
                menuCliente(cliente);
            } else {
                System.out.println("Usuario o clave incorrectos");
            }
        }
    }

    private static void registrarCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Clave: ");
        String clave = sc.nextLine();
        System.out.print("Teléfono: ");
        int telefono = sc.nextInt();
        System.out.print("Calle: ");
        String calle = sc.nextLine();
        System.out.print("Número: ");
        String numero = sc.nextLine();
        sc.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = sc.nextLine();
        System.out.print("Código Postal: ");
        String codigo_postal = sc.nextLine();
        System.out.print("Nombre Titular Tarjeta: ");
        String titular = sc.nextLine();
        System.out.print("Número Tarjeta (16 dígitos): ");
        String numero16 = sc.nextLine();
        System.out.print("Fecha caducidad (MM/AA): ");
        String fecha_caducidad = sc.nextLine();
        System.out.print("¿Es VIP? (true/false): ");
        boolean vip = sc.nextBoolean();
        sc.nextLine(); // Limpiar buffer

        Direccion direccion = new Direccion(calle, numero, ciudad, codigo_postal);
        TarjetaCredito tarjeta = new TarjetaCredito(titular, numero16 , fecha_caducidad);

        Clientes nuevoCliente = new Clientes(nombre, telefono, vip, correo, clave, calle, numero, ciudad, codigo_postal, numero16, fecha_caducidad);
        clientes.add(nuevoCliente);

        System.out.println("¡Registro exitoso!");
    }

    private static Clientes buscarCliente(String correo, String clave) {
        for (Clientes c : clientes) {
            if (c.getCorreo().equals(correo) && c.getClave().equals(clave)) {
                return c;
            }
        }
        return null;
    }

    private static void menuAdministrador() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Crear evento");
            System.out.println("2. Ver eventos");
            System.out.println("3. Cerrar sesión");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearEvento();
                    break;
                case 2:
                    listarEventos();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }
    }

    private static void crearEvento() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Tipo (CONCIERTO, DEPORTE, MUSICAL, TEATRO): ");
        TipoEvento tipo = TipoEvento.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Calle: ");
        String calle = sc.nextLine();
        System.out.print("Número: ");
        String numero = sc.nextLine();
        sc.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = sc.nextLine();
        System.out.print("Código Postal: ");
        String codigoPostal = sc.nextLine();
        System.out.print("Precio entrada: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        System.out.print("Imagen portada: ");
        String imagen = sc.nextLine();

        Direccion direccion = new Direccion(calle, numero, ciudad, codigoPostal);
        Eventos evento = new Eventos(titulo, tipo, direccion, precio, imagen);

        System.out.print("¿Cuántas fechas tiene este evento?: ");
        int nFechas = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < nFechas; i++) {
            System.out.print("Fecha (YYYY-MM-DD): ");
            String fecha = sc.nextLine();
            System.out.print("Hora (HH:MM): ");
            String hora = sc.nextLine();
            evento.addFechaHora(new FechaHora(
                java.time.LocalDate.parse(fecha),
                java.time.LocalTime.parse(hora)
            ));
        }

        eventos.add(evento);
        System.out.println("Evento creado exitosamente.");
    }

    private static void listarEventos() {
        for (Eventos e : eventos) {
            System.out.println(e);
        }
    }

    private static void menuCliente(Clientes cliente) {
        System.out.println("Bienvenido Cliente!");
        listarEventos();
    }
}
