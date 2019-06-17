package com.example.aranjuez.entidades;

public class Dispositivo {
    private String Id;
    private String Id_Sucursal;
    private String Nombre;
    private String Estado;

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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Dispositivo(String id, String id_Sucursal, String nombre, String estado) {
        Id = id;
        Id_Sucursal = id_Sucursal;
        Nombre = nombre;
        Estado = estado;
    }
}
