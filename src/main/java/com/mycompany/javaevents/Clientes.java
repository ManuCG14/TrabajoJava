package com.mycompany.javaevents;


public class Clientes extends Usuarios {
    
    private String nombre;
    private int telefono;
    private Direccion direccion;
    private TarjetaCredito tarjeta;
    private boolean VIP;

    public Clientes(String nombre, int telefono, boolean VIP, String correo, String clave, String calle, String numero, String ciudad, String codigo_postal, String numero16, String fecha_caducidad) {
        super(correo, clave);
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = new Direccion(calle, numero, ciudad, codigo_postal);
        this.tarjeta = new TarjetaCredito(nombre,numero16, fecha_caducidad);
        this.VIP = VIP;
    }

    

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }


    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String comprobar(boolean VIP){
        String esvip = "";
        if (VIP){
            esvip = "SI";}
        else{
            esvip = "NO";}
        return esvip;
    }

    @Override
    public String toString() {
        return "Cliente: /n" + 
               "Nombre=" + nombre + "/n" + 
               "telefono=" + telefono + "/n" +
               "direccion=" + direccion + "/n" +
               "tarjeta=" + tarjeta + "/n" +
               "VIP=" + comprobar(VIP);
    }

    
    
}
