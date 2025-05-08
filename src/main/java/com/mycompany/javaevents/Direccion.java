package com.mycompany.javaevents;

public class Direccion {
    
    private String calle;
    private String numero;
    private String ciudad;
    private String codigo_postal;

    public Direccion(String calle, String numero, String ciudad, String codigo_postal) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Override
    public String toString() {
        return "Dirrecion{" + "calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + ", codigo_postal=" + codigo_postal + '}';
    }

}
