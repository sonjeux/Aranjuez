package com.example.aranjuez.interfaz;

import com.example.aranjuez.entidades.Area;
import com.example.aranjuez.entidades.Cliente;
import com.example.aranjuez.entidades.Codigo_De_Barras;
import com.example.aranjuez.entidades.Detalle_De_Grupo_De_Unidad_De_Medida;
import com.example.aranjuez.entidades.Detalle_De_Preventa;
import com.example.aranjuez.entidades.Dias_De_Visita;
import com.example.aranjuez.entidades.Grupo_De_Unidad_De_Medida;
import com.example.aranjuez.entidades.Lista_De_Precios;
import com.example.aranjuez.entidades.Precio_De_Producto;
import com.example.aranjuez.entidades.Preventa;
import com.example.aranjuez.entidades.Producto;
import com.example.aranjuez.entidades.Unidad_De_Medida;
import com.example.aranjuez.entidades.Unidad_De_Medida_De_Producto;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AranjuezJsonApi {
    @GET("todo.php")
    Call<List<Producto>> getProductos(@Query("Tabla") String Tabla);

    @GET("todo.php")
    Call<List<Precio_De_Producto>> getPrecio_De_Productos(@Query("Tabla") String Tabla);

    @GET("todo.php")
    Call<List<Lista_De_Precios>> getLista_De_Precios(@Query("Tabla") String Tabla);

    @GET("todo.php")
    Call<List<Grupo_De_Unidad_De_Medida>> getGrupo_De_Unidad_De_Medidas(@Query("Tabla") String Tabla);

    @GET("todo.php")
    Call<List<Cliente>> getClientes(@Query("Tabla") String Tabla);

    @GET("todo.php")
    Call<List<Codigo_De_Barras>> getCodigo_De_Barras(@Query("Tabla") String Tabla);

    @GET("todo.php")
    Call<List<Dias_De_Visita>> getDias_De_Visita(@Query("Tabla") String Tabla);

    @GET("todo.php")
    Call<List<Detalle_De_Grupo_De_Unidad_De_Medida>> getDetalle_De_Grupo_De_Unidad_De_Medida(@Query("Tabla") String Tabla);

    @GET("todo.php")
    Call<List<Unidad_De_Medida>> getUnidad_De_Medida(@Query("Tabla") String Tabla);

    @GET("todo.php")
    Call<List<Unidad_De_Medida_De_Producto>> getUnidad_De_Medida_De_Producto(@Query("Tabla") String Tabla);

    @GET("todo.php")
    Call<List<Preventa>> getPreventa(@Query("Tabla") String Tabla);

    @GET("todo.php")
    Call<List<Detalle_De_Preventa>> getDetalle_De_Preventa(@Query("Tabla") String Tabla);

    @FormUrlEncoded
    @POST("txt.php")
    Call<Area> postArea(@FieldMap Map<String, String> map);
}
