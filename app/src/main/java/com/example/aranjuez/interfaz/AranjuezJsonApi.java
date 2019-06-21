package com.example.aranjuez.interfaz;

import com.example.aranjuez.entidades.Cliente;
import com.example.aranjuez.entidades.Grupo_De_Unidad_De_Medida;
import com.example.aranjuez.entidades.Lista_De_Precios;
import com.example.aranjuez.entidades.Precio_De_Producto;
import com.example.aranjuez.entidades.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
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
}
