package com.example.aranjuez;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.example.aranjuez.entidades.VisitaVO;

import java.util.ArrayList;

public class VisitaListadoActivity extends AppCompatActivity {
    ArrayList<VisitaVO> visitas;
    RecyclerView recyclerView;
    VisitaAdapter visitaAdapter;
    String Id_Visita, Id_Cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita_listado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.buscar_visitas, menu);

        visitas=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerVisitas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        VisitasCargar();

        visitaAdapter=new VisitaAdapter(visitas);

        visitaAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Id_Visita=visitas.get(recyclerView.getChildAdapterPosition(v)).getId();
                Id_Cliente="0";

                SharedPreferences sharedPreferences=getSharedPreferences("Visita", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("idCliente", Id_Cliente);
                editor.putString("idVisita", Id_Visita);
                editor.commit();

                Toast.makeText(getApplicationContext(), Id_Visita, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(visitaAdapter);

        /*MenuInflater inflater=getMenuInflater();
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
        });*/
        return super.onCreateOptionsMenu(menu);
    }

    private void VisitasCargar(){
        visitas.add(new VisitaVO("1", "Tema", "Julio Cesar Beizaga Orozco 1", "01/01/2019", "05:05", "No estaba", "Pendiente"));
        visitas.add(new VisitaVO("2", "Tema", "Julio Cesar Beizaga Orozco 2", "01/01/2019", "05:05", "No estaba", "Pendiente"));
        visitas.add(new VisitaVO("3", "Tema", "Julio Cesar Beizaga Orozco 3", "01/01/2019", "05:05", "No estaba", "Pendiente"));
        visitas.add(new VisitaVO("4", "Tema", "Julio Cesar Beizaga Orozco 4", "01/01/2019", "05:05", "No estaba", "Pendiente"));
        visitas.add(new VisitaVO("5", "Tema", "Julio Cesar Beizaga Orozco 5", "01/01/2019", "05:05", "No estaba", "Pendiente"));
    }

    public void NuevaVisita(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences("Opciones", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("Opcion", "Visita");
        editor.commit();

        Intent intent=new Intent(getApplicationContext(), ClienteListadoActivity.class);
        startActivity(intent);
    }
}
