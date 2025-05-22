package com.mycompany.javaevents;

import java.io.Serializable;

public abstract class Usuarios implements Serializable {
    private String nombre;
    private String correo;
    private String clave;

    public Usuarios(String nombre, String correo, String clave) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return nombre + " (" + correo + ")";
    }
}

