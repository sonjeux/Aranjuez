package com.example.aranjuez.entidades;

public class Preventa {
    private String Id;
    private String Id_Usuario;
    private String Id_Dispositivo;
    private String Id_Preventa_Dispositivo;
    private String Id_Cliente;
    private String Id_Condicion_De_Pago;
    private String DocEntry;
    private String Codigo_SAP;
    private String Numero;
    private String Fecha;
    private String Hora;
    private String Latitud;
    private String Longitud;
    private String Total_De_Litros;
    private String Subtotal;
    private String Descuento;
    private String Descuento_Sobre_Venta;
    private String Descuento_De_Envases;
    private String Monto_Para_Credito_Fiscal;
    private String IVA;
    private String ICE;
    private String Total;
    private String Total_A_Pagar;
    private String Observaciones;
    private String Estado;
    private String Sincronizada;

    public Preventa(String id, String id_Usuario, String id_Dispositivo, String id_Preventa_Dispositivo, String id_Cliente, String id_Condicion_De_Pago, String docEntry, String codigo_SAP, String numero, String fecha, String hora, String latitud, String longitud, String total_De_Litros, String subtotal, String descuento, String descuento_Sobre_Venta, String descuento_De_Envases, String monto_Para_Credito_Fiscal, String IVA, String ICE, String total, String total_A_Pagar, String observaciones, String estado, String sincronizada) {
        Id = id;
        Id_Usuario = id_Usuario;
        Id_Dispositivo = id_Dispositivo;
        Id_Preventa_Dispositivo = id_Preventa_Dispositivo;
        Id_Cliente = id_Cliente;
        Id_Condicion_De_Pago = id_Condicion_De_Pago;
        DocEntry = docEntry;
        Codigo_SAP = codigo_SAP;
        Numero = numero;
        Fecha = fecha;
        Hora = hora;
        Latitud = latitud;
        Longitud = longitud;
        Total_De_Litros = total_De_Litros;
        Subtotal = subtotal;
        Descuento = descuento;
        Descuento_Sobre_Venta = descuento_Sobre_Venta;
        Descuento_De_Envases = descuento_De_Envases;
        Monto_Para_Credito_Fiscal = monto_Para_Credito_Fiscal;
        this.IVA = IVA;
        this.ICE = ICE;
        Total = total;
        Total_A_Pagar = total_A_Pagar;
        Observaciones = observaciones;
        Estado = estado;
        Sincronizada = sincronizada;
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

    public String getId_Preventa_Dispositivo() {
        return Id_Preventa_Dispositivo;
    }

    public void setId_Preventa_Dispositivo(String id_Preventa_Dispositivo) {
        Id_Preventa_Dispositivo = id_Preventa_Dispositivo;
    }

    public String getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public String getId_Condicion_De_Pago() {
        return Id_Condicion_De_Pago;
    }

    public void setId_Condicion_De_Pago(String id_Condicion_De_Pago) {
        Id_Condicion_De_Pago = id_Condicion_De_Pago;
    }

    public String getDocEntry() {
        return DocEntry;
    }

    public void setDocEntry(String docEntry) {
        DocEntry = docEntry;
    }

    public String getCodigo_SAP() {
        return Codigo_SAP;
    }

    public void setCodigo_SAP(String codigo_SAP) {
        Codigo_SAP = codigo_SAP;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
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

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String latitud) {
        Latitud = latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    public void setLongitud(String longitud) {
        Longitud = longitud;
    }

    public String getTotal_De_Litros() {
        return Total_De_Litros;
    }

    public void setTotal_De_Litros(String total_De_Litros) {
        Total_De_Litros = total_De_Litros;
    }

    public String getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(String subtotal) {
        Subtotal = subtotal;
    }

    public String getDescuento() {
        return Descuento;
    }

    public void setDescuento(String descuento) {
        Descuento = descuento;
    }

    public String getDescuento_Sobre_Venta() {
        return Descuento_Sobre_Venta;
    }

    public void setDescuento_Sobre_Venta(String descuento_Sobre_Venta) {
        Descuento_Sobre_Venta = descuento_Sobre_Venta;
    }

    public String getDescuento_De_Envases() {
        return Descuento_De_Envases;
    }

    public void setDescuento_De_Envases(String descuento_De_Envases) {
        Descuento_De_Envases = descuento_De_Envases;
    }

    public String getMonto_Para_Credito_Fiscal() {
        return Monto_Para_Credito_Fiscal;
    }

    public void setMonto_Para_Credito_Fiscal(String monto_Para_Credito_Fiscal) {
        Monto_Para_Credito_Fiscal = monto_Para_Credito_Fiscal;
    }

    public String getIVA() {
        return IVA;
    }

    public void setIVA(String IVA) {
        this.IVA = IVA;
    }

    public String getICE() {
        return ICE;
    }

    public void setICE(String ICE) {
        this.ICE = ICE;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getTotal_A_Pagar() {
        return Total_A_Pagar;
    }

    public void setTotal_A_Pagar(String total_A_Pagar) {
        Total_A_Pagar = total_A_Pagar;
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

    public String getSincronizada() {
        return Sincronizada;
    }

    public void setSincronizada(String sincronizada) {
        Sincronizada = sincronizada;
    }
}
