package com.example.aranjuez.entidades;

public class Respuesta {
    private String Id;
    private String Respuesta;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String respuesta) {
        Respuesta = respuesta;
    }

    public Respuesta(String id, String respuesta) {
        Id = id;
        Respuesta = respuesta;
    }
}
