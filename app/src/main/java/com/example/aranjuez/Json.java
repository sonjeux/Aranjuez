package com.example.aranjuez;

import android.support.design.widget.Snackbar;
import android.util.Log;

import com.example.aranjuez.entidades.Producto;
import com.example.aranjuez.interfaz.AranjuezJsonApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Json {
    public static  AranjuezJsonApi aranjuezJsonApi;

    public static void ConfiguracionJson(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.0.13:8081/servicios/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aranjuezJsonApi=retrofit.create(AranjuezJsonApi.class);
    }

    public static void GetProductos(){
        Call<List<Producto>> call=aranjuezJsonApi.getProductos("Producto");
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (!response.isSuccessful()){
                    Log.e("LogE","Error "+response.code());
                    return;
                }
                Log.e("LogE","Exito "+response.code());
                List<Producto> productos=response.body();
                for (Producto producto:productos){
                    Log.e("JSON", producto.getNombre());
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.e("LogE","Fallo ");
            }
        });
    }
}
