package com.mycompany.javaevents;

public abstract class Usuarios {
    
    private String correo;
    private String clave;

    public Usuarios(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "correo=" + correo + ", clave=" + clave + '}';
    }

    
}
