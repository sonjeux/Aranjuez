package com.example.aranjuez.entidades;

public class VisitaVO {
    private String Id;
    private String Tema_De_Visita;
    private String Cliente;
    private String Fecha;
    private String Hora;
    private String Observaciones;
    private String Estado;

    public VisitaVO(String id, String tema_De_Visita, String cliente, String fecha, String hora, String observaciones, String estado) {
        Id = id;
        Tema_De_Visita = tema_De_Visita;
        Cliente = cliente;
        Fecha = fecha;
        Hora = hora;
        Observaciones = observaciones;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTema_De_Visita() {
        return Tema_De_Visita;
    }

    public void setTema_De_Visita(String tema_De_Visita) {
        Tema_De_Visita = tema_De_Visita;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
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

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
