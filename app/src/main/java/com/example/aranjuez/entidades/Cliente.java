package com.example.aranjuez.entidades;

public class Cliente {
    private String Id;
    private String Id_Desarrollador;
    private String Id_Preventista;
    private String Id_Distribuidor;
    private String Id_Isscom;
    private String Id_Nivel_Socioeconomico;
    private String Id_Lista_De_Precios;
    private String Generico;
    private String Codigo_SAP;
    private String Codigo_Ruta;
    private String Nombre;
    private String CI_O_NIT;
    private String Razon_Social;
    private String Nombre_De_Referencia;
    private String Direccion;
    private String Referencia;
    private String Zona;
    private String Telefono;
    private String Celular;
    private String Preventa;
    private String Latitud;
    private String Longitud;
    private String Estado;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Desarrollador() {
        return Id_Desarrollador;
    }

    public void setId_Desarrollador(String id_Desarrollador) {
        Id_Desarrollador = id_Desarrollador;
    }

    public String getId_Preventista() {
        return Id_Preventista;
    }

    public void setId_Preventista(String id_Preventista) {
        Id_Preventista = id_Preventista;
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

    public String getGenerico() {
        return Generico;
    }

    public void setGenerico(String generico) {
        Generico = generico;
    }

    public String getCodigo_SAP() {
        return Codigo_SAP;
    }

    public void setCodigo_SAP(String codigo_SAP) {
        Codigo_SAP = codigo_SAP;
    }

    public String getCodigo_Ruta() {
        return Codigo_Ruta;
    }

    public void setCodigo_Ruta(String codigo_Ruta) {
        Codigo_Ruta = codigo_Ruta;
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

    public String getNombre_De_Referencia() {
        return Nombre_De_Referencia;
    }

    public void setNombre_De_Referencia(String nombre_De_Referencia) {
        Nombre_De_Referencia = nombre_De_Referencia;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

    public String getZona() {
        return Zona;
    }

    public void setZona(String zona) {
        Zona = zona;
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

    public Cliente(String id, String id_Desarrollador, String id_Preventista, String id_Distribuidor, String id_Isscom, String id_Nivel_Socioeconomico, String id_Lista_De_Precios, String generico, String codigo_SAP, String codigo_Ruta, String nombre, String CI_O_NIT, String razon_Social, String nombre_De_Referencia, String direccion, String referencia, String zona, String telefono, String celular, String preventa, String latitud, String longitud, String estado) {
        Id = id;
        Id_Desarrollador = id_Desarrollador;
        Id_Preventista = id_Preventista;
        Id_Distribuidor = id_Distribuidor;
        Id_Isscom = id_Isscom;
        Id_Nivel_Socioeconomico = id_Nivel_Socioeconomico;
        Id_Lista_De_Precios = id_Lista_De_Precios;
        Generico = generico;
        Codigo_SAP = codigo_SAP;
        Codigo_Ruta = codigo_Ruta;
        Nombre = nombre;
        this.CI_O_NIT = CI_O_NIT;
        Razon_Social = razon_Social;
        Nombre_De_Referencia = nombre_De_Referencia;
        Direccion = direccion;
        Referencia = referencia;
        Zona = zona;
        Telefono = telefono;
        Celular = celular;
        Preventa = preventa;
        Latitud = latitud;
        Longitud = longitud;
        Estado = estado;
    }
}
