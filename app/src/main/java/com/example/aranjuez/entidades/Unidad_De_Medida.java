package com.example.aranjuez.entidades;

public class Unidad_De_Medida {
    private String Id;
    private String UomEntry;
    private String Codigo;
    private String Nombre;
    private String Tipo;
    private String Estado;

    public Unidad_De_Medida(String id, String uomEntry, String codigo, String nombre, String tipo, String estado) {
        Id = id;
        UomEntry = uomEntry;
        Codigo = codigo;
        Nombre = nombre;
        Tipo = tipo;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUomEntry() {
        return UomEntry;
    }

    public void setUomEntry(String uomEntry) {
        UomEntry = uomEntry;
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

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
