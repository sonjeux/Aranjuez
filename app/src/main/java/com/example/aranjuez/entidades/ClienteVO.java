package com.example.aranjuez.entidades;

public class ClienteVO {
    private String Id;
    private String Codigo_SAP;
    private String Nombre;
    private String CI_O_NIT;
    private String Razon_Social;
    private String Direccion;
    private String Telefono;
    private String Celular;
    private String Estado;

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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCI_O_NIT() {
        return CI_O_NIT;
    }

    public void setCI_O_NIT(String CI_O_NIT) {
        this.CI_O_NIT = CI_O_NIT;
    }

    public String getRazon_Social() {
        return Razon_Social;
    }

    public void setRazon_Social(String razon_Social) {
        Razon_Social = razon_Social;
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

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public ClienteVO(String id, String codigo_SAP, String nombre, String CI_O_NIT, String razon_Social, String direccion, String telefono, String celular, String estado) {
        Id = id;
        Codigo_SAP = codigo_SAP;
        Nombre = nombre;
        this.CI_O_NIT = CI_O_NIT;
        Razon_Social = razon_Social;
        Direccion = direccion;
        Telefono = telefono;
        Celular = celular;
        Estado = estado;
    }
}
