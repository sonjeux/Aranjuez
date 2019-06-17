package com.example.aranjuez.entidades;

public class PreventaVO {
    private String Id;
    private String Fecha;
    private String Hora;
    private String Cliente;
    private String Total;
    private String Estado;

    public PreventaVO(String id, String fecha, String hora, String cliente, String total, String estado) {
        Id = id;
        Fecha = fecha;
        Hora = hora;
        Cliente = cliente;
        Total = total;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
