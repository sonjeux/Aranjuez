package com.example.aranjuez.entidades;

public class Dosificacion {
    private String Id;
    private String Id_Sucursal;
    private String Id_Actividad_Economica;
    private String Numero_De_Autorizacion;
    private String Caracteristicas;
    private String Fecha_Limite_De_Emision;
    private String Leyenda;
    private String Llave;
    private String Estado;

    public Dosificacion(String id, String id_Sucursal, String id_Actividad_Economica, String numero_De_Autorizacion, String caracteristicas, String fecha_Limite_De_Emision, String leyenda, String llave, String estado) {
        Id = id;
        Id_Sucursal = id_Sucursal;
        Id_Actividad_Economica = id_Actividad_Economica;
        Numero_De_Autorizacion = numero_De_Autorizacion;
        Caracteristicas = caracteristicas;
        Fecha_Limite_De_Emision = fecha_Limite_De_Emision;
        Leyenda = leyenda;
        Llave = llave;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Sucursal() {
        return Id_Sucursal;
    }

    public void setId_Sucursal(String id_Sucursal) {
        Id_Sucursal = id_Sucursal;
    }

    public String getId_Actividad_Economica() {
        return Id_Actividad_Economica;
    }

    public void setId_Actividad_Economica(String id_Actividad_Economica) {
        Id_Actividad_Economica = id_Actividad_Economica;
    }

    public String getNumero_De_Autorizacion() {
        return Numero_De_Autorizacion;
    }

    public void setNumero_De_Autorizacion(String numero_De_Autorizacion) {
        Numero_De_Autorizacion = numero_De_Autorizacion;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        Caracteristicas = caracteristicas;
    }

    public String getFecha_Limite_De_Emision() {
        return Fecha_Limite_De_Emision;
    }

    public void setFecha_Limite_De_Emision(String fecha_Limite_De_Emision) {
        Fecha_Limite_De_Emision = fecha_Limite_De_Emision;
    }

    public String getLeyenda() {
        return Leyenda;
    }

    public void setLeyenda(String leyenda) {
        Leyenda = leyenda;
    }

    public String getLlave() {
        return Llave;
    }

    public void setLlave(String llave) {
        Llave = llave;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
