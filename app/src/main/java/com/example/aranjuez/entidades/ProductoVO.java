package com.example.aranjuez.entidades;

public class ProductoVO {
    private String Id;
    private String Codigo_SAP;
    private String Codigo_Barras;
    private String Nombre;
    private String Capacidad_En_Litros;
    private String Precio;

    public ProductoVO(String id, String codigo_SAP, String codigo_Barras, String nombre, String capacidad_En_Litros, String precio) {
        Id = id;
        Codigo_SAP = codigo_SAP;
        Codigo_Barras = codigo_Barras;
        Nombre = nombre;
        Capacidad_En_Litros = capacidad_En_Litros;
        Precio = precio;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCodigo_SAP() {
        return Codigo_SAP;
    }

    public void setCodigo_SAP(String codigo_SAP) {
        Codigo_SAP = codigo_SAP;
    }

    public String getCodigo_Barras() {
        return Codigo_Barras;
    }

    public void setCodigo_Barras(String codigo_Barras) {
        Codigo_Barras = codigo_Barras;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCapacidad_En_Litros() {
        return Capacidad_En_Litros;
    }

    public void setCapacidad_En_Litros(String capacidad_En_Litros) {
        Capacidad_En_Litros = capacidad_En_Litros;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }
}
