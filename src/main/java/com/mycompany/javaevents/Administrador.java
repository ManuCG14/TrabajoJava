package com.mycompany.javaevents;

import java.io.Serializable;

public class Administrador extends Usuarios implements Serializable {

    public Administrador(String nombre, String correo, String clave) {
        super(nombre, correo, clave);
    }

    @Override
    public String toString() {
        return "Administrador: " + super.toString();
    }
}