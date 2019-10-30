package com.example.aranjuez;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.aranjuez.entidades.Area;
import com.example.aranjuez.entidades.Cliente;
import com.example.aranjuez.entidades.Codigo_De_Barras;
import com.example.aranjuez.entidades.Condicion_De_Pago;
import com.example.aranjuez.entidades.Detalle_De_Grupo_De_Unidad_De_Medida;
import com.example.aranjuez.entidades.Dias_De_Visita;
import com.example.aranjuez.entidades.Grupo_De_Unidad_De_Medida;
import com.example.aranjuez.entidades.Lista_De_Precios;
import com.example.aranjuez.entidades.Precio_De_Producto;
import com.example.aranjuez.entidades.Producto;
import com.example.aranjuez.entidades.Tema_De_Visita;
import com.example.aranjuez.entidades.Unidad_De_Medida;
import com.example.aranjuez.entidades.Unidad_De_Medida_De_Producto;
import com.example.aranjuez.interfaz.AranjuezJsonApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonActivity extends AppCompatActivity {

    AranjuezJsonApi aranjuezJsonApi;
    SQLiteHelper sqLiteHelper;
    String urlBase;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        SharedPreferences preferences=getSharedPreferences("configuracion", Context.MODE_PRIVATE);
        urlBase=preferences.getString("Url", "").toString();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aranjuezJsonApi=retrofit.create(AranjuezJsonApi.class);

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null,1);
    }

    //
    public void GetProductos(){
        Call<List<Producto>> call=aranjuezJsonApi.getProductos("Producto");
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (!response.isSuccessful()){
                    Log.e("LogE","Error "+response.code());
                    return;
                }

                SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
                db.execSQL("DELETE FROM Producto");

                List<Producto> productos=response.body();
                for (Producto producto:productos){
                    String SQLConsulta="INSERT INTO Producto (Id, Id_Grupo, Id_Gasto_Adicional, Id_Grupo_De_Unidad_De_Medida, Codigo_SAP, Nombre, Descripcion, Alias, Centro_De_Costo, Producto_Terminado, " +
                            "Capacidad_En_Litros, Estado) VALUES ('"+producto.getId()+"', '"+producto.getId_Grupo()+"', '"+producto.getId_Gasto_Adicional()+"', '"+producto.getId_Grupo_De_Unidad_De_Medida()+
                            "', '"+producto.getCodigo_SAP()+"', '"+producto.getNombre()+"', '"+producto.getDescripcion()+"', '"+producto.getAlias()+"', '"+producto.getCentro_De_Costo()+
                            "', '"+producto.getProducto_Terminado()+"', '"+producto.getCapacidad_En_Litros()+"', '"+producto.getEstado()+"')";
                    db.execSQL(SQLConsulta);
                }
            }
            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.e("LogE","Fallo ");
            }
        });
    }

    public void PostArea(){
        Map<String, String> map=new HashMap<>();
        map.put("Mensaje", "Saludos");
        map.put("Nombre", "Lola Soledad");
        Call<Area> call=aranjuezJsonApi.postArea(map);
        call.enqueue(new Callback<Area>() {
            @Override
            public void onResponse(Call<Area> call, Response<Area> response) {
                if (!response.isSuccessful()){
                    Log.d("Respuesta","Error "+response.code());
                    return;
                }
                Area area=response.body();
                Log.d("Respuesta", area.getId());
            }

            @Override
            public void onFailure(Call<Area> call, Throwable t) {
                Log.d("Respuesta","Fallo ");
            }
        });
    }

    public void testPost(View view) {
        PostArea();
    }

    public void GetLista_De_Precios(){
        Call<List<Lista_De_Precios>> call=aranjuezJsonApi.getLista_De_Precios("Producto");
        call.enqueue(new Callback<List<Lista_De_Precios>>() {
            @Override
            public void onResponse(Call<List<Lista_De_Precios>> call, Response<List<Lista_De_Precios>> response) {
                if (!response.isSuccessful()){
                    Log.e("LogE","Error "+response.code());
                    return;
                }
                //Lista_De_Precios (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Nombre TEXT, Estado TEXT)
                SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
                db.execSQL("DELETE FROM Lista_De_Precios");

                List<Lista_De_Precios> lista_de_precios=response.body();
                for (Lista_De_Precios lista_de_precio:lista_de_precios){
                    String SQLConsulta="INSERT INTO Lista_De_Precios (Id, Nombre, Estado) VALUES ('"+lista_de_precio.getId()+"', '"+lista_de_precio.getNombre()+"', '"+lista_de_precio.getEstado()+"')";
                    db.execSQL(SQLConsulta);
                }
            }
            @Override
            public void onFailure(Call<List<Lista_De_Precios>> call, Throwable t) {
                Log.e("LogE","Fallo ");
            }
        });
    }

    public void GetPrecio_De_Producto(){
        Call<List<Precio_De_Producto>> call=aranjuezJsonApi.getPrecio_De_Productos("Producto");
        call.enqueue(new Callback<List<Precio_De_Producto>>() {
            @Override
            public void onResponse(Call<List<Precio_De_Producto>> call, Response<List<Precio_De_Producto>> response) {
                if (!response.isSuccessful()){
                    Log.e("LogE","Error "+response.code());
                    return;
                }
                //Precio_De_Producto (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Lista_De_Precios INTEGER, Id_Producto INTEGER, " +
                //            "Id_Unidad_De_Medida INTEGER, Precio NUMERIC, Porcentaje_De_Descuento NUMERIC, Estado TEXT)
                SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
                db.execSQL("DELETE FROM Precio_De_Producto");

                List<Precio_De_Producto> precio_de_productos=response.body();
                for (Precio_De_Producto precio_de_producto:precio_de_productos){
                    String SQLConsulta="INSERT INTO Precio_De_Producto (Id, Id_Lista_De_Precios, Id_Producto, Id_Unidad_De_Medida, Precio, Porcentaje_De_Descuento, Estado) VALUES ('"+precio_de_producto.getId()+
                            "', '"+precio_de_producto.getId_Lista_De_Precios()+"', '"+precio_de_producto.getId_Producto()+"', '"+precio_de_producto.getId_Unidad_De_Medida()+
                            "', '"+precio_de_producto.getPrecio()+"', '"+precio_de_producto.getPorcentaje_De_Descuento()+"', '"+precio_de_producto.getEstado()+"')";
                    db.execSQL(SQLConsulta);
                    //Log.e("JSON", producto.getNombre());
                }
            }
            @Override
            public void onFailure(Call<List<Precio_De_Producto>> call, Throwable t) {
                Log.e("LogE","Fallo ");
            }
        });
    }

    public void GetGrupo_De_Unidad_De_Medida(){
        Call<List<Grupo_De_Unidad_De_Medida>> call=aranjuezJsonApi.getGrupo_De_Unidad_De_Medidas("Grupo_De_Unidad_De_Medida");
        call.enqueue(new Callback<List<Grupo_De_Unidad_De_Medida>>() {
            @Override
            public void onResponse(Call<List<Grupo_De_Unidad_De_Medida>> call, Response<List<Grupo_De_Unidad_De_Medida>> response) {
                if (!response.isSuccessful()){
                    Log.e("LogE","Error "+response.code());
                    return;
                }
                //Grupo_De_Unidad_De_Medida (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Unidad_De_Medida_Base INTEGER, " +
                //            "Codigo TEXT, Nombre TEXT, Estado TEXT)
                SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
                db.execSQL("DELETE FROM Grupo_De_Unidad_De_Medida");
                Log.e("LogE","Exito "+response.code());
                List<Grupo_De_Unidad_De_Medida> grupo_de_unidad_de_medidas=response.body();
                for (Grupo_De_Unidad_De_Medida grupo_de_unidad_de_medida:grupo_de_unidad_de_medidas){
                    String SQLConsulta="INSERT INTO Grupo_De_Unidad_De_Medida (Id, Id_Unidad_De_Medida_Base, Codigo, Nombre, Estado) VALUES ('"+grupo_de_unidad_de_medida.getId()+
                            "', '"+grupo_de_unidad_de_medida.getId_Unidad_De_Medida_Base()+"', '"+grupo_de_unidad_de_medida.getCodigo()+"', '"+grupo_de_unidad_de_medida.getNombre()+
                            "', '"+grupo_de_unidad_de_medida.getEstado()+"')";
                    db.execSQL(SQLConsulta);
                }
            }
            @Override
            public void onFailure(Call<List<Grupo_De_Unidad_De_Medida>> call, Throwable t) {
                Log.e("LogE","Fallo ");
            }
        });
    }

    public void GetClientes(){
        Call<List<Cliente>> call=aranjuezJsonApi.getClientes("Cliente");
        call.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                if (!response.isSuccessful()){
                    Log.e("LogE","Error Cliente "+response.code());
                    return;
                }

                //Cliente (Id, Id_Desarrollador, Id_Preventista, Id_Distribuidor, Id_Isscom, Id_Nivel_Socioeconomico, Id_Lista_De_Precios, Generico, Codigo_SAP, Codigo_Ruta, Nombre, CI_O_NIT,
                // Razon_Social, Nombre_De_Referencia, Direccion, Referencia, Zona, Telefono, Celular, Preventa, Latitud, Longitud, Estado)
                SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
                db.execSQL("DELETE FROM Cliente");
                Log.e("LogE","Exito Cliente"+response.code());
                List<Cliente> clientes=response.body();
                for (Cliente cliente:clientes){
                    String SQLConsulta="INSERT INTO Cliente (Id, Id_Desarrollador, Id_Preventista, Id_Distribuidor, Id_Isscom, Id_Nivel_Socioeconomico, Id_Lista_De_Precios, Generico, Codigo_SAP, " +
                            "Codigo_Ruta, Nombre, CI_O_NIT, Razon_Social, Nombre_De_Referencia, Direccion, Referencia, Zona, Telefono, Celular, Preventa, Latitud, Longitud, Estado) VALUES " +
                            "('"+cliente.getId()+"', '"+cliente.getId_Desarrollador()+"', '"+cliente.getId_Preventista()+"', '"+cliente.getId_Distribuidor()+"', '"+cliente.getId_Isscom()+
                            "', '"+cliente.getId_Nivel_Socioeconomico()+"', '"+cliente.getId_Lista_De_Precios()+"', '"+cliente.getGenerico()+"', '"+cliente.getCodigo_SAP()+"', '"+cliente.getCodigo_Ruta()+
                            "', '"+cliente.getNombre()+"', '"+cliente.getCI_O_NIT()+"', '"+cliente.getRazon_Social()+"', '"+cliente.getNombre_De_Referencia()+"', '"+cliente.getDireccion()+
                            "', '"+cliente.getReferencia()+"', '"+cliente.getZona()+"', '"+cliente.getTelefono()+"', '"+cliente.getCelular()+"', '"+cliente.getPreventa()+"', '"+cliente.getLatitud()+
                            "', '"+cliente.getLongitud()+"', '"+cliente.getEstado()+"')";
                    db.execSQL(SQLConsulta);
                    Log.d("Cliente", cliente.getNombre());
                }
            }
            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                Log.e("LogE","Fallo Cliente");
            }
        });
    }

    public void ClientesSincronizar(){
        Call<List<Cliente>> call=aranjuezJsonApi.getClientes("Cliente");
        try {
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Cliente");
            List<Cliente> clientes=call.execute().body();
            for (Cliente cliente:clientes){
                String SQLConsulta="INSERT INTO Cliente (Id, Id_Desarrollador, Id_Preventista, Id_Distribuidor, Id_Isscom, Id_Nivel_Socioeconomico, Id_Lista_De_Precios, Generico, Codigo_SAP, " +
                        "Codigo_Ruta, Nombre, CI_O_NIT, Razon_Social, Nombre_De_Referencia, Direccion, Referencia, Zona, Telefono, Celular, Preventa, Latitud, Longitud, Estado) VALUES " +
                        "('"+cliente.getId()+"', '"+cliente.getId_Desarrollador()+"', '"+cliente.getId_Preventista()+"', '"+cliente.getId_Distribuidor()+"', '"+cliente.getId_Isscom()+
                        "', '"+cliente.getId_Nivel_Socioeconomico()+"', '"+cliente.getId_Lista_De_Precios()+"', '"+cliente.getGenerico()+"', '"+cliente.getCodigo_SAP()+"', '"+cliente.getCodigo_Ruta()+
                        "', '"+cliente.getNombre()+"', '"+cliente.getCI_O_NIT()+"', '"+cliente.getRazon_Social()+"', '"+cliente.getNombre_De_Referencia()+"', '"+cliente.getDireccion()+
                        "', '"+cliente.getReferencia()+"', '"+cliente.getZona()+"', '"+cliente.getTelefono()+"', '"+cliente.getCelular()+"', '"+cliente.getPreventa()+"', '"+cliente.getLatitud()+
                        "', '"+cliente.getLongitud()+"', '"+cliente.getEstado()+"')";
                db.execSQL(SQLConsulta);
                Log.d("Cliente", cliente.getNombre());
            }
            db.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ProductosSincronizar(){
        Call<List<Producto>> call=aranjuezJsonApi.getProductos("Producto");
        try{
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Producto");
            List<Producto> productos=call.execute().body();
            for (Producto producto:productos){
                String SQLConsulta="INSERT INTO Producto (Id, Id_Grupo, Id_Gasto_Adicional, Id_Grupo_De_Unidad_De_Medida, Codigo_SAP, Nombre, Descripcion, Alias, Centro_De_Costo, Producto_Terminado, " +
                        "Capacidad_En_Litros, Estado) VALUES ('"+producto.getId()+"', '"+producto.getId_Grupo()+"', '"+producto.getId_Gasto_Adicional()+"', '"+producto.getId_Grupo_De_Unidad_De_Medida()+
                        "', '"+producto.getCodigo_SAP()+"', '"+producto.getNombre()+"', '"+producto.getDescripcion()+"', '"+producto.getAlias()+"', '"+producto.getCentro_De_Costo()+
                        "', '"+producto.getProducto_Terminado()+"', '"+producto.getCapacidad_En_Litros()+"', '"+producto.getEstado()+"')";
                db.execSQL(SQLConsulta);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Lista_De_PreciosSincronizar(){
        Call<List<Lista_De_Precios>> call=aranjuezJsonApi.getLista_De_Precios("Producto");
        try{
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Lista_De_Precios");
            List<Lista_De_Precios> lista_de_precios=call.execute().body();
            for (Lista_De_Precios lista_de_precio:lista_de_precios){
                String SQLConsulta="INSERT INTO Lista_De_Precios (Id, Nombre, Estado) VALUES ('"+lista_de_precio.getId()+"', '"+lista_de_precio.getNombre()+"', '"+lista_de_precio.getEstado()+"')";
                db.execSQL(SQLConsulta);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Grupo_De_Unidad_De_MedidaSincronizar(){
        Call<List<Grupo_De_Unidad_De_Medida>> call=aranjuezJsonApi.getGrupo_De_Unidad_De_Medidas("Grupo_De_Unidad_De_Medida");
        try {
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Grupo_De_Unidad_De_Medida");
            List<Grupo_De_Unidad_De_Medida> grupo_de_unidad_de_medidas=call.execute().body();
            for (Grupo_De_Unidad_De_Medida grupo_de_unidad_de_medida:grupo_de_unidad_de_medidas){
                String SQLConsulta="INSERT INTO Grupo_De_Unidad_De_Medida (Id, Id_Unidad_De_Medida_Base, Codigo, Nombre, Estado) VALUES ('"+grupo_de_unidad_de_medida.getId()+
                        "', '"+grupo_de_unidad_de_medida.getId_Unidad_De_Medida_Base()+"', '"+grupo_de_unidad_de_medida.getCodigo()+"', '"+grupo_de_unidad_de_medida.getNombre()+
                        "', '"+grupo_de_unidad_de_medida.getEstado()+"')";
                db.execSQL(SQLConsulta);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Precio_De_ProductoSincronizar(){
        Call<List<Precio_De_Producto>> call=aranjuezJsonApi.getPrecio_De_Productos("Precio_De_Producto");
        try{
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Precio_De_Producto");
            List<Precio_De_Producto> precio_de_productos=call.execute().body();
            for (Precio_De_Producto precio_de_producto:precio_de_productos){
                String SQLConsulta="INSERT INTO Precio_De_Producto (Id, Id_Lista_De_Precios, Id_Producto, Id_Unidad_De_Medida, Precio, Porcentaje_De_Descuento, Estado) VALUES " +
                        "('"+precio_de_producto.getId()+"', '"+precio_de_producto.getId_Lista_De_Precios()+"', '"+precio_de_producto.getId_Producto()+"', '"+precio_de_producto.getId_Unidad_De_Medida()+
                        "', '"+precio_de_producto.getPrecio()+"', '"+precio_de_producto.getPorcentaje_De_Descuento()+"', '"+precio_de_producto.getEstado()+"')";
                db.execSQL(SQLConsulta);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Codigo_De_BarrasSincronizar(){
        Call<List<Codigo_De_Barras>> call=aranjuezJsonApi.getCodigo_De_Barras("Codigo_De_Barras");
        try {
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Codigo_De_Barras");
            List<Codigo_De_Barras> codigo_de_barras=call.execute().body();
            for (Codigo_De_Barras codigo_de_barra: codigo_de_barras){
                String SQLConsulta="INSERT INTO Codigo_De_Barras (Id, Id_Producto, Id_Unidad_De_Medida, Codigo_De_Barras, Estado) VALUES ('"+codigo_de_barra.getId()+"', '"+codigo_de_barra.getId_Producto()+
                        "', '"+codigo_de_barra.getId_Unidad_De_Medida()+"', '"+codigo_de_barra.getCodigo_De_Barras()+"', '"+codigo_de_barra.getEstado()+"')";
                db.execSQL(SQLConsulta);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

   public void Dias_De_VisitaSincronizar(){
        Call<List<Dias_De_Visita>> call=aranjuezJsonApi.getDias_De_Visita("Dias_De_Visita");
        try{
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Dias_De_Visita");
            List<Dias_De_Visita> dias_de_visitas=call.execute().body();
            for(Dias_De_Visita dias_de_visita:dias_de_visitas){
                String SQLConsulta="INSERT INTO Dias_De_Visita (Id, Id_Cliente, Tipo, Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo) VALUES ('"+dias_de_visita.getId()+
                        "', '"+dias_de_visita.getId_Cliente()+"', '"+dias_de_visita.getTipo()+"', '"+dias_de_visita.getLunes()+"', '"+dias_de_visita.getMartes()+"', '"+dias_de_visita.getMiercoles()+
                        "', '"+dias_de_visita.getJueves()+"', '"+dias_de_visita.getViernes()+"', '"+dias_de_visita.getSabado()+"', '"+dias_de_visita.getDomingo()+"')";
                db.execSQL(SQLConsulta);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
   }

    public void Detalle_De_Grupo_De_Unidad_De_MedidaSincronizar(){
        Call<List<Detalle_De_Grupo_De_Unidad_De_Medida>> call=aranjuezJsonApi.getDetalle_De_Grupo_De_Unidad_De_Medida("Detalle_De_Grupo_De_Unidad_De_Medida");
        try{
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Detalle_De_Grupo_De_Unidad_De_Medida");
            List<Detalle_De_Grupo_De_Unidad_De_Medida> detalle_de_grupo_de_unidad_de_medidas=call.execute().body();
            for (Detalle_De_Grupo_De_Unidad_De_Medida detalle_de_grupo_de_unidad_de_medida:detalle_de_grupo_de_unidad_de_medidas){
                String SQLConsulta="INSERT INTO Detalle_De_Grupo_De_Unidad_De_Medida (Id, Id_Grupo_De_Unidad_De_Medida, Id_Unidad_De_Medida_Alternativa, Cantidad_Alternativa, Cantidad_Base, Estado) VALUES " +
                        "('"+detalle_de_grupo_de_unidad_de_medida.getId()+"', '"+detalle_de_grupo_de_unidad_de_medida.getId_Grupo_De_Unidad_De_Medida()+
                        "', '"+detalle_de_grupo_de_unidad_de_medida.getId_Unidad_De_Medida_Alternativa()+"', '"+detalle_de_grupo_de_unidad_de_medida.getCantidad_Alternativa()+
                        "', '"+detalle_de_grupo_de_unidad_de_medida.getCantidad_Base()+"', '"+detalle_de_grupo_de_unidad_de_medida.getEstado()+"')";
                db.execSQL(SQLConsulta);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Unidad_De_MedidaSincronizar(){
        Call<List<Unidad_De_Medida>> call=aranjuezJsonApi.getUnidad_De_Medida("Unidad_De_Medida");
        try {
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Unidad_De_Medida");
            List<Unidad_De_Medida> unidad_de_medidas=call.execute().body();
            for (Unidad_De_Medida unidad_de_medida:unidad_de_medidas){
                String SQLConsulta="INSERT INTO Unidad_De_Medida (Id, UomEntry, Codigo, Nombre, Tipo, Estado) VALUES ('"+unidad_de_medida.getId()+"', '"+unidad_de_medida.getUomEntry()+
                        "', '"+unidad_de_medida.getCodigo()+"', '"+unidad_de_medida.getNombre()+"', '"+unidad_de_medida.getTipo()+"', '"+unidad_de_medida.getEstado()+"')";
                db.execSQL(SQLConsulta);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Unidad_De_Medida_De_ProductoSincronizar(){
        Call<List<Unidad_De_Medida_De_Producto>> call=aranjuezJsonApi.getUnidad_De_Medida_De_Producto("Unidad_De_Medida_De_Producto");
        try {
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Unidad_De_Medida_De_Producto");
            List<Unidad_De_Medida_De_Producto> unidad_de_medida_de_productos=call.execute().body();
            for (Unidad_De_Medida_De_Producto unidad_de_medida_de_producto:unidad_de_medida_de_productos){
                String SQLConsulta="INSERT INTO Unidad_De_Medida_De_Producto (Id, Id_Actividad_Economica, Id_Producto, Id_Unidad_De_Medida, Tipo, Estado) VALUES ('"+unidad_de_medida_de_producto.getId()+
                        "', '"+unidad_de_medida_de_producto.getId_Actividad_Economica()+"', '"+unidad_de_medida_de_producto.getId_Producto()+"', '"+unidad_de_medida_de_producto.getId_Unidad_De_Medida()+
                        "', '"+unidad_de_medida_de_producto.getTipo()+"', '"+unidad_de_medida_de_producto.getEstado()+"')";
                db.execSQL(SQLConsulta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Condicion_De_PagoSincronizar(){
        Call<List<Condicion_De_Pago>> call=aranjuezJsonApi.getCondicion_De_Pago("Condicion_De_Pago");
        try {
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Condicion_De_Pago");
            List<Condicion_De_Pago> condicion_de_pagos=call.execute().body();
            for (Condicion_De_Pago condicion_de_pago:condicion_de_pagos){
                String SQLConsulta="INSERT INTO Condicion_De_Pago (Id, GroupNum, Condicion, Meses_Extra, Dias_Extra, Estado) VALUES ('"+condicion_de_pago.getId()+"', '"+condicion_de_pago.getGroupNum()+
                        "', '"+condicion_de_pago.getCondicion()+"', '"+condicion_de_pago.getMeses_Extra()+"', '"+condicion_de_pago.getDias_Extra()+"', '"+condicion_de_pago.getEstado()+"')";
                db.execSQL(SQLConsulta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Tema_De_VisitaSincronizar(){
        Call<List<Tema_De_Visita>> call=aranjuezJsonApi.getTema_De_Visita("Tema_De_Visita");
        try {
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            db.execSQL("DELETE FROM Condicion_De_Pago");
            List<Tema_De_Visita> tema_de_visitas=call.execute().body();
            for (Tema_De_Visita tema_de_visita:tema_de_visitas) {
                String SQLConsulta="INSERT INTO Tema_De_Visita (Id, Descripcion, Estado) VALUES ('"+tema_de_visita.getId()+"', '"+tema_de_visita.getDescripcion()+"', '"+tema_de_visita.getEstado()+"')";
                db.execSQL(SQLConsulta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Id, Id_Actividad_Economica, Id_Producto, Id_Unidad_De_Medida, Tipo, Estado

    public void sincronizar(View view) {
        /*AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Sincronizar datos");
        alertDialog.setMessage("Desea actualizar los datos?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                GetProductos();
                GetClientes();
                Snackbar.make(getWindow().getDecorView().getRootView(), "Datos Actualizados", Snackbar.LENGTH_SHORT).show();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();*/
        SincronizarA();
    }

    public void SincronizarA(){
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Sincronizando");
        progressDialog.setMessage("Sincronizando");
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        final TareaAsincrona tareaAsincrona=new TareaAsincrona();

        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Sincronizar datos");
        alertDialog.setMessage("Desea actualizar datos?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tareaAsincrona.execute();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }



    private class  TareaAsincrona extends AsyncTask<Void, Integer, Boolean>{

        @Override
        protected Boolean doInBackground(Void... voids) {
            publishProgress(1);
            ClientesSincronizar();
            publishProgress(2);
            ProductosSincronizar();
            publishProgress(3);
            Lista_De_PreciosSincronizar();
            publishProgress(4);
            Grupo_De_Unidad_De_MedidaSincronizar();
            publishProgress(5);
            Precio_De_ProductoSincronizar();
            publishProgress(6);
            Codigo_De_BarrasSincronizar();
            publishProgress(7);
            Dias_De_VisitaSincronizar();
            publishProgress(8);
            Detalle_De_Grupo_De_Unidad_De_MedidaSincronizar();
            publishProgress(9);
            Unidad_De_MedidaSincronizar();
            publishProgress(10);
            Unidad_De_Medida_De_ProductoSincronizar();
            publishProgress(11);
            Condicion_De_PagoSincronizar();
            publishProgress(12);
            Tema_De_VisitaSincronizar();
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int progreso = values[0].intValue();

            progressDialog.setProgress(progreso);
            switch (progreso){
                case 1:
                    progressDialog.setMessage("Tabla Cliente");
                    break;
                case 2:
                    progressDialog.setMessage("Tabla Productos");
                    break;
                case 3:
                    progressDialog.setMessage("Tabla Lista de Precios");
                    break;
                case 4:
                    progressDialog.setMessage("Tabla Grupo de Unidad de Medida");
                    break;
                case 5:
                    progressDialog.setMessage("Tabla Precio de Producto");
                    break;
                case 6:
                    progressDialog.setMessage("Tabla Codigo de Barras");
                    break;
                case 7:
                    progressDialog.setMessage("Tabla Dias de Visita");
                    break;
                case 8:
                    progressDialog.setMessage("Tabla Detalle de Grupo de Unidad de Medida");
                    break;
                case 9:
                    progressDialog.setMessage("Tabla Unidad de Medida");
                    break;
                case 10:
                    progressDialog.setMessage("Tabla Unidad de Medida de Producto");
                    break;
                case 11:
                    progressDialog.setMessage("Tabla Condicion de Pago");
                    break;
                case 12:
                    progressDialog.setMessage("Tabla Tema de Visita");
                    break;
                case 13:
                    progressDialog.setMessage("Tabla Usuario");
                    break;
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setProgress(0);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            progressDialog.dismiss();
            Snackbar.make(getWindow().getDecorView().getRootView(), "Datos Actualizados", Snackbar.LENGTH_SHORT).show();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Toast.makeText(getApplicationContext(), "Tarea cancelada!", Toast.LENGTH_SHORT).show();
        }
    }
}