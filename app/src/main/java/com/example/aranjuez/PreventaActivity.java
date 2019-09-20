package com.example.aranjuez;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aranjuez.entidades.Detalle_De_PreventaVO;
import com.example.aranjuez.entidades.Preventa;
import com.example.aranjuez.entidades.Respuesta;
import com.example.aranjuez.interfaz.AranjuezJsonApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class PreventaActivity extends AppCompatActivity implements PreventaNotaDialog.PreventaNotaDialogListener{
    ArrayList<Detalle_De_PreventaVO> detalle_de_preventas;
    RecyclerView recyclerView;
    SQLiteHelper sqLiteHelper;
    String Id_Usuario, Id_Dispositivo, Id_Preventa, Id_Cliente, Id_Lista_De_Precios, Id_Condicion_De_Pago, Id_Preventista, CodigoPreventa, Fecha, Hora, Nota, Estado, idCondicion, Condicion;
    TextView Nit, CodigoSap, ClienteNombre, Total, EstadoT;
    SQLiteDatabase db;
    Double TotalTotal, TotalLitros, TotalSubtotal, TotalDescuento, TotalMontoCreditoFiscal, TotalIva, TotalIce, TotalTotalAPagar;
    Button buttonFinalizar;
    FloatingActionButton fabAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventa);

        Nit=findViewById(R.id.textVCodigoSap);
        CodigoSap=findViewById(R.id.textVCodigoSap);
        ClienteNombre=findViewById(R.id.textVProductoNombre);
        Total=findViewById(R.id.textVTotal);
        EstadoT=findViewById(R.id.textVEstado);
        buttonFinalizar=findViewById(R.id.BotonFinalizar);
        fabAgregar=findViewById(R.id.fabAgregar);

        Id_Cliente = getIntent().getExtras().getString("idCliente");
        Id_Preventa = getIntent().getExtras().getString("idPreventa");

        Nota="";
        idCondicion="";

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null, 1);

        detalle_de_preventas=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerPreventaDetalle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PreventaDetalleAdapter preventaDetalleAdapter=new PreventaDetalleAdapter(detalle_de_preventas);
        recyclerView.setAdapter(preventaDetalleAdapter);

        if (Id_Preventa.equals("0")){
            NuevaPreventa();
        } else {
            PreventaCargar();
        }
        UsuarioCargar();

        MostrarOcultar();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_preventa, menu);
        MenuItem notaMenu=menu.findItem(R.id.botonNota);
        if (Estado.equals("Finalizado")){
            notaMenu.setVisible(true);
        } else {
            notaMenu.setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void NuevaPreventa(){
        SharedPreferences preferences=getSharedPreferences("configuracion", Context.MODE_PRIVATE);
        Id_Usuario=preferences.getString("Id_Usuario", "0");
        Id_Dispositivo=preferences.getString("Id_Dispositivo", "0");

        Id_Condicion_De_Pago="0";
        Id_Preventista="0";

        CodigoPreventa=GenerarCodigoPreventa(Id_Usuario);

        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormatFecha=new SimpleDateFormat("yyyy-MM-dd");
        Fecha=simpleDateFormatFecha.format(calendar.getTime());
        SimpleDateFormat simpleDateFormatHora=new SimpleDateFormat("HH:mm:ss");
        Hora=simpleDateFormatHora.format(calendar.getTime());

        Estado="Pendiente";
        Nota="";
        idCondicion="";

        db=sqLiteHelper.getWritableDatabase();
        String SQLConsulta="INSERT INTO Preventa (Id, Id_Usuario, Id_Dispositivo, Id_Condicion_De_Pago, Id_Numeracion_De_Documento, Id_Preventista, Id_Cliente, Id_Preventa_Dispositivo, DocEntry, " +
                "Codigo_SAP, Fecha, Hora, Latitud, Longitud, Total_De_Litros, Subtotal, Descuento, Monto_Para_Credito_Fiscal, IVA, ICE, Total, Total_A_Pagar, Observaciones, Estado, Sincronizada) " +
                "VALUES ('"+CodigoPreventa+"', '"+Id_Usuario+"', '"+Id_Dispositivo+"', '1', NULL, '6', '"+Id_Cliente+"', '1', '', " +
                "'Codigo_SAP', '"+Fecha+"', '"+Hora+"', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '', '"+Estado+"', '0')";
        db.execSQL(SQLConsulta);

        /*Cursor cursor=db.rawQuery("select MAX(_id) from Preventa", null);
        cursor.moveToFirst();
        Id_Preventa=cursor.getString(0);*/
        Id_Preventa=CodigoPreventa;

        db.close();
        //cursor.close();
    }

    private String GenerarCodigoPreventa(String IdUsuario) {
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        CodigoPreventa=IdUsuario+"-"+simpleDateFormat.format(calendar.getTime());
        return CodigoPreventa;
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

            db.close();
            cursor.close();
        }catch ( Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void PreventaCargar(){
        db=sqLiteHelper.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("select (select Condicion_De_Pago.Condicion from Condicion_De_Pago where Condicion_De_Pago.Id=Preventa.Id_Condicion_De_Pago) as Condicion, Preventa.* from Preventa where Id='"+Id_Preventa+"'", null);
            cursor.moveToFirst();
            Nota=cursor.getString(cursor.getColumnIndex("Observaciones"));
            Estado=cursor.getString(cursor.getColumnIndex("Estado"));
            Condicion=cursor.getString(cursor.getColumnIndex("Condicion"));

            db.close();
            cursor.close();
        } catch ( Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void PreventaEstado(){
        db=sqLiteHelper.getWritableDatabase();
        try {
            db.execSQL("update Preventa set Estado='Finalizado', Id_Condicion_De_Pago='"+idCondicion+"', Observaciones='"+Nota+"' where Id='"+Id_Preventa+"'");
            db.close();
            Estado="Finalizado";
            MostrarOcultar();
            Snackbar.make(getWindow().getDecorView().getRootView(), "Preventa finalizada", Snackbar.LENGTH_SHORT).show();
        } catch ( Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void MostrarOcultar(){
        if (Estado.equals("Finalizado")){
            buttonFinalizar.setVisibility(View.GONE);
            //fabAgregar.hide();
            fabAgregar.setEnabled(false);
            fabAgregar.setClickable(false);
            fabAgregar.setAlpha(0.0f);
            EstadoT.setText("Finalizado");
        } else {
            buttonFinalizar.setVisibility(View.VISIBLE);
            //fabAgregar.hide();
            fabAgregar.setEnabled(true);
            fabAgregar.setClickable(true);
            fabAgregar.setAlpha(1f);
            EstadoT.setText("Pendiente");
        }
    }

    private void DetalleCargar() {
        db=sqLiteHelper.getReadableDatabase();
        try{
            //Double TotalTotal, TotalLitros, TotalSubtotal, TotalDescuento, TotalMontoCreditoFiscal, TotalIva, TotalIce, TotalTotalAPagar;
            TotalTotal=0.0;
            TotalLitros=0.0;
            TotalDescuento=0.0;
            TotalIva=0.0;
            TotalIce=0.0;
            TotalSubtotal=0.0;
            TotalTotalAPagar=0.0;
            TotalMontoCreditoFiscal=0.0;

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

                TotalLitros+=Double.parseDouble(cursor.getString(cursor.getColumnIndex("Litros")));
                TotalTotal+=Double.parseDouble(cursor.getString(cursor.getColumnIndex("Total")));

                TotalDescuento+=Double.parseDouble(cursor.getString(cursor.getColumnIndex("Descuento")));
                TotalIva+=Double.parseDouble(cursor.getString(cursor.getColumnIndex("IVA")));
                TotalIce+=Double.parseDouble(cursor.getString(cursor.getColumnIndex("ICE")));

                cursor.moveToNext();
            }

            TotalSubtotal=TotalTotal-TotalIce;
            TotalTotalAPagar=TotalTotal-TotalDescuento;
            TotalMontoCreditoFiscal=TotalTotal-TotalIce-TotalDescuento;

            Total.setText(Double.toString(TotalTotal));

            /*Subtotal, Total_A_Pagar, Monto_Para_Credito_Fiscal

            -[Total_De_Litros]
            x [Subtotal]
            -[Descuento]
            x [Monto_Para_Credito_Fiscal]
            -[IVA]
            -[ICE]
            -[Total] TotalTotal
            x [Total_A_Pagar]
            */
            SQLiteDatabase db=sqLiteHelper.getWritableDatabase();
            consulta="UPDATE Preventa SET Total_De_Litros='"+Double.toString(TotalLitros)+"', Total='"+Double.toString(TotalTotal)+"', Descuento='"+Double.toString(TotalDescuento)+
                    "', IVA='"+Double.toString(TotalIva)+"', ICE='"+Double.toString(TotalIce)+"', Subtotal='"+TotalSubtotal+"', Monto_Para_Credito_Fiscal='"+TotalMontoCreditoFiscal+
                    "', Total_A_Pagar='"+TotalTotalAPagar+"' WHERE Id='"+Id_Preventa+"'";
            db.execSQL(consulta);
            Log.d("SQL", consulta);

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

    public void Finalizar2(View view) {
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Finalizar Preventa");
        alertDialog.setMessage("Desea finalizar esta preventa?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                PreventaEstado();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void Finalizar(View view) {
        PreventaNotaDialog preventaNotaDialog=new PreventaNotaDialog();
        preventaNotaDialog.show(getSupportFragmentManager(), "Nota");
    }

    public void Nota(MenuItem item) {
        PreventaCargar();
        //preventaJson();

        PreventaNotaDialogVer preventaNotaDialogVer=new PreventaNotaDialogVer();
        Bundle bundle=new Bundle();
        bundle.putString("Nota", Nota);
        bundle.putString("Condicion", Condicion);
        preventaNotaDialogVer.setArguments(bundle);
        preventaNotaDialogVer.show(getSupportFragmentManager(), "Ver");
    }

    public void preventaJson(){
        SharedPreferences preferences=getSharedPreferences("configuracion", Context.MODE_PRIVATE);
        String urlBase=preferences.getString("Url", "").toString();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AranjuezJsonApi aranjuezJsonApi=retrofit.create(AranjuezJsonApi.class);

        JSONObject jsonObjectPreventa = new JSONObject();
        JSONArray detalle = new JSONArray();

        db=sqLiteHelper.getReadableDatabase();

        String consultaSincronizada="select * from Preventa where Id='"+Id_Preventa+"'";
        Cursor cursorSincronizada=db.rawQuery(consultaSincronizada, null);
        cursorSincronizada.moveToFirst();
        if (!cursorSincronizada.getString(cursorSincronizada.getColumnIndex("Sincronizada")).equals("1")){
            try {
                String consulta="select Detalle_De_Preventa.* from Detalle_De_Preventa where Id_Preventa='"+Id_Preventa+"'";

                Cursor cursor=db.rawQuery(consulta, null);
                cursor.moveToFirst();

                /* ,[Id_Preventa]
                ,[Id_Producto]
                ,[Cantidad]
                ,[Precio_Unitario]
                ,[Total]
                ,[Precio_Unitario_Menos_ICE]
                ,[Total_Menos_ICE]
                ,[Descuento]
                ,[Porcentaje_De_Descuento]
                ,[IVA]
                ,[ICE]
                ,[Litros]
                ,[Estado]*/

                while (!cursor.isAfterLast()){
                    JSONObject producto = new JSONObject();
                    producto.put("Id_Preventa",cursor.getString(cursor.getColumnIndex("Id_Preventa")));
                    producto.put("Id_Producto",cursor.getString(cursor.getColumnIndex("Id_Producto")));
                    producto.put("Cantidad",cursor.getString(cursor.getColumnIndex("Cantidad")));
                    producto.put("Precio_Unitario",cursor.getString(cursor.getColumnIndex("Precio_Unitario")));
                    producto.put("Total",cursor.getString(cursor.getColumnIndex("Total")));
                    producto.put("Precio_Unitario_Menos_ICE",cursor.getString(cursor.getColumnIndex("Precio_Unitario_Menos_ICE")));
                    producto.put("Total_Menos_ICE",cursor.getString(cursor.getColumnIndex("Total_Menos_ICE")));
                    producto.put("Descuento",cursor.getString(cursor.getColumnIndex("Descuento")));
                    producto.put("Porcentaje_De_Descuento",cursor.getString(cursor.getColumnIndex("Porcentaje_De_Descuento")));
                    producto.put("IVA",cursor.getString(cursor.getColumnIndex("IVA")));
                    producto.put("ICE",cursor.getString(cursor.getColumnIndex("ICE")));
                    producto.put("Litros",cursor.getString(cursor.getColumnIndex("Litros")));
                    producto.put("Estado",cursor.getString(cursor.getColumnIndex("Estado")));

                    detalle.put(producto);
                    cursor.moveToNext();
                }
            } catch (Exception e){
                e.printStackTrace();
            }

            /*[Id]
            ,[Id_Usuario]
            ,[Id_Dispositivo]
            ,[Id_Condicion_De_Pago]
            ,[Id_Numeracion_De_Documento]
            ,[Id_Preventista]
            ,[Id_Cliente]
            ,[Id_Preventa_Dispositivo]
            ,[DocEntry]
            ,[Codigo_SAP]
            ,[Fecha]
            ,[Hora]
            ,[Latitud]
            ,[Longitud]
            ,[Total_De_Litros]
            ,[Subtotal]
            ,[Descuento]
            ,[Monto_Para_Credito_Fiscal]
            ,[IVA]
            ,[ICE]
            ,[Total]
            ,[Total_A_Pagar]
            ,[Observaciones]
            ,[Estado]
            ,[Sincronizada]*/

            try {
                Cursor cursor = db.rawQuery("select * from Preventa where Id='"+Id_Preventa+"'", null);
                cursor.moveToFirst();

                try {
                    jsonObjectPreventa.put("Id_Preventa", cursor.getString(cursor.getColumnIndex("Id")));
                    jsonObjectPreventa.put("Id_Usuario", cursor.getString(cursor.getColumnIndex("Id_Usuario")));
                    jsonObjectPreventa.put("Id_Dispositivo", cursor.getString(cursor.getColumnIndex("Id_Dispositivo")));
                    jsonObjectPreventa.put("Id_Condicion_De_Pago", cursor.getString(cursor.getColumnIndex("Id_Condicion_De_Pago")));
                    jsonObjectPreventa.put("Id_Numeracion_De_Documento", cursor.getString(cursor.getColumnIndex("Id_Numeracion_De_Documento")));
                    jsonObjectPreventa.put("Id_Preventista", cursor.getString(cursor.getColumnIndex("Id_Preventista")));
                    jsonObjectPreventa.put("Id_Cliente", cursor.getString(cursor.getColumnIndex("Id_Cliente")));
                    jsonObjectPreventa.put("Id_Preventa_Dispositivo", cursor.getString(cursor.getColumnIndex("Id_Preventa_Dispositivo")));
                    jsonObjectPreventa.put("DocEntry", cursor.getString(cursor.getColumnIndex("DocEntry")));
                    jsonObjectPreventa.put("Codigo_SAP", cursor.getString(cursor.getColumnIndex("Codigo_SAP")));
                    jsonObjectPreventa.put("Fecha", cursor.getString(cursor.getColumnIndex("Fecha")));
                    jsonObjectPreventa.put("Hora", cursor.getString(cursor.getColumnIndex("Hora")));
                    jsonObjectPreventa.put("Latitud", cursor.getString(cursor.getColumnIndex("Latitud")));
                    jsonObjectPreventa.put("Longitud", cursor.getString(cursor.getColumnIndex("Longitud")));
                    jsonObjectPreventa.put("Total_De_Litros", cursor.getString(cursor.getColumnIndex("Total_De_Litros")));
                    jsonObjectPreventa.put("Subtotal", cursor.getString(cursor.getColumnIndex("Subtotal")));
                    jsonObjectPreventa.put("Descuento", cursor.getString(cursor.getColumnIndex("Descuento")));
                    jsonObjectPreventa.put("Monto_Para_Credito_Fiscal", cursor.getString(cursor.getColumnIndex("Monto_Para_Credito_Fiscal")));
                    jsonObjectPreventa.put("IVA", cursor.getString(cursor.getColumnIndex("IVA")));
                    jsonObjectPreventa.put("ICE", cursor.getString(cursor.getColumnIndex("ICE")));
                    jsonObjectPreventa.put("Total", cursor.getString(cursor.getColumnIndex("Total")));
                    jsonObjectPreventa.put("Total_A_Pagar", cursor.getString(cursor.getColumnIndex("Total_A_Pagar")));
                    jsonObjectPreventa.put("Observaciones", cursor.getString(cursor.getColumnIndex("Observaciones")));
                    jsonObjectPreventa.put("Estado", cursor.getString(cursor.getColumnIndex("Estado")));
                    jsonObjectPreventa.put("Sincronizada", cursor.getString(cursor.getColumnIndex("Sincronizada")));
                    jsonObjectPreventa.put("Detalle", detalle);

                    Log.d("JsonObject",jsonObjectPreventa.toString());

                    Call<Respuesta> aranjueRespuestaCall=aranjuezJsonApi.getJsonRespuesta(jsonObjectPreventa.toString());
                    aranjueRespuestaCall.enqueue(new Callback<Respuesta>() {
                        @Override
                        public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                            if (!response.isSuccessful()){
                                return;
                            }

                            Respuesta respuesta=response.body();

                            if (respuesta.getRespuesta().equalsIgnoreCase("ok")){
                                db=sqLiteHelper.getWritableDatabase();
                                try {
                                    db.execSQL("update Preventa set Sincronizada='1' where Id='"+Id_Preventa+"'");
                                    db.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            Log.d("JsonObject", "Respuesta: "+respuesta.getRespuesta());

                            // Snackbar.make(getWindow().getDecorView().getRootView(), "Respuesta Json: "+respuesta.getRespuesta(), Snackbar.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Respuesta> call, Throwable t) {
                            Log.d("JsonObject", "Fallada");
                        }
                    });
                } catch (JSONException e){
                    e.printStackTrace();
                }

                db.close();
                cursor.close();
            } catch ( Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void notaTexto(String nota, String IdCondicion) {
        Nota=nota;
        idCondicion=IdCondicion;
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Finalizar Preventa");
        alertDialog.setMessage("Desea finalizar esta preventa?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                PreventaEstado();
                preventaJson();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void Info(MenuItem item) {
        PreventaInfoDialog preventaInfoDialog=new PreventaInfoDialog();
        Bundle bundle=new Bundle();

        Log.d("Calculo", "Total; "+TotalTotal.toString()+" Descuento: "+TotalDescuento.toString()+" SubTotal: "+TotalSubtotal.toString()+" CF: "
                +TotalMontoCreditoFiscal.toString()+" Total a Pagar: "+TotalTotalAPagar.toString()+" ICE: "+TotalIce.toString());

        bundle.putString("SubTotal", new DecimalFormat("#0.00").format(TotalSubtotal));
        bundle.putString("Descuento", new DecimalFormat("#0.00").format(TotalDescuento));
        bundle.putString("MontoCreditoFiscal", new DecimalFormat("#0.00").format(TotalMontoCreditoFiscal));
        bundle.putString("Total", new DecimalFormat("#0.00").format(TotalTotal));
        bundle.putString("TotalAPagar", new DecimalFormat("#0.00").format(TotalTotalAPagar));
        bundle.putString("ICE", new DecimalFormat("#0.00").format(TotalIce));

        //Double TotalTotal, TotalLitros, TotalSubtotal, TotalDescuento, TotalMontoCreditoFiscal, TotalIva, TotalIce, TotalTotalAPagar;

        preventaInfoDialog.setArguments(bundle);
        preventaInfoDialog.show(getSupportFragmentManager(), "Info");
    }
}
