package com.example.aranjuez.entidades;

public class Detalle_De_Preventa {
    private String Id;
    private String Id_Preventa;
    private String Id_Producto;
    private String Cantidad;
    private String Precio_Unitario;
    private String Total;
    private String Precio_Unitario_Menos_ICE;
    private String Total_Menos_ICE;
    private String Descuento;
    private String Porcentaje_De_Descuento;
    private String IVA;
    private String ICE;
    private String Litros;
    private String Estado;

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

    public String getId_Producto() {
        return Id_Producto;
    }

    public void setId_Producto(String id_Producto) {
        Id_Producto = id_Producto;
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

    public String getPrecio_Unitario_Menos_ICE() {
        return Precio_Unitario_Menos_ICE;
    }

    public void setPrecio_Unitario_Menos_ICE(String precio_Unitario_Menos_ICE) {
        Precio_Unitario_Menos_ICE = precio_Unitario_Menos_ICE;
    }

    public String getTotal_Menos_ICE() {
        return Total_Menos_ICE;
    }

    public void setTotal_Menos_ICE(String total_Menos_ICE) {
        Total_Menos_ICE = total_Menos_ICE;
    }

    public String getDescuento() {
        return Descuento;
    }

    public void setDescuento(String descuento) {
        Descuento = descuento;
    }

    public String getPorcentaje_De_Descuento() {
        return Porcentaje_De_Descuento;
    }

    public void setPorcentaje_De_Descuento(String porcentaje_De_Descuento) {
        Porcentaje_De_Descuento = porcentaje_De_Descuento;
    }

    public String getIVA() {
        return IVA;
    }

    public void setIVA(String IVA) {
        this.IVA = IVA;
    }

    public String getICE() {
        return ICE;
    }

    public void setICE(String ICE) {
        this.ICE = ICE;
    }

    public String getLitros() {
        return Litros;
    }

    public void setLitros(String litros) {
        Litros = litros;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Detalle_De_Preventa(String id, String id_Preventa, String id_Producto, String cantidad, String precio_Unitario, String total, String precio_Unitario_Menos_ICE, String total_Menos_ICE, String descuento, String porcentaje_De_Descuento, String IVA, String ICE, String litros, String estado) {
        Id = id;
        Id_Preventa = id_Preventa;
        Id_Producto = id_Producto;
        Cantidad = cantidad;
        Precio_Unitario = precio_Unitario;
        Total = total;
        Precio_Unitario_Menos_ICE = precio_Unitario_Menos_ICE;
        Total_Menos_ICE = total_Menos_ICE;
        Descuento = descuento;
        Porcentaje_De_Descuento = porcentaje_De_Descuento;
        this.IVA = IVA;
        this.ICE = ICE;
        Litros = litros;
        Estado = estado;
    }
}
