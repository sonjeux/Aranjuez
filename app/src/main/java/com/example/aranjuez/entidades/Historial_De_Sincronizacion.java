package com.example.aranjuez.entidades;

public class Historial_De_Sincronizacion {
    private String Id;
    private String Id_Dispositivo;
    private String Orden;
    private String Tabla;
    private String Id_Tabla;
    private String Fecha;
    private String Hora;
    private String Estado;

    public Historial_De_Sincronizacion(String id, String id_Dispositivo, String orden, String tabla, String id_Tabla, String fecha, String hora, String estado) {
        Id = id;
        Id_Dispositivo = id_Dispositivo;
        Orden = orden;
        Tabla = tabla;
        Id_Tabla = id_Tabla;
        Fecha = fecha;
        Hora = hora;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Dispositivo() {
        return Id_Dispositivo;
    }

    public void setId_Dispositivo(String id_Dispositivo) {
        Id_Dispositivo = id_Dispositivo;
    }

    public String getOrden() {
        return Orden;
    }

    public void setOrden(String orden) {
        Orden = orden;
    }

    public String getTabla() {
        return Tabla;
    }

    public void setTabla(String tabla) {
        Tabla = tabla;
    }

    public String getId_Tabla() {
        return Id_Tabla;
    }

    public void setId_Tabla(String id_Tabla) {
        Id_Tabla = id_Tabla;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
