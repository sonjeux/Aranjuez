package com.example.aranjuez.entidades;

public class Isscom {
    private String Id;
    private String Codigo;
    private String Canal;
    private String Descripcion;
    private String Estado;

    public Isscom(String id, String codigo, String canal, String descripcion, String estado) {
        Id = id;
        Codigo = codigo;
        Canal = canal;
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

    public String getCanal() {
        return Canal;
    }

    public void setCanal(String canal) {
        Canal = canal;
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
