package com.example.aranjuez;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.aranjuez.entidades.ClienteVO;
import com.example.aranjuez.entidades.Preventa;

import java.util.ArrayList;

public class ClienteListadoActivity extends AppCompatActivity {
    ArrayList<ClienteVO> clientes;
    RecyclerView recyclerView;
    SQLiteHelper sqLiteHelper;
    ClienteAdapter clienteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_listado);

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null, 1);

        clientes=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerClientes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ClientesCargar();

        clienteAdapter=new ClienteAdapter(clientes);

        clienteAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id_Cliente=clientes.get(recyclerView.getChildAdapterPosition(v)).getId();
                Intent intent=new Intent(getApplicationContext(), PreventaActivity.class);
                intent.putExtra("idCliente", Id_Cliente);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(clienteAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.buscar_cliente, menu);

        MenuItem buscar=menu.findItem(R.id.buscarCliente);
        SearchView searchView=(SearchView) buscar.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                clienteAdapter.getFilter().filter(s);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void ClientesCargar() {
        SQLiteDatabase db=sqLiteHelper.getReadableDatabase();
        try{
            Cursor cursor=db.rawQuery("select * from Cliente", null);
            cursor.moveToFirst();
            while ( !cursor.isAfterLast()) {
                clientes.add(new ClienteVO(cursor.getString(cursor.getColumnIndex("Id")), cursor.getString(cursor.getColumnIndex("Codigo_SAP")),
                        cursor.getString(cursor.getColumnIndex("Nombre")), cursor.getString(cursor.getColumnIndex("CI_O_NIT")),
                        cursor.getString(cursor.getColumnIndex("Razon_Social")), cursor.getString(cursor.getColumnIndex("Direccion")),
                        cursor.getString(cursor.getColumnIndex("Telefono")), cursor.getString(cursor.getColumnIndex("Celular")),
                        cursor.getString(cursor.getColumnIndex("Estado"))));
                //Log.d("Cliente", cursor.getString(cursor.getColumnIndex("Nombre")));
                cursor.moveToNext();
            }

        }catch (Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
