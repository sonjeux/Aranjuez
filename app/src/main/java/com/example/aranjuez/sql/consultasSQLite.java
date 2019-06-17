package com.example.aranjuez.sql;

public class consultasSQLite {
    public static final String SQLActividad_Economica="CREATE TABLE Actividad_Economica (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Codigo TEXT, Descripcion TEXT, Estado TEXT)";

    public static final String SQLArea="CREATE TABLE Area (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Zona INTEGER, Codigo TEXT, Nombre TEXT, Estado TEXT)";

    public static final String SQLCliente="CREATE TABLE Cliente (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Desarrollador INTEGER, Id_Preventista INTEGER, Id_Distribuidor INTEGER, " +
            "Id_Isscom INTEGER, Id_Nivel_Socioeconomico INTEGER, Id_Lista_De_Precios INTEGER, Generico TEXT, Codigo_SAP TEXT, Codigo_Ruta TEXT, Nombre TEXT, CI_O_NIT TEXT, Razon_Social TEXT, " +
            "Nombre_De_Referencia TEXT, Direccion TEXT, Referencia TEXT, Zona TEXT, Telefono TEXT, Celular TEXT, Preventa TEXT, Latitud NUMERIC, Longitud NUMERIC, Estado TEXT)";

    public static final String SQLCodigo_De_Barras="CREATE TABLE Codigo_De_Barras (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Producto INTEGER, Id_Unidad_De_Medida INTEGER, Codigo_De_Barras TEXT, Estado TEXT)";

    public static final String SQLCondicion_De_Pago="CREATE TABLE Condicion_De_Pago (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, GroupNum INTEGER, Condicion TEXT, Meses_Extra INTEGER, Dias_Extra INTEGER, Estado TEXT)";

    public static final String SQLConfiguracion_SAP="CREATE TABLE Configuracion_SAP (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Servidor TEXT, Tipo_De_Servidor_De_Base_De_Datos TEXT, " +
            "Servidor_De_Licencias TEXT, Base_De_Datos_De_La_Empresa TEXT, Usuario_De_Base_De_Datos TEXT, Clave_De_Base_De_Datos TEXT, Nombre_De_Usuario TEXT, Clave TEXT)";

    public static final String sqlDesarrollador="CREATE TABLE Desarrollador (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Usuario INTEGER, Nombre TEXT, Estado TEXT)";

    /*public static final String SQLDetalle_De_Factura="Create Table Detalle_De_Factura (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Preventa INTEGER, Id_Factura INTEGER, Id_Producto INTEGER, " +
            "Numero_De_Linea_Base INTEGER, Cantidad NUMERIC, Detalle TEXT, Precio_Unitario NUMERIC, Total NUMERIC, Precio_Unitario_Menos_ICE NUMERIC, Total_Menos_ICE NUMERIC, Descuento NUMERIC, " +
            "Porcentaje_De_Descuento NUMERIC, Estado TEXT)";*/

    public static final String SQLDetalle_De_Grupo_De_Unidad_De_Medida="CREATE TABLE Detalle_De_Grupo_De_Unidad_De_Medida (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, " +
            "Id_Grupo_De_Unidad_De_Medida INTEGER, Id_Unidad_De_Medida_Alternativa INTEGER, Cantidad_Alternativa NUMERIC, Cantidad_Base NUMERIC, Estado TEXT)";

    public static final String SQLDetalle_De_Preventa="CREATE TABLE Detalle_De_Preventa (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Preventa INTEGER, Id_Producto INTEGER, " +
            "Cantidad NUMERIC, Precio_Unitario NUMERIC, Total NUMERIC, Precio_Unitario_Menos_ICE NUMERIC, Total_Menos_ICE NUMERIC, Descuento NUMERIC, " +
            "Porcentaje_De_Descuento NUMERIC, IVA NUMERIC, ICE NUMERIC, Litros NUMERIC, Estado TEXT)";

    public static final String SQLDias_De_Visita="CREATE TABLE Dias_De_Visita (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Cliente INTEGER, Tipo TEXT, Lunes INTEGER, Martes INTEGER, " +
            "Miercoles INTEGER, Jueves INTEGER, Viernes INTEGER, Sabado INTEGER, Domingo INTEGER)";

    public static final String SQLDispositivo="CREATE TABLE Dispositivo (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Sucursal INTEGER, Nombre TEXT, Estado TEXT)";

    public static final String SQLDistribuidor="CREATE TABLE Distribuidor (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Usuario INTEGER, Id_Region INTEGER, Codigo TEXT, SlpCode INTEGER, " +
            "SlpName TEXT, Estado TEXT)";

    public static final String SQLDosificacion="CREATE TABLE Dosificacion (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Sucursal INTEGER, Id_Actividad_Economica INTEGER, " +
            "Numero_De_Autorizacion TEXT, Caracteristicas TEXT, Fecha_Limite_De_Emision TEXT, Leyenda TEXT, Llave TEXT, Estado TEXT)";

    public static final String SQLEmpresa="CREATE TABLE Empresa (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Propietario TEXT, Razon_Social TEXT, NIT TEXT )";

    /*[Id]
      ,[Id_Usuario]
      ,[Id_Numeracion_De_Documento]
      ,[Id_Condicion_De_Pago]
      ,[Id_Dosificacion]
      ,[Id_Distribuidor]
      ,[Id_Dispositivo]
      ,[Id_Cliente]
      ,[Id_Factura_Dispositivo]
      ,[DocEntry]
      ,[Codigo_SAP]
      ,[Numero_De_Autorizacion]
      ,[Numero]
      ,[Codigo_De_Control]
      ,[CI_O_NIT]
      ,[Cliente]
      ,[Fecha]
      ,[Hora]
      ,[Total_De_Litros]
      ,[Subtotal]
      ,[Descuento]
      ,[Monto_Para_Credito_Fiscal]
      ,[IVA]
      ,[ICE]
      ,[Total]
      ,[Total_A_Pagar]
      ,[Observaciones]
      ,[Estado]
      ,[Sincronizada]*/

    /*public static final String SQLFactura="Create Table Factura (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Usuario INTEGER, Id_Numeracion_De_Documento INTEGER, Id_Dosificacion INTEGER, " +
            "Id_Distribuidor INTEGER, Id_Dispositivo INTEGER, Id_Factura_Dispositivo INTEGER, Id_Cliente INTEGER, Id_Condicion_De_Pago INTEGER, DocEntry TEXT, Numero_De_Autorizacion TEXT, " +
            "Numero INTEGER, Codigo_De_Control TEXT, Codigo_SAP TEXT, CI_O_NIT TEXT, Cliente TEXT, Fecha TEXT, Hora TEXT, Total_De_Litros NUMERIC, "+
            "Sub_Total NUMERIC, Descuento NUMERIC, Monto_Para_Credito_Fiscal NUMERIC, ICE NUMERIC, Total NUMERIC, Total_A_Pagar NUMERIC, Observaciones TEXT, " +
            "Estado TEXT, Sincronizada bit Not Null, RctEntry TEXT, Pago_Sincronizado bit Not Null)";*/

    public static final String SQLGasto_Adicional="CREATE TABLE Gasto_Adicional (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, ExpenseCode INTEGER, Nombre TEXT, Monto NUMERIC, Estado TEXT)";

    public static final String SQLGrupo="CREATE TABLE Grupo (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Codigo TEXT, Nombre TEXT, Estado TEXT)";

    public static final String SQLGrupo_De_Unidad_De_Medida="CREATE TABLE Grupo_De_Unidad_De_Medida (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Unidad_De_Medida_Base INTEGER, " +
            "Codigo TEXT, Nombre TEXT, Estado TEXT)";

    public static final String SQLHistorial_De_Sincronizacion="CREATE TABLE Historial_De_Sincronizacion (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Dispositivo INTEGER, Orden INTEGER, " +
            "Tabla TEXT, Id_Tabla INTEGER, Fecha TEXT, Hora TEXT, Estado TEXT)";

    public static final String SQLIsscom="CREATE TABLE Isscom (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Codigo TEXT, Canal TEXT, Descripcion TEXT, Estado TEXT)";

    public static final String SQLLista_De_Precios="CREATE TABLE Lista_De_Precios (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Nombre TEXT, Estado TEXT)";

    public static final String SQLNivel_Socioeconomico="CREATE TABLE Nivel_Socioeconomico (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Tipo TEXT, Estado TEXT)";

    public static final String SQLNumeracion_De_Documento="CREATE TABLE Numeracion_De_Documento (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Sucursal INTEGER, Id_Condicion_De_Pago INTEGER, " +
            "Series INTEGER, Nombre_De_La_Serie TEXT, Estado TEXT)";

    public static final String SQLParametrizacion_De_Cuentas_Contables="CREATE TABLE Parametrizacion_De_Cuentas_Contables (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Zona INTEGER, " +
            "Venta_De_Producto_Terminado TEXT, Descuento_Sobre_Venta_De_Producto_Terminado TEXT, Descuento_Sobre_Venta_De_Otros_Materiales TEXT, Descuento_De_Envases TEXT, Deduccion_De_IVA TEXT, " +
            "Deduccion_De_ICE TEXT, Debito_Fiscal_Por_Pagar TEXT, ICE_Por_Pagar TEXT, Estado TEXT)";

    public static final String SQLParametrizacion_De_Cuentas_De_Flujo="CREATE TABLE Parametrizacion_De_Cuentas_De_Flujo (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Zona INTEGER, " +
            "Venta INTEGER, Cobranza INTEGER, Estado TEXT)";

    //Parametro

    public static final String SQLPrecio_De_Producto="CREATE TABLE Precio_De_Producto (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Lista_De_Precios INTEGER, Id_Producto INTEGER, " +
            "Id_Unidad_De_Medida INTEGER, Precio NUMERIC, Porcentaje_De_Descuento NUMERIC, Estado TEXT)";

    public static final String SQLPreventa="CREATE TABLE Preventa (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Usuario INTEGER, Id_Dispositivo INTEGER, Id_Preventa_Dispositivo INTEGER, " +
            "Id_Cliente INTEGER, Id_Condicion_De_Pago INTEGER, DocEntry TEXT, Codigo_SAP TEXT, Fecha TEXT, Hora TEXT, Latitud NUMERIC, Longitud NUMERIC, Total_De_Litros NUMERIC, Subtotal NUMERIC, " +
            "Descuento NUMERIC, Monto_Para_Credito_Fiscal NUMERIC, IVA NUMERIC, ICE NUMERIC, Total NUMERIC, Total_A_Pagar NUMERIC, Observaciones TEXT, Estado TEXT, Sincronizada INTEGER)";

    //Preventista

    public static final String SQLProducto="CREATE TABLE Producto (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Grupo INTEGER, Id_Gasto_Adicional INTEGER, Id_Grupo_De_Unidad_De_Medida INTEGER, " +
            "Codigo_SAP TEXT, Nombre TEXT, Descripcion TEXT, Alias TEXT, Centro_De_Costo TEXT, Producto_Terminado TEXT, Capacidad_En_Litros NUMERIC, Estado TEXT)";

    public static final String SQLRegion="CREATE TABLE Region (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Area INTEGER, Codigo TEXT, Nombre TEXT, Estado TEXT)";

    //Sistema

    public static final String SQLSucursal="CREATE TABLE Sucursal (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Empresa INTEGER, Numero INTEGER, Direccion TEXT, Telefono TEXT, Municipio TEXT, " +
            "Almacen TEXT, Almacen_De_Exportacion TEXT, Estado TEXT)";

    public static final String SQLUnidad_De_Medida="CREATE TABLE Unidad_De_Medida (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, UomEntry INTEGER, Codigo TEXT, Nombre TEXT, Tipo TEXT, Estado TEXT)";

    public static final String SQLUnidad_De_Medida_De_Producto="CREATE TABLE Unidad_De_Medida_De_Producto (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Actividad_Economica INTEGER, " +
            "Id_Producto INTEGER, Id_Unidad_De_Medida INTEGER, Tipo TEXT, Estado TEXT)";

    /*[Id]
      ,[Id_Sistema]
      ,[Id_Sucursal]
      ,[Nombres]
      ,[Apellido_Paterno]
      ,[Apellido_Materno]
      ,[Nombre_Completo] No lo puse
      ,[Nombre_De_Usuario]
      ,[Clave]
      ,[Cambio_De_Clave]
      ,[Usuario_SAP]
      ,[Clave_SAP]
      ,[Estado]*/

    public static final String SQLUsuario="CREATE TABLE Usuario (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Sistema INTEGER, Id_Sucursal INTEGER, Nombres TEXT, Apellido_Paterno TEXT, " +
            "Apellido_Materno TEXT, Nombre_De_Usuario TEXT, Clave TEXT, Cambio_De_Clave TEXT, Usuario_SAP TEXT, Clave_SAP TEXT, Estado TEXT)";

    public static final String SQLZona="CREATE TABLE Zona (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Codigo TEXT, Nombre TEXT, Estado TEXT)";
}


