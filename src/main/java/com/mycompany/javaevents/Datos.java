package com.mycompany.javaevents;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Datos {
    public static List<Usuarios> usuarios = new ArrayList<>();
    public static List<Eventos> eventos = new ArrayList<>();
    public static List<Reserva> reservas = new ArrayList<>();

    public static Usuarios usuarioActual;
    
    public static void guardar(String archivo, Object objeto) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(objeto);
        } catch (IOException e) {
            System.err.println("Error guardando " + archivo + ": " + e.getMessage());
        }
    }

    public static Object cargar(String archivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Archivo " + archivo + " no encontrado o vacío. Se creará nuevo.");
            return null;
        }
    }
}

