package com.mycompany.javaevents;

import java.io.*;
import java.util.List;
public class GestorFicheros {
    public static <T> void guardarDatos(List<T> lista, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> cargarDatos(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar " + rutaArchivo + ": " + e.getMessage());
            return new java.util.ArrayList<>();
        }
    }
}
