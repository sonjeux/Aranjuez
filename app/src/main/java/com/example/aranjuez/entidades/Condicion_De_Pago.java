package com.example.aranjuez.entidades;

import java.io.Serializable;

public class Condicion_De_Pago implements Serializable {
    private String Id;
    private String GroupNum;
    private String Condicion;
    private String Meses_Extra;
    private String Dias_Extra;
    private String Estado;

    public Condicion_De_Pago(String id, String groupNum, String condicion, String meses_Extra, String dias_Extra, String estado) {
        Id = id;
        GroupNum = groupNum;
        Condicion = condicion;
        Meses_Extra = meses_Extra;
        Dias_Extra = dias_Extra;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getGroupNum() {
        return GroupNum;
    }

    public void setGroupNum(String groupNum) {
        GroupNum = groupNum;
    }

    public String getCondicion() {
        return Condicion;
    }

    public void setCondicion(String condicion) {
        Condicion = condicion;
    }

    public String getMeses_Extra() {
        return Meses_Extra;
    }

    public void setMeses_Extra(String meses_Extra) {
        Meses_Extra = meses_Extra;
    }

    public String getDias_Extra() {
        return Dias_Extra;
    }

    public void setDias_Extra(String dias_Extra) {
        Dias_Extra = dias_Extra;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
