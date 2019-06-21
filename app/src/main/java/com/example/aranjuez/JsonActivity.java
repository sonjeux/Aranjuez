package com.example.aranjuez;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.aranjuez.entidades.Cliente;
import com.example.aranjuez.entidades.Grupo_De_Unidad_De_Medida;
import com.example.aranjuez.entidades.Lista_De_Precios;
import com.example.aranjuez.entidades.Precio_De_Producto;
import com.example.aranjuez.entidades.Producto;
import com.example.aranjuez.interfaz.AranjuezJsonApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonActivity extends AppCompatActivity {

    AranjuezJsonApi aranjuezJsonApi;
    SQLiteHelper sqLiteHelper;
    String urlBase;

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

    public void sincronizar(View view) {
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
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
        alertDialog.show();
    }
}