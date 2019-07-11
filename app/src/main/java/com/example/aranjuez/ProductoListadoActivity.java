package com.example.aranjuez;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import com.example.aranjuez.entidades.ProductoVO;

import java.util.ArrayList;

public class ProductoListadoActivity extends AppCompatActivity {
    ArrayList<ProductoVO> productos;
    RecyclerView recyclerView;
    SQLiteHelper sqLiteHelper;
    ProductoAdapter productoAdapter;
    String Id_Lista_De_Precios, Id_Unidad_De_Medida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_listado);

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null,1);

        productos=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ProductosCargar();

        productoAdapter=new ProductoAdapter(productos);
        recyclerView.setAdapter(productoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.buscar_producto, menu);

        MenuItem buscar=menu.findItem(R.id.buscarProducto);
        SearchView searchView=(SearchView) buscar.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                productoAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void ProductosCargar() {
        Id_Lista_De_Precios="1";
        Id_Unidad_De_Medida="1"; //Botella

        SQLiteDatabase db=sqLiteHelper.getReadableDatabase();
        try {
            Cursor cursor=db.rawQuery("select Producto.*, (select Codigo_De_Barras.Codigo_De_Barras from Codigo_De_Barras where Codigo_De_Barras.Id_Producto=Producto.Id) as CodigoBarras, " +
                    "(select Precio_De_Producto.Precio from Precio_De_Producto where (Precio_De_Producto.Id_Lista_De_Precios='"+Id_Lista_De_Precios+"') and " +
                    "(Precio_De_Producto.Id_Unidad_De_Medida='"+Id_Unidad_De_Medida+"') and (Precio_De_Producto.Id_Producto=Producto.Id)) as Precio from Producto", null);
            cursor.moveToFirst();
            while ( !cursor.isAfterLast()) {
                productos.add(new ProductoVO(cursor.getString(cursor.getColumnIndex("Id")), cursor.getString(cursor.getColumnIndex("Codigo_SAP")),
                        cursor.getString(cursor.getColumnIndex("CodigoBarras")), cursor.getString(cursor.getColumnIndex("Descripcion")),
                        cursor.getString(cursor.getColumnIndex("Capacidad_En_Litros")), cursor.getString(cursor.getColumnIndex("Precio"))));
                cursor.moveToNext();
            }
            db.close();
            cursor.close();
        }catch ( Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void FiltrarPrecios(MenuItem item) {
        Toast.makeText(getApplicationContext(), "Filtro", Toast.LENGTH_SHORT).show();
    }
}
