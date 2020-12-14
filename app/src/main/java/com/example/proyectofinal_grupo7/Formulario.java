package com.example.proyectofinal_grupo7;

public class Formulario {
    private String nombre, mes;
    private int id, anio, estado;

    public Formulario() {
    }

    public Formulario(String nombre, String mes, int anio, int estado) {
        this.nombre = nombre;
        this.mes = mes;
        this.anio = anio;
        this.estado = estado;
    }

    public Formulario(String nombre, String mes, int id, int anio, int estado) {
        this.nombre = nombre;
        this.mes = mes;
        this.id = id;
        this.anio = anio;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
