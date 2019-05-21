package com.example.aranjuez.entidades;

public class Grupo_De_Unidad_De_Medida {
    private String Id;
    private String Id_Unidad_De_Medida_Base;
    private String Codigo;
    private String Nombre;
    private String Estado;

    public Grupo_De_Unidad_De_Medida(String id, String id_Unidad_De_Medida_Base, String codigo, String nombre, String estado) {
        Id = id;
        Id_Unidad_De_Medida_Base = id_Unidad_De_Medida_Base;
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

    public String getId_Unidad_De_Medida_Base() {
        return Id_Unidad_De_Medida_Base;
    }

    public void setId_Unidad_De_Medida_Base(String id_Unidad_De_Medida_Base) {
        Id_Unidad_De_Medida_Base = id_Unidad_De_Medida_Base;
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
