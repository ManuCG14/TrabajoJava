package com.mycompany.javaevents;


import java.io.Serializable;

public class Clientes extends Usuarios implements Serializable {
    private String telefono;
    private Direccion direccion;
    private TarjetaCredito tarjeta;
    private boolean esVIP;

    public Clientes(String nombre, String correo, String clave, String telefono, Direccion direccion, TarjetaCredito tarjeta, boolean esVIP) {
        super(nombre, correo, clave);
        this.telefono = telefono;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        this.esVIP = esVIP;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    public boolean isEsVIP() {
        return esVIP;
    }

    public void setEsVIP(boolean esVIP) {
        this.esVIP = esVIP;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tel: " + telefono + ", VIP: " + esVIP;
    }
}

