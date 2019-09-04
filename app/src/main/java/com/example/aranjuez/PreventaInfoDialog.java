package com.example.aranjuez;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class PreventaInfoDialog extends AppCompatDialogFragment {
    TextView textVSubTotal, textVMontoCreditoFiscal, textVDescuento, textVICE, textVTotal, textVTotalAPagar;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_preventa_info, null);

        textVSubTotal=view.findViewById(R.id.textVSubTotal);
        textVMontoCreditoFiscal=view.findViewById(R.id.textVMontoCreditoFiscal);
        textVDescuento=view.findViewById(R.id.textVDescuento);
        textVICE=view.findViewById(R.id.textVICE);
        textVTotal=view.findViewById(R.id.textVTotal);
        textVTotalAPagar=view.findViewById(R.id.textVTotalAPagar);

        Bundle bundle=getArguments();
        textVSubTotal.setText(bundle.getString("SubTotal", ""));
        textVMontoCreditoFiscal.setText(bundle.getString("MontoCreditoFiscal", ""));
        textVDescuento.setText(bundle.getString("Descuento", ""));
        textVICE.setText(bundle.getString("ICE", ""));
        textVTotal.setText(bundle.getString("Total", ""));
        textVTotalAPagar.setText(bundle.getString("TotalAPagar", ""));

        /* bundle.putString("SubTotal", new DecimalFormat("#.0#").format(TotalSubtotal));
        bundle.putString("Descuento", new DecimalFormat("#.0#").format(TotalDescuento));
        bundle.putString("MontoCreditoFiscal", new DecimalFormat("#.0#").format(TotalMontoCreditoFiscal));
        bundle.putString("Total", new DecimalFormat("#.0#").format(TotalTotal));
        bundle.putString("TotalAPagar", new DecimalFormat("#.0#").format(TotalTotalAPagar));
        bundle.putString("ICE", new DecimalFormat("#.0#").format(TotalIce));*/

        builder.setView(view).setTitle("Detalles").setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}
