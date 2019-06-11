package com.example.aranjuez.entidades;

public class Producto {
    private String Id;
    private String Id_Grupo;
    private String Id_Gasto_Adicional;
    private String Id_Grupo_De_Unidad_De_Medida;
    private String Codigo_SAP;
    private String Nombre;
    private String Descripcion;
    private String Alias;
    private String Centro_De_Costo;
    private String Producto_Terminado;
    private Double Capacidad_En_Litros;
    private String Estado;

    public Producto(String id, String id_Grupo, String id_Gasto_Adicional, String id_Grupo_De_Unidad_De_Medida, String codigo_SAP, String nombre, String descripcion, String alias, String centro_De_Costo, String producto_Terminado, Double capacidad_En_Litros, String estado) {
        Id = id;
        Id_Grupo = id_Grupo;
        Id_Gasto_Adicional = id_Gasto_Adicional;
        Id_Grupo_De_Unidad_De_Medida = id_Grupo_De_Unidad_De_Medida;
        Codigo_SAP = codigo_SAP;
        Nombre = nombre;
        Descripcion = descripcion;
        Alias = alias;
        Centro_De_Costo = centro_De_Costo;
        Producto_Terminado = producto_Terminado;
        Capacidad_En_Litros = capacidad_En_Litros;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Grupo() {
        return Id_Grupo;
    }

    public void setId_Grupo(String id_Grupo) {
        Id_Grupo = id_Grupo;
    }

    public String getId_Gasto_Adicional() {
        return Id_Gasto_Adicional;
    }

    public void setId_Gasto_Adicional(String id_Gasto_Adicional) {
        Id_Gasto_Adicional = id_Gasto_Adicional;
    }

    public String getId_Grupo_De_Unidad_De_Medida() {
        return Id_Grupo_De_Unidad_De_Medida;
    }

    public void setId_Grupo_De_Unidad_De_Medida(String id_Grupo_De_Unidad_De_Medida) {
        Id_Grupo_De_Unidad_De_Medida = id_Grupo_De_Unidad_De_Medida;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }

    public String getCentro_De_Costo() {
        return Centro_De_Costo;
    }

    public void setCentro_De_Costo(String centro_De_Costo) {
        Centro_De_Costo = centro_De_Costo;
    }

    public String getProducto_Terminado() {
        return Producto_Terminado;
    }

    public void setProducto_Terminado(String producto_Terminado) {
        Producto_Terminado = producto_Terminado;
    }

    public Double getCapacidad_En_Litros() {
        return Capacidad_En_Litros;
    }

    public void setCapacidad_En_Litros(Double capacidad_En_Litros) {
        Capacidad_En_Litros = capacidad_En_Litros;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
