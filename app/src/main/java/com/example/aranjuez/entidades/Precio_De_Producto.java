package com.example.aranjuez.entidades;

public class Precio_De_Producto {
    private String Id;
    private String Id_Lista_De_Precios;
    private String Id_Producto;
    private String Id_Unidad_De_Medida;
    private String Precio;
    private String Porcentaje_De_Descuento;
    private String Estado;

    public Precio_De_Producto(String id, String id_Lista_De_Precios, String id_Producto, String id_Unidad_De_Medida, String precio, String porcentaje_De_Descuento, String estado) {
        Id = id;
        Id_Lista_De_Precios = id_Lista_De_Precios;
        Id_Producto = id_Producto;
        Id_Unidad_De_Medida = id_Unidad_De_Medida;
        Precio = precio;
        Porcentaje_De_Descuento = porcentaje_De_Descuento;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Lista_De_Precios() {
        return Id_Lista_De_Precios;
    }

    public void setId_Lista_De_Precios(String id_Lista_De_Precios) {
        Id_Lista_De_Precios = id_Lista_De_Precios;
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

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getPorcentaje_De_Descuento() {
        return Porcentaje_De_Descuento;
    }

    public void setPorcentaje_De_Descuento(String porcentaje_De_Descuento) {
        Porcentaje_De_Descuento = porcentaje_De_Descuento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
