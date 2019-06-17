package com.example.aranjuez.entidades;

public class Supervisor {
    private String Id;
    private String Nombre;
    private String Estado;

    public Supervisor(String id, String nombre, String estado) {
        Id = id;
        Nombre = nombre;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
