package com.example.aranjuez;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    String Id_Preventa, Id_Cliente, Id_Lista_De_Precios, CodigoPreventa, Fecha, Hora, Estado;
    TextView Nit, CodigoSap, ClienteNombre, Telefono, Celular;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventa);

        Nit=findViewById(R.id.textVCodigoSap);
        CodigoSap=findViewById(R.id.textVCodigoSap);
        ClienteNombre=findViewById(R.id.textVProductoNombre);
        Telefono=findViewById(R.id.textVTelefono);
        Celular=findViewById(R.id.textVCelular);

        Id_Cliente = getIntent().getExtras().getString("idCliente");
        Id_Preventa = getIntent().getExtras().getString("idPreventa");

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null, 1);

        detalle_de_preventas=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerPreventaDetalle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PreventaDetalleAdapter preventaDetalleAdapter=new PreventaDetalleAdapter(detalle_de_preventas);
        recyclerView.setAdapter(preventaDetalleAdapter);

        if (Id_Preventa.equals("0")){
            NuevaPreventa();
        } else {

        }
        UsuarioCargar();

        //GenerarCodigoPreventa();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //detalle_de_preventas.clear();
        DetalleCargar();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        getIntent().putExtra("idPreventa", Id_Preventa);
        startActivity(getIntent());
    }

    public void NuevaPreventa(){
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormatFecha=new SimpleDateFormat("yyyy-MM-dd");
        Fecha=simpleDateFormatFecha.format(calendar.getTime());
        SimpleDateFormat simpleDateFormatHora=new SimpleDateFormat("HH:mm:ss");
        Hora=simpleDateFormatHora.format(calendar.getTime());

        Estado="Pendiente";

        db=sqLiteHelper.getWritableDatabase();
        String SQLConsulta="INSERT INTO Preventa (Id, Id_Usuario, Id_Dispositivo, Id_Condicion_De_Pago, Id_Numeracion_De_Documento, Id_Preventista, Id_Cliente, Id_Preventa_Dispositivo, DocEntry, " +
                "Codigo_SAP, Fecha, Hora, Latitud, Longitud, Total_De_Litros, Subtotal, Descuento, Monto_Para_Credito_Fiscal, IVA, ICE, Total, Total_A_Pagar, Observaciones, Estado, Sincronizada) " +
                "VALUES ('1', '2', '3', '4', '5', '6', '"+Id_Cliente+"', '1', 'DocEntry', " +
                "'Codigo_SAP', '"+Fecha+"', '"+Hora+"', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 'Observaciones', '"+Estado+"', '0')";
        db.execSQL(SQLConsulta);

        Cursor cursor=db.rawQuery("select MAX(_id) from Preventa", null);
        cursor.moveToFirst();
        Id_Preventa=cursor.getString(0);

        db.close();
        cursor.close();
    }

    private void GenerarCodigoPreventa() {
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        CodigoPreventa=simpleDateFormat.format(calendar.getTime());
        Toast.makeText(getApplicationContext(), CodigoPreventa, Toast.LENGTH_SHORT).show();
    }

    private void UsuarioCargar() {
        db=sqLiteHelper.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("select Cliente.* from Cliente where Id=" + Id_Cliente.toString(), null);
            cursor.moveToFirst();

            Nit.setText(cursor.getString(cursor.getColumnIndex("CI_O_NIT")));
            CodigoSap.setText(cursor.getString(cursor.getColumnIndex("Codigo_SAP")));
            ClienteNombre.setText(cursor.getString(cursor.getColumnIndex("Nombre")));
            Id_Lista_De_Precios=cursor.getString(cursor.getColumnIndex("Id_Lista_De_Precios"));

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
            db.close();
            cursor.close();
        }catch ( Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void DetalleCargar() {
        db=sqLiteHelper.getReadableDatabase();
        try{
            String consulta="select Detalle_De_Preventa.*, (select Producto.Nombre from Producto where Producto.Id=Detalle_De_Preventa.Id_Producto) as ProductoNombre " +
                    "from Detalle_De_Preventa where Id_Preventa='"+Id_Preventa+"'";

            Log.d("DetallleSQL", consulta);

            Cursor cursor=db.rawQuery(consulta, null);
            cursor.moveToFirst();
            detalle_de_preventas.clear();
            while (!cursor.isAfterLast()){
                detalle_de_preventas.add(new Detalle_De_PreventaVO(cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("Id_Preventa")),
                        "00101", "0101010", cursor.getString(cursor.getColumnIndex("ProductoNombre")), cursor.getString(cursor.getColumnIndex("Cantidad")),
                        cursor.getString(cursor.getColumnIndex("Precio_Unitario")), cursor.getString(cursor.getColumnIndex("Total"))));
                cursor.moveToNext();
            }
            db.close();
            cursor.close();
        }catch ( Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void AgregarProducto(View view) {
        Intent intent=new Intent(getApplicationContext(), PreventaProductoActivity.class);
        intent.putExtra("idPreventa", Id_Preventa);
        intent.putExtra("idListaPrecios", Id_Lista_De_Precios);
        startActivity(intent);
    }
}
