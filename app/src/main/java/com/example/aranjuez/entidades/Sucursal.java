package com.example.aranjuez.entidades;

public class Sucursal {
    private String Id;
    private String Id_Empresa;
    private String Numero;
    private String Direccion;
    private String Telefono;
    private String Municipio;
    private String Almacen;
    private String Almacen_De_Exportacion;
    private String Estado;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Empresa() {
        return Id_Empresa;
    }

    public void setId_Empresa(String id_Empresa) {
        Id_Empresa = id_Empresa;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    public String getAlmacen() {
        return Almacen;
    }

    public void setAlmacen(String almacen) {
        Almacen = almacen;
    }

    public String getAlmacen_De_Exportacion() {
        return Almacen_De_Exportacion;
    }

    public void setAlmacen_De_Exportacion(String almacen_De_Exportacion) {
        Almacen_De_Exportacion = almacen_De_Exportacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Sucursal(String id, String id_Empresa, String numero, String direccion, String telefono, String municipio, String almacen, String almacen_De_Exportacion, String estado) {
        Id = id;
        Id_Empresa = id_Empresa;
        Numero = numero;
        Direccion = direccion;
        Telefono = telefono;
        Municipio = municipio;
        Almacen = almacen;
        Almacen_De_Exportacion = almacen_De_Exportacion;
        Estado = estado;
    }
}
