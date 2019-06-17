package com.example.aranjuez.entidades;

public class Gasto_Adicional {
    private String Id;
    private String ExpenseCode;
    private String Nombre;
    private String Monto;
    private String Estado;

    public Gasto_Adicional(String id, String expenseCode, String nombre, String monto, String estado) {
        Id = id;
        ExpenseCode = expenseCode;
        Nombre = nombre;
        Monto = monto;
        Estado = estado;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getExpenseCode() {
        return ExpenseCode;
    }

    public void setExpenseCode(String expenseCode) {
        ExpenseCode = expenseCode;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String monto) {
        Monto = monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
