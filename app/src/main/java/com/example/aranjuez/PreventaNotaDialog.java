package com.example.aranjuez;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class PreventaNotaDialog extends AppCompatDialogFragment {
    private EditText editTNota;
    private PreventaNotaDialogListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        final View view=inflater.inflate(R.layout.dialog_preventa_nota, null);

        editTNota=view.findViewById(R.id.editTNota);

        builder.setView(view).setTitle("Observaciones").setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Finalizar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               String nota=editTNota.getText().toString();
               listener.notaTexto(nota);
            }
        });
        return builder.create();
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
        void notaTexto(String nota);
    }

    /*public interface ProductoCantidadDialogListener {
        void aplicarTextos(String canditdad);
    }*/
}
