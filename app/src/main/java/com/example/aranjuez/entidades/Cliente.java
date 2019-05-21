package com.example.aranjuez.entidades;

public class Cliente {
    private String Id;
    private String Id_Supervisor;
    private String Id_Distribuidor;
    private String Id_Isscom;
    private String Id_Nivel_Socioeconomico;
    private String Id_Lista_De_Precios;
    private String Codigo;
    private String Codigo_SAP;
    private String Nombre;
    private String Direccion;
    private String Numero_De_Casa;
    private String Referencias;
    private String Telefono;
    private String Celular;
    private String CI_O_NIT;
    private String Razon_Social;
    private String Preventa;
    private String Latitud;
    private String Longitud;
    private String Estado;

    public Cliente(String id, String id_Supervisor, String id_Distribuidor, String id_Isscom, String id_Nivel_Socioeconomico, String id_Lista_De_Precios, String codigo, String codigo_SAP, String nombre, String direccion, String numero_De_Casa, String referencias, String telefono, String celular, String CI_O_NIT, String razon_Social, String preventa, String latitud, String longitud, String estado) {
        Id = id;
        Id_Supervisor = id_Supervisor;
        Id_Distribuidor = id_Distribuidor;
        Id_Isscom = id_Isscom;
        Id_Nivel_Socioeconomico = id_Nivel_Socioeconomico;
        Id_Lista_De_Precios = id_Lista_De_Precios;
        Codigo = codigo;
        Codigo_SAP = codigo_SAP;
        Nombre = nombre;
        Direccion = direccion;
        Numero_De_Casa = numero_De_Casa;
        Referencias = referencias;
        Telefono = telefono;
        Celular = celular;
        this.CI_O_NIT = CI_O_NIT;
        Razon_Social = razon_Social;
        Preventa = preventa;
        Latitud = latitud;
        Longitud = longitud;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Supervisor() {
        return Id_Supervisor;
    }

    public void setId_Supervisor(String id_Supervisor) {
        Id_Supervisor = id_Supervisor;
    }

    public String getId_Distribuidor() {
        return Id_Distribuidor;
    }

    public void setId_Distribuidor(String id_Distribuidor) {
        Id_Distribuidor = id_Distribuidor;
    }

    public String getId_Isscom() {
        return Id_Isscom;
    }

    public void setId_Isscom(String id_Isscom) {
        Id_Isscom = id_Isscom;
    }

    public String getId_Nivel_Socioeconomico() {
        return Id_Nivel_Socioeconomico;
    }

    public void setId_Nivel_Socioeconomico(String id_Nivel_Socioeconomico) {
        Id_Nivel_Socioeconomico = id_Nivel_Socioeconomico;
    }

    public String getId_Lista_De_Precios() {
        return Id_Lista_De_Precios;
    }

    public void setId_Lista_De_Precios(String id_Lista_De_Precios) {
        Id_Lista_De_Precios = id_Lista_De_Precios;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
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

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNumero_De_Casa() {
        return Numero_De_Casa;
    }

    public void setNumero_De_Casa(String numero_De_Casa) {
        Numero_De_Casa = numero_De_Casa;
    }

    public String getReferencias() {
        return Referencias;
    }

    public void setReferencias(String referencias) {
        Referencias = referencias;
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

    public String getPreventa() {
        return Preventa;
    }

    public void setPreventa(String preventa) {
        Preventa = preventa;
    }

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String latitud) {
        Latitud = latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    public void setLongitud(String longitud) {
        Longitud = longitud;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
