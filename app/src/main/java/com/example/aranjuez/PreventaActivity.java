package com.example.aranjuez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.aranjuez.entidades.Detalle_De_PreventaVO;

import java.util.ArrayList;

public class PreventaActivity extends AppCompatActivity {
    ArrayList<Detalle_De_PreventaVO> detalle_de_preventas;
    RecyclerView recyclerView;
    SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventa);
        String Id_Cliente = getIntent().getExtras().getString("idCliente");
        Toast.makeText(getApplicationContext(), Id_Cliente, Toast.LENGTH_SHORT).show();

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null, 1);

        detalle_de_preventas=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerPreventaDetalle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DetalleCargar();

        PreventaDetalleAdapter preventaDetalleAdapter=new PreventaDetalleAdapter(detalle_de_preventas);
        recyclerView.setAdapter(preventaDetalleAdapter);
    }

    private void DetalleCargar() {
        detalle_de_preventas.add(new Detalle_De_PreventaVO("1", "1", "12101", "10210", "Vino 01", "10", "15", "150"));
        detalle_de_preventas.add(new Detalle_De_PreventaVO("1", "1", "12101", "10210", "Vino 01", "10", "15", "150"));
        detalle_de_preventas.add(new Detalle_De_PreventaVO("1", "1", "12101", "10210", "Vino 01", "10", "15", "150"));
        detalle_de_preventas.add(new Detalle_De_PreventaVO("1", "1", "12101", "10210", "Vino 01", "10", "15", "150"));
        detalle_de_preventas.add(new Detalle_De_PreventaVO("1", "1", "12101", "10210", "Vino 01", "10", "15", "150"));
    }

    /*
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
    }*/

}
