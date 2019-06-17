package com.example.aranjuez.entidades;

public class Actividad_Economica {
    private String Id;
    private String Codigo;
    private String Descripcion;
    private String Estado;

    public Actividad_Economica(String id, String codigo, String descripcion, String estado) {
        Id = id;
        Codigo = codigo;
        Descripcion = descripcion;
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
}
