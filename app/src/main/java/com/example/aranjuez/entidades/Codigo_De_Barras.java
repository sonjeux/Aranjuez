package com.example.aranjuez.entidades;

public class Codigo_De_Barras {
    private String Id;
    private String Id_Producto;
    private String Id_Unidad_De_Medida;
    private String Codigo_De_Barras;
    private String Estado;

    public Codigo_De_Barras(String id, String id_Producto, String id_Unidad_De_Medida, String codigo_De_Barras, String estado) {
        Id = id;
        Id_Producto = id_Producto;
        Id_Unidad_De_Medida = id_Unidad_De_Medida;
        Codigo_De_Barras = codigo_De_Barras;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getCodigo_De_Barras() {
        return Codigo_De_Barras;
    }

    public void setCodigo_De_Barras(String codigo_De_Barras) {
        Codigo_De_Barras = codigo_De_Barras;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
