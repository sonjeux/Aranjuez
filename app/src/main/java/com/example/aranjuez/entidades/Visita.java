package com.example.aranjuez.entidades;

public class Visita {
    private String Id;
    private String Id_Usuario;
    private String Id_Dispositivo;
    private String Id_Tema_De_Visita;
    private String Id_Desarrollador;
    private String Id_Preventista;
    private String Id_Distribuidor;
    private String Id_Cliente;
    private String Id_Checklist;
    private String Id_Preventa;
    private String Id_Factura;
    private String Id_Visita_Dispositivo;
    private String Cliente;
    private String Fecha;
    private String Hora;
    private String Observaciones;
    private String Estado;

    public Visita(String id, String id_Usuario, String id_Dispositivo, String id_Tema_De_Visita, String id_Desarrollador, String id_Preventista, String id_Distribuidor, String id_Cliente, String id_Checklist, String id_Preventa, String id_Factura, String id_Visita_Dispositivo, String cliente, String fecha, String hora, String observaciones, String estado) {
        Id = id;
        Id_Usuario = id_Usuario;
        Id_Dispositivo = id_Dispositivo;
        Id_Tema_De_Visita = id_Tema_De_Visita;
        Id_Desarrollador = id_Desarrollador;
        Id_Preventista = id_Preventista;
        Id_Distribuidor = id_Distribuidor;
        Id_Cliente = id_Cliente;
        Id_Checklist = id_Checklist;
        Id_Preventa = id_Preventa;
        Id_Factura = id_Factura;
        Id_Visita_Dispositivo = id_Visita_Dispositivo;
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

    public String getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        Id_Usuario = id_Usuario;
    }

    public String getId_Dispositivo() {
        return Id_Dispositivo;
    }

    public void setId_Dispositivo(String id_Dispositivo) {
        Id_Dispositivo = id_Dispositivo;
    }

    public String getId_Tema_De_Visita() {
        return Id_Tema_De_Visita;
    }

    public void setId_Tema_De_Visita(String id_Tema_De_Visita) {
        Id_Tema_De_Visita = id_Tema_De_Visita;
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

    public String getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public String getId_Checklist() {
        return Id_Checklist;
    }

    public void setId_Checklist(String id_Checklist) {
        Id_Checklist = id_Checklist;
    }

    public String getId_Preventa() {
        return Id_Preventa;
    }

    public void setId_Preventa(String id_Preventa) {
        Id_Preventa = id_Preventa;
    }

    public String getId_Factura() {
        return Id_Factura;
    }

    public void setId_Factura(String id_Factura) {
        Id_Factura = id_Factura;
    }

    public String getId_Visita_Dispositivo() {
        return Id_Visita_Dispositivo;
    }

    public void setId_Visita_Dispositivo(String id_Visita_Dispositivo) {
        Id_Visita_Dispositivo = id_Visita_Dispositivo;
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
