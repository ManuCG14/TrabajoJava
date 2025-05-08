package com.mycompany.javaevents;

public class TarjetaCredito {
    
    private String nombre;
    private String numero16;
    private String fecha_caducidad;

    public TarjetaCredito(String nombre, String numero16, String fecha_caducidad) {
        this.nombre = nombre;
        this.numero16 = numero16;
        this.fecha_caducidad = fecha_caducidad;
    }
    
    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }


    public String getNumero16() {
        return numero16;
    }

    public void setNumero16(String numero16) {
        this.numero16 = numero16;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" + "nombre=" + nombre + ", numero16=" + numero16 + ", fecha_caducidad=" + fecha_caducidad + '}';
    }
}
