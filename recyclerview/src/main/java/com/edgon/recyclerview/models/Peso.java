package com.edgon.recyclerview.models;

/**
 * Created by gonza on 7/17/2017.
 */

public class Peso {
    private String fecha;
    private String peso;

    public Peso() {
    }

    public Peso(String fecha, String peso) {
        this.fecha = fecha;
        this.peso = peso;
    }

   public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}
