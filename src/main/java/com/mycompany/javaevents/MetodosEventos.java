/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaevents;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MetodosEventos {
        
    private static List<Eventos> listaEventos = new ArrayList<>();

    public static List<Eventos> getListaEventos() {
        return listaEventos;
    }

    public static boolean agregarEvento(Eventos evento) {
        Optional<Eventos> existente = listaEventos.stream()
                .filter(e -> e.getTitulo().equalsIgnoreCase(evento.getTitulo()))
                .findFirst();
        if (existente.isPresent()) return false;
        listaEventos.add(evento);
        return true;
    }

    public static boolean editarEvento(String tituloAntiguo, Eventos eventoActualizado) {
        for (int i = 0; i < listaEventos.size(); i++) {
            if (listaEventos.get(i).getTitulo().equalsIgnoreCase(tituloAntiguo)) {
                listaEventos.set(i, eventoActualizado);
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarEvento(String titulo) {
        return listaEventos.removeIf(e -> e.getTitulo().equalsIgnoreCase(titulo));
    }

    public static Eventos buscarEventoPorTitulo(String titulo) {
        return listaEventos.stream()
                .filter(e -> e.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }
}
