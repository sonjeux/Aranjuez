package com.example.aranjuez.entidades;

public class Area {
    private String Id;
    private String Id_Zona;
    private String Codigo;
    private String Nombre;
    private String Estado;

    public Area(String id, String id_Zona, String codigo, String nombre, String estado) {
        Id = id;
        Id_Zona = id_Zona;
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

    public String getId_Zona() {
        return Id_Zona;
    }

    public void setId_Zona(String id_Zona) {
        Id_Zona = id_Zona;
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
