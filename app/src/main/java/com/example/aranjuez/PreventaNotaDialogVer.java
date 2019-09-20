package com.example.aranjuez;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class PreventaNotaDialogVer extends AppCompatDialogFragment {
    TextView textNotaVer, textCondicion;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_preventa_nota_ver, null);

        textNotaVer=view.findViewById(R.id.textNotaVer);
        textCondicion=view.findViewById(R.id.textCondicion);
        Bundle bundle=getArguments();
        textNotaVer.setText(bundle.getString("Nota", ""));
        textCondicion.setText(bundle.getString("Condicion", ""));

        builder.setView(view).setTitle("Nota").setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}
