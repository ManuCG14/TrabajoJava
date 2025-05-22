package com.mycompany.javaevents;

import java.io.Serializable;

public class TarjetaCredito implements Serializable {
    private String titular;
    private String numero;
    private String fechaCaducidad;

    public TarjetaCredito(String titular, String numero, String fechaCaducidad) {
        this.titular = titular;
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Titular: " + titular + ", Número: " + numero + ", Caduca: " + fechaCaducidad;
    }
}
