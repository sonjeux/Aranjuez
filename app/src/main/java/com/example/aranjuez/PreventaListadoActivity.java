package com.example.aranjuez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.aranjuez.entidades.PreventaVO;

import java.util.ArrayList;

public class PreventaListadoActivity extends AppCompatActivity {
    ArrayList<PreventaVO> preventas;
    RecyclerView recyclerView;
    SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventa_listado);

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null, 1);

        preventas=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerPreventas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PreventasCargar();

        PreventaAdapter preventaAdapter=new PreventaAdapter(preventas);
        recyclerView.setAdapter(preventaAdapter);
    }

    private void PreventasCargar() {
        preventas.add(new PreventaVO("1", "01/02/2019", "16:35", "Julio Cesar Beizaga Orozco", "182.50", "Pendiente"));
        preventas.add(new PreventaVO("1", "01/02/2019", "16:35", "Julio Cesar Beizaga Orozco", "182.50", "Pendiente"));
        preventas.add(new PreventaVO("1", "01/02/2019", "16:35", "Julio Cesar Beizaga Orozco", "182.50", "Pendiente"));
        preventas.add(new PreventaVO("1", "01/02/2019", "16:35", "Julio Cesar Beizaga Orozco", "182.50", "Pendiente"));
        preventas.add(new PreventaVO("1", "01/02/2019", "16:35", "Julio Cesar Beizaga Orozco", "182.50", "Pendiente"));
        preventas.add(new PreventaVO("1", "01/02/2019", "16:35", "Julio Cesar Beizaga Orozco", "182.50", "Pendiente"));
        preventas.add(new PreventaVO("1", "01/02/2019", "16:35", "Julio Cesar Beizaga Orozco", "182.50", "Pendiente"));
        preventas.add(new PreventaVO("1", "01/02/2019", "16:35", "Julio Cesar Beizaga Orozco", "182.50", "Pendiente"));
        preventas.add(new PreventaVO("1", "01/02/2019", "16:35", "Julio Cesar Beizaga Orozco", "182.50", "Pendiente"));
    }

    public void BuscarCliente(View view) {
        Intent intent=new Intent(getApplicationContext(), ClienteListadoActivity.class);
        startActivity(intent);
    }
}
