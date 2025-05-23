package com.mycompany.javaevents;

import java.util.List;
import java.util.stream.Collectors;

public class MetodosClientes {

    public static List<Eventos> buscarPorTipo(List<Eventos> eventos, TipoEvento tipo) {
        return eventos.stream()
                .filter(e -> e.getTipo() == tipo)
                .collect(Collectors.toList());
    }

    public static List<Eventos> buscarPorCiudad(List<Eventos> eventos, String ciudad) {
        return eventos.stream()
                .filter(e -> e.getDireccion().getCiudad().equalsIgnoreCase(ciudad))
                .collect(Collectors.toList());
    }
    
    public static List<Eventos> buscarPorCiudadYTipo(List<Eventos> lista, String ciudad, TipoEvento tipo) {
        return lista.stream()
                .filter(e -> e.getDireccion().getCiudad().equalsIgnoreCase(ciudad)
                        && e.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    public static void dejarReseña(Eventos evento, int nota, String comentario) {
        evento.añadirReseña(new Reseña(nota, comentario));
    }
}