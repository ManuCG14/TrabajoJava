package com.mycompany.javaevents;

import java.io.Serializable;

public class Administrador extends Usuarios implements Serializable {

    public static final String ADMIN_CORREO = "admin@javaevents.com";
    public static final String ADMIN_CLAVE = "admin";

    public Administrador(String nombre, String correo, String clave) {
        super(nombre, correo, clave);
    }

    public static boolean esAdministrador(String correo, String clave) {
        return ADMIN_CORREO.equalsIgnoreCase(correo) && ADMIN_CLAVE.equals(clave);
    }
}