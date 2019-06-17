package com.example.aranjuez.entidades;

public class Detalle_De_PreventaVO {
    private String Id;
    private String Id_Preventa;
    private String CodigoSap;
    private String CodigoBarras;
    private String Producto;
    private String Cantidad;
    private String Precio_Unitario;
    private String Total;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Preventa() {
        return Id_Preventa;
    }

    public void setId_Preventa(String id_Preventa) {
        Id_Preventa = id_Preventa;
    }

    public String getCodigoSap() {
        return CodigoSap;
    }

    public void setCodigoSap(String codigoSap) {
        CodigoSap = codigoSap;
    }

    public String getCodigoBarras() {
        return CodigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        CodigoBarras = codigoBarras;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public String getPrecio_Unitario() {
        return Precio_Unitario;
    }

    public void setPrecio_Unitario(String precio_Unitario) {
        Precio_Unitario = precio_Unitario;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public Detalle_De_PreventaVO(String id, String id_Preventa, String codigoSap, String codigoBarras, String producto, String cantidad, String precio_Unitario, String total) {
        Id = id;
        Id_Preventa = id_Preventa;
        CodigoSap = codigoSap;
        CodigoBarras = codigoBarras;
        Producto = producto;
        Cantidad = cantidad;
        Precio_Unitario = precio_Unitario;
        Total = total;
    }
}
