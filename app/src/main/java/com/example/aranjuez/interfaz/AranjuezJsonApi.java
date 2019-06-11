package com.example.aranjuez.interfaz;

import com.example.aranjuez.entidades.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AranjuezJsonApi {
    @GET("todo.php")
    Call<List<Producto>> getProductos(@Query("Tabla") String Tabla);
}
