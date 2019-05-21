package com.example.aranjuez.entidades;

public class Region {
    private String Id;
    private String Id_Area;
    private String Codigo;
    private String Nombre;
    private String Estado;

    public Region(String id, String id_Area, String codigo, String nombre, String estado) {
        Id = id;
        Id_Area = id_Area;
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

    public String getId_Area() {
        return Id_Area;
    }

    public void setId_Area(String id_Area) {
        Id_Area = id_Area;
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
