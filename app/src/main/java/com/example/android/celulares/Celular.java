package com.example.android.celulares;

/**
 * Created by android on 30/09/2017.
 */

public class Celular {

    private int marca;
    private int precio;
    private int color;
    private int capacidad;
    private int sistema;

    public Celular(int marca, int precio, int color, int capacidad, int sistema) {
        this.marca = marca;
        this.precio = precio;
        this.color = color;
        this.capacidad = capacidad;
        this.sistema = sistema;
    }

    public int getSistema() {
        return sistema;
    }

    public int getMarca() {
        return marca;
    }

    public int getPrecio() {
        return precio;
    }

    public int getColor() {
        return color;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setSistema(int sistema) {
        this.sistema = sistema;
    }

    public void guardar(){
        Datos.guardarCelulares(this);

    }
}
