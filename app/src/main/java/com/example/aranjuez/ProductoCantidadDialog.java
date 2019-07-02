package com.example.aranjuez;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProductoCantidadDialog extends AppCompatDialogFragment{
    private EditText editTextCantidad, editTextDescuento;
    private ProductoCantidadDialogListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_producto_cantidad, null);

        Bundle bundle=getArguments();
        String Producto, Precio, CodigoSap;
        Producto=bundle.getString("Producto", "");
        Precio=bundle.getString("Precio", "");
        CodigoSap=bundle.getString("CodigoSap", "");

        TextView ProductoNombreT, PrecioT, CodigoSapT;

        ProductoNombreT=view.findViewById(R.id.textVProductoNombreD);
        ProductoNombreT.setText(Producto);

        PrecioT=view.findViewById(R.id.textVPrecioU);
        PrecioT.setText(Precio);

        CodigoSapT=view.findViewById(R.id.textVCodigoSap);
        CodigoSapT.setText(CodigoSap);

        editTextCantidad=view.findViewById(R.id.editTCantidad);
        editTextDescuento=view.findViewById(R.id.editTDescuento);

        builder.setView(view).setTitle("Producto").setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String Cantidad=editTextCantidad.getText().toString();
                String Descuento=editTextDescuento.getText().toString();
                listener.aplicarTextos(Cantidad, Descuento);
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener=(ProductoCantidadDialogListener)context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    public interface ProductoCantidadDialogListener {
        void aplicarTextos(String canditdad, String descuento);
    }
}
