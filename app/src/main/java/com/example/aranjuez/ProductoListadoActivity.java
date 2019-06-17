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

        /*
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(), query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Log.d("Buscar", newText);
                adaptador.getFilter().filter(newText);
                return true;
            }
        });*/

        return super.onCreateOptionsMenu(menu);
    }

    private void ProductosCargar() {
        SQLiteDatabase db=sqLiteHelper.getReadableDatabase();
        try {

            Cursor cursor=db.rawQuery("select * from Producto", null);
            cursor.moveToFirst();
            while ( !cursor.isAfterLast()) {
                //SQLProducto="CREATE TABLE Producto (_id INTEGER PRIMARY KEY AUTOINCREMENT, Id INTEGER, Id_Grupo INTEGER, Id_Gasto_Adicional INTEGER, Id_Grupo_De_Unidad_De_Medida INTEGER, " +
                //            "Codigo_SAP TEXT, Nombre TEXT, Descripcion TEXT, Alias TEXT, Centro_De_Costo TEXT, Producto_Terminado TEXT, Capacidad_En_Litros NUMERIC, Estado TEXT)";
                productos.add(new ProductoVO(cursor.getString(cursor.getColumnIndex("Id")), cursor.getString(cursor.getColumnIndex("Codigo_SAP")),
                        cursor.getString(cursor.getColumnIndex("Codigo_SAP")), cursor.getString(cursor.getColumnIndex("Descripcion")),
                        cursor.getString(cursor.getColumnIndex("Capacidad_En_Litros")), cursor.getString(cursor.getColumnIndex("Capacidad_En_Litros"))));

                Log.d("DB", cursor.getString(cursor.getColumnIndex("Descripcion"))+" "+cursor.getString(cursor.getColumnIndex("Codigo_SAP"))+" "+
                        cursor.getString(cursor.getColumnIndex("Capacidad_En_Litros")));
                cursor.moveToNext();
            }
            db.close();
        }catch ( Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
