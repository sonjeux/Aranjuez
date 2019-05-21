package com.example.aranjuez.entidades;

public class Unidad_De_Medida_De_Producto {
    private String Id;
    private String Id_Actividad_Economica;
    private String Id_Producto;
    private String Id_Unidad_De_Medida;
    private String Tipo;
    private String Estado;

    public Unidad_De_Medida_De_Producto(String id, String id_Actividad_Economica, String id_Producto, String id_Unidad_De_Medida, String tipo, String estado) {
        Id = id;
        Id_Actividad_Economica = id_Actividad_Economica;
        Id_Producto = id_Producto;
        Id_Unidad_De_Medida = id_Unidad_De_Medida;
        Tipo = tipo;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Actividad_Economica() {
        return Id_Actividad_Economica;
    }

    public void setId_Actividad_Economica(String id_Actividad_Economica) {
        Id_Actividad_Economica = id_Actividad_Economica;
    }

    public String getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(String id_Producto) {
        Id_Producto = id_Producto;
    }

    public String getId_Unidad_De_Medida() {
        return Id_Unidad_De_Medida;
    }

    public void setId_Unidad_De_Medida(String id_Unidad_De_Medida) {
        Id_Unidad_De_Medida = id_Unidad_De_Medida;
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
