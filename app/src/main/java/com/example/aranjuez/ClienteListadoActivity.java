package com.example.aranjuez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
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
        clientes.add(new ClienteVO("1", "5120", "Julio Cesar Beizaga Orozco", "5039296011", "Itasur Servicios Integrados", "Av. Heroes del Chaco", "46663341", "70224637", "Activo"));
        clientes.add(new ClienteVO("2", "5120", "Juan Pablo Beizaga Orozco", "5039296011", "Itasur Servicios Integrados", "Av. Heroes del Chaco", "46663341", "70224637", "Activo"));
        clientes.add(new ClienteVO("3", "5120", "Victor Hugo Beizaga Orozco", "5039296011", "Itasur Servicios Integrados", "Av. Heroes del Chaco", "46663341", "70224637", "Activo"));
        clientes.add(new ClienteVO("4", "5120", "Isabel Orozco de Beizaga", "5039296011", "Itasur Servicios Integrados", "Av. Heroes del Chaco", "46663341", "70224637", "Activo"));
    }
}
