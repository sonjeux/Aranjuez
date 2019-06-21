package com.example.aranjuez;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aranjuez.entidades.Detalle_De_PreventaVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class PreventaActivity extends AppCompatActivity {
    ArrayList<Detalle_De_PreventaVO> detalle_de_preventas;
    RecyclerView recyclerView;
    SQLiteHelper sqLiteHelper;
    String Id_Cliente, CodigoPreventa;
    TextView Nit, CodigoSap, ClienteNombre, Telefono, Celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventa);

        Nit=findViewById(R.id.textVNit);
        CodigoSap=findViewById(R.id.textVCodigoSap);
        ClienteNombre=findViewById(R.id.textVClienteNombre);
        Telefono=findViewById(R.id.textVTelefono);
        Celular=findViewById(R.id.textVCelular);

        Id_Cliente = getIntent().getExtras().getString("idCliente");

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null, 1);

        detalle_de_preventas=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerPreventaDetalle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DetalleCargar();

        PreventaDetalleAdapter preventaDetalleAdapter=new PreventaDetalleAdapter(detalle_de_preventas);
        recyclerView.setAdapter(preventaDetalleAdapter);

        UsuarioCargar();

        GenerarCodigoPreventa();
    }

    private void GenerarCodigoPreventa() {
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        CodigoPreventa=simpleDateFormat.format(calendar.getTime());
        Toast.makeText(getApplicationContext(), CodigoPreventa, Toast.LENGTH_SHORT).show();
    }

    private void UsuarioCargar() {
        SQLiteDatabase db=sqLiteHelper.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("select Cliente.* from Cliente where Id=" + Id_Cliente.toString(), null);
            cursor.moveToFirst();

            Nit.setText(cursor.getString(cursor.getColumnIndex("CI_O_NIT")));
            CodigoSap.setText(cursor.getString(cursor.getColumnIndex("Codigo_SAP")));
            ClienteNombre.setText(cursor.getString(cursor.getColumnIndex("Nombre")));

            if(cursor.isNull(cursor.getColumnIndex("Telefono"))){
                Telefono.setText(" ");
            }
            else {
                Telefono.setText(cursor.getString(cursor.getColumnIndex("Telefono")));
            }

            if(cursor.isNull(cursor.getColumnIndex("Celular"))){
                Celular.setText(" ");
            }
            else {
                Celular.setText(cursor.getString(cursor.getColumnIndex("Celular")));
            }

        }catch ( Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void DetalleCargar() {
        detalle_de_preventas.add(new Detalle_De_PreventaVO("1", "1", "12101", "10210", "Vino 01", "10", "15", "150"));
        detalle_de_preventas.add(new Detalle_De_PreventaVO("1", "1", "12101", "10210", "Vino 01", "10", "15", "150"));
        detalle_de_preventas.add(new Detalle_De_PreventaVO("1", "1", "12101", "10210", "Vino 01", "10", "15", "150"));
        detalle_de_preventas.add(new Detalle_De_PreventaVO("1", "1", "12101", "10210", "Vino 01", "10", "15", "150"));
        detalle_de_preventas.add(new Detalle_De_PreventaVO("1", "1", "12101", "10210", "Vino 01", "10", "15", "150"));
    }

    public void AgregarProducto(View view) {
        Intent intent=new Intent(getApplicationContext(), PreventaProductoActivity.class);
        startActivity(intent);
    }
}
