package com.mycompany.javaevents;

import java.io.Serializable;

public class Reseña implements Serializable {
    private int nota;
    private String comentario;

    public Reseña(int nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }
}
