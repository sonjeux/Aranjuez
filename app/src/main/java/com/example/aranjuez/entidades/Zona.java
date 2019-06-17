package com.example.aranjuez.entidades;

public class Zona {
    private String Id;
    private String Codigo;
    private String Nombre;
    private String Estado;

    public Zona(String id, String codigo, String nombre, String estado) {
        Id = id;
        Codigo = codigo;
        Nombre = nombre;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
