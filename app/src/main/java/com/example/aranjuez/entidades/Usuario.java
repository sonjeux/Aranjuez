package com.example.aranjuez.entidades;

public class Usuario {
    private String Id;
    private String Id_Sucursal;
    private String Nombres;
    private String Apellido_Paterno;
    private String Apellido_Materno;
    private String Nombre_Completo;
    private String Nombre_De_Usuario;
    private String Clave;
    private String Cambio_De_Clave;
    private String Usuario_SAP;
    private String Clave_SAP;
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

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellido_Paterno() {
        return Apellido_Paterno;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        Apellido_Paterno = apellido_Paterno;
    }

    public String getApellido_Materno() {
        return Apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        Apellido_Materno = apellido_Materno;
    }

    public String getNombre_Completo() {
        return Nombre_Completo;
    }

    public void setNombre_Completo(String nombre_Completo) {
        Nombre_Completo = nombre_Completo;
    }

    public String getNombre_De_Usuario() {
        return Nombre_De_Usuario;
    }

    public void setNombre_De_Usuario(String nombre_De_Usuario) {
        Nombre_De_Usuario = nombre_De_Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getCambio_De_Clave() {
        return Cambio_De_Clave;
    }

    public void setCambio_De_Clave(String cambio_De_Clave) {
        Cambio_De_Clave = cambio_De_Clave;
    }

    public String getUsuario_SAP() {
        return Usuario_SAP;
    }

    public void setUsuario_SAP(String usuario_SAP) {
        Usuario_SAP = usuario_SAP;
    }

    public String getClave_SAP() {
        return Clave_SAP;
    }

    public void setClave_SAP(String clave_SAP) {
        Clave_SAP = clave_SAP;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Usuario(String id, String id_Sucursal, String nombres, String apellido_Paterno, String apellido_Materno, String nombre_Completo, String nombre_De_Usuario, String clave, String cambio_De_Clave, String usuario_SAP, String clave_SAP, String estado) {
        Id = id;
        Id_Sucursal = id_Sucursal;
        Nombres = nombres;
        Apellido_Paterno = apellido_Paterno;
        Apellido_Materno = apellido_Materno;
        Nombre_Completo = nombre_Completo;
        Nombre_De_Usuario = nombre_De_Usuario;
        Clave = clave;
        Cambio_De_Clave = cambio_De_Clave;
        Usuario_SAP = usuario_SAP;
        Clave_SAP = clave_SAP;
        Estado = estado;
    }
}
