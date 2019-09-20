package com.example.aranjuez;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.aranjuez.entidades.Condicion_De_Pago;

import java.util.ArrayList;

public class PreventaNotaDialog extends AppCompatDialogFragment {
    private EditText editTNota;
    private Spinner spinner;
    private PreventaNotaDialogListener listener;
    SQLiteDatabase db;
    SQLiteHelper sqLiteHelper;
    ArrayList<String> condicionS;
    ArrayList<Condicion_De_Pago> condicion_de_pagos;
    String IdCondicion;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        final View view=inflater.inflate(R.layout.dialog_preventa_nota, null);

        sqLiteHelper=new SQLiteHelper(getContext(), "aranjuez", null, 1);
        editTNota=view.findViewById(R.id.editTNota);
        spinner=view.findViewById(R.id.spinner);
        db=sqLiteHelper.getReadableDatabase();

        cargarCondicion();

        ArrayAdapter adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, condicionS);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Spinner", condicion_de_pagos.get(position).getCondicion()+" "+condicion_de_pagos.get(position).getId());
                IdCondicion=condicion_de_pagos.get(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        builder.setView(view).setTitle("Observaciones").setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Finalizar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               String nota=editTNota.getText().toString();
               listener.notaTexto(nota, IdCondicion);
            }
        });
        return builder.create();
    }

    public void cargarCondicion() {
        condicion_de_pagos=new ArrayList<Condicion_De_Pago>();
        Cursor cursor=db.rawQuery("SELECT * FROM Condicion_De_Pago", null);
        while (cursor.moveToNext()){
            condicion_de_pagos.add(new Condicion_De_Pago(cursor.getString(cursor.getColumnIndex("Id")), cursor.getString(cursor.getColumnIndex("GroupNum")),
                    cursor.getString(cursor.getColumnIndex("Condicion")), cursor.getString(cursor.getColumnIndex("Meses_Extra")),
                    cursor.getString(cursor.getColumnIndex("Dias_Extra")), cursor.getString(cursor.getColumnIndex("Estado"))));
        }

        obtenerLista();
    }

    private void obtenerLista() {
        condicionS=new ArrayList<String>();
        //condicionS.add("Seleccione");
        for (int i=0; i<condicion_de_pagos.size(); i++){
            condicionS.add(condicion_de_pagos.get(i).getCondicion());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener=(PreventaNotaDialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    public interface PreventaNotaDialogListener{
        void notaTexto(String nota, String IdCondicion);
    }

    /*public interface ProductoCantidadDialogListener {
        void aplicarTextos(String canditdad);
    }*/
}
