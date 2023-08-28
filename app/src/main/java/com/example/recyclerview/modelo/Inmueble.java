package com.example.recyclerview.modelo;

public class Inmueble {

    private String direccion;
    private double precion;

    private String url;

    public Inmueble(String direccion, double precion, String url) {
        this.direccion = direccion;
        this.precion = precion;
        this.url = url;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecion() {
        return precion;
    }

    public void setPrecion(double precion) {
        this.precion = precion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
