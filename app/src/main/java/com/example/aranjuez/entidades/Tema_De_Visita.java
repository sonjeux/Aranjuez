package com.example.aranjuez.entidades;

public class Tema_De_Visita {
    private String Id;
    private String Descripcion;
    private String Estado;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Tema_De_Visita(String id, String descripcion, String estado) {
        Id = id;
        Descripcion = descripcion;
        Estado = estado;
    }
}
