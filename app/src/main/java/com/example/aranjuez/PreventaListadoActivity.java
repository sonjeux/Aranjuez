package com.example.aranjuez;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import com.example.aranjuez.entidades.PreventaVO;

import java.util.ArrayList;

public class PreventaListadoActivity extends AppCompatActivity {
    ArrayList<PreventaVO> preventas;
    RecyclerView recyclerView;
    SQLiteHelper sqLiteHelper;
    PreventaAdapter preventaAdapter;
    String Id_Cliente, Id_Preventa;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventa_listado);

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null, 1);

        preventas=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerPreventas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PreventasCargar();

        preventaAdapter=new PreventaAdapter(preventas);
        preventaAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Id_Preventa=preventas.get(recyclerView.getChildAdapterPosition(v)).getId();
                db=sqLiteHelper.getReadableDatabase();
                Cursor cursor=db.rawQuery("select * from Preventa where _id='"+Id_Preventa+"'", null);
                cursor.moveToFirst();
                Id_Cliente=cursor.getString(cursor.getColumnIndex("Id_Cliente"));

                Intent intent=new Intent(getApplicationContext(), PreventaActivity.class);
                intent.putExtra("idCliente", Id_Cliente);
                intent.putExtra("idPreventa", Id_Preventa);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(preventaAdapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.buscar_preventas, menu);

        MenuItem buscar=menu.findItem(R.id.buscarPreventas);
        SearchView searchView=(SearchView) buscar.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                preventaAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void PreventasCargar() {
        db=sqLiteHelper.getReadableDatabase();
        try {
            Cursor cursor=db.rawQuery("select Preventa.*, (select Cliente.Nombre from Cliente where Cliente.Id=Preventa.Id_Cliente) as ClienteNombte from Preventa order by _id desc", null);
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                preventas.add(new PreventaVO(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("Fecha")), cursor.getString(cursor.getColumnIndex("Hora")),
                        cursor.getString(cursor.getColumnIndex("ClienteNombte")), cursor.getString(cursor.getColumnIndex("Total")), cursor.getString(cursor.getColumnIndex("Estado"))));
                cursor.moveToNext();
            }
            db.close();
            cursor.close();
        }catch ( Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void BuscarCliente(View view) {
        Intent intent=new Intent(getApplicationContext(), ClienteListadoActivity.class);
        startActivity(intent);
    }
}
