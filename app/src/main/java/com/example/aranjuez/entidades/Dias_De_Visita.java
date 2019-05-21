package com.example.aranjuez.entidades;

public class Dias_De_Visita {
    private String Id;
    private String Id_Cliente;
    private String Tipo;
    private String Lunes;
    private String Martes;
    private String Miercoles;
    private String Jueves;
    private String Viernes;
    private String Sabado;
    private String Domingo;

    public Dias_De_Visita(String id, String id_Cliente, String tipo, String lunes, String martes, String miercoles, String jueves, String viernes, String sabado, String domingo) {
        Id = id;
        Id_Cliente = id_Cliente;
        Tipo = tipo;
        Lunes = lunes;
        Martes = martes;
        Miercoles = miercoles;
        Jueves = jueves;
        Viernes = viernes;
        Sabado = sabado;
        Domingo = domingo;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getLunes() {
        return Lunes;
    }

    public void setLunes(String lunes) {
        Lunes = lunes;
    }

    public String getMartes() {
        return Martes;
    }

    public void setMartes(String martes) {
        Martes = martes;
    }

    public String getMiercoles() {
        return Miercoles;
    }

    public void setMiercoles(String miercoles) {
        Miercoles = miercoles;
    }

    public String getJueves() {
        return Jueves;
    }

    public void setJueves(String jueves) {
        Jueves = jueves;
    }

    public String getViernes() {
        return Viernes;
    }

    public void setViernes(String viernes) {
        Viernes = viernes;
    }

    public String getSabado() {
        return Sabado;
    }

    public void setSabado(String sabado) {
        Sabado = sabado;
    }

    public String getDomingo() {
        return Domingo;
    }

    public void setDomingo(String domingo) {
        Domingo = domingo;
    }
}
