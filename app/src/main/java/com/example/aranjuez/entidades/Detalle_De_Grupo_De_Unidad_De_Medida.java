package com.example.aranjuez.entidades;

public class Detalle_De_Grupo_De_Unidad_De_Medida {
    private String Id;
    private String Id_Grupo_De_Unidad_De_Medida;
    private String Id_Unidad_De_Medida_Alternativa;
    private String Cantidad_Alternativa;
    private String Cantidad_Base;
    private String Estado;

    public Detalle_De_Grupo_De_Unidad_De_Medida(String id, String id_Grupo_De_Unidad_De_Medida, String id_Unidad_De_Medida_Alternativa, String cantidad_Alternativa, String cantidad_Base, String estado) {
        Id = id;
        Id_Grupo_De_Unidad_De_Medida = id_Grupo_De_Unidad_De_Medida;
        Id_Unidad_De_Medida_Alternativa = id_Unidad_De_Medida_Alternativa;
        Cantidad_Alternativa = cantidad_Alternativa;
        Cantidad_Base = cantidad_Base;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_Grupo_De_Unidad_De_Medida() {
        return Id_Grupo_De_Unidad_De_Medida;
    }

    public void setId_Grupo_De_Unidad_De_Medida(String id_Grupo_De_Unidad_De_Medida) {
        Id_Grupo_De_Unidad_De_Medida = id_Grupo_De_Unidad_De_Medida;
    }

    public String getId_Unidad_De_Medida_Alternativa() {
        return Id_Unidad_De_Medida_Alternativa;
    }

    public void setId_Unidad_De_Medida_Alternativa(String id_Unidad_De_Medida_Alternativa) {
        Id_Unidad_De_Medida_Alternativa = id_Unidad_De_Medida_Alternativa;
    }

    public String getCantidad_Alternativa() {
        return Cantidad_Alternativa;
    }

    public void setCantidad_Alternativa(String cantidad_Alternativa) {
        Cantidad_Alternativa = cantidad_Alternativa;
    }

    public String getCantidad_Base() {
        return Cantidad_Base;
    }

    public void setCantidad_Base(String cantidad_Base) {
        Cantidad_Base = cantidad_Base;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
