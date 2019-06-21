package com.example.aranjuez;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.aranjuez.entidades.ProductoVO;

import java.util.ArrayList;

public class PreventaProductoActivity extends AppCompatActivity {
    ArrayList<ProductoVO> productos;
    RecyclerView recyclerView;
    SQLiteHelper sqLiteHelper;
    ProductoAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventa_producto);

        getSupportActionBar().setTitle("Seleccione un Producto");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null,1);

        productos=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerPreventaProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ProductosCargar();

        /*  clienteAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id_Cliente=clientes.get(recyclerView.getChildAdapterPosition(v)).getId();
                Intent intent=new Intent(getApplicationContext(), PreventaActivity.class);
                intent.putExtra("idCliente", Id_Cliente);
                startActivity(intent);
            }
        });*/

        productoAdapter=new ProductoAdapter(productos);
        productoAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id_Producto=productos.get(recyclerView.getChildAdapterPosition(v)).getId();
                Toast.makeText(getApplicationContext(), Id_Producto, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(productoAdapter);
    }

    private void ProductosCargar() {
        SQLiteDatabase db=sqLiteHelper.getReadableDatabase();
        try {

            Cursor cursor=db.rawQuery("select * from Producto", null);
            cursor.moveToFirst();
            while ( !cursor.isAfterLast()) {
                productos.add(new ProductoVO(cursor.getString(cursor.getColumnIndex("Id")), cursor.getString(cursor.getColumnIndex("Codigo_SAP")),
                        cursor.getString(cursor.getColumnIndex("Codigo_SAP")), cursor.getString(cursor.getColumnIndex("Descripcion")),
                        cursor.getString(cursor.getColumnIndex("Capacidad_En_Litros")), cursor.getString(cursor.getColumnIndex("Capacidad_En_Litros"))));
                cursor.moveToNext();
            }
            db.close();
        }catch ( Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
