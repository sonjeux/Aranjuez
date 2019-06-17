package com.example.aranjuez.entidades;

public class Distribuidor {
    private String Id;
    private String Id_Region;
    private String Tipo;
    private String Codigo;
    private String SlpCode;
    private String SlpName;
    private String Estado;

    public Distribuidor(String id, String id_Region, String tipo, String codigo, String slpCode, String slpName, String estado) {
        Id = id;
        Id_Region = id_Region;
        Tipo = tipo;
        Codigo = codigo;
        SlpCode = slpCode;
        SlpName = slpName;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Region() {
        return Id_Region;
    }

    public void setId_Region(String id_Region) {
        Id_Region = id_Region;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getSlpCode() {
        return SlpCode;
    }

    public void setSlpCode(String slpCode) {
        SlpCode = slpCode;
    }

    public String getSlpName() {
        return SlpName;
    }

    public void setSlpName(String slpName) {
        SlpName = slpName;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
