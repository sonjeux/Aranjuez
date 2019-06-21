package com.example.aranjuez;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aranjuez.entidades.Detalle_De_PreventaVO;

import java.util.ArrayList;

public class PreventaDetalleAdapter extends RecyclerView.Adapter<PreventaDetalleAdapter.ViewHolderPreventaDetalle> {
    ArrayList<Detalle_De_PreventaVO> detalle_de_preventas;

    public PreventaDetalleAdapter(ArrayList<Detalle_De_PreventaVO> detalle_de_preventas) {
        this.detalle_de_preventas = detalle_de_preventas;
    }

    @NonNull
    @Override
    public PreventaDetalleAdapter.ViewHolderPreventaDetalle onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_preventas_detalle, null, false);
        return new ViewHolderPreventaDetalle(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreventaDetalleAdapter.ViewHolderPreventaDetalle viewHolderPreventaDetalle, int i) {
        viewHolderPreventaDetalle.CodigoSap.setText(detalle_de_preventas.get(i).getCodigoSap());
        viewHolderPreventaDetalle.CodigoBarras.setText(detalle_de_preventas.get(i).getCodigoBarras());
        viewHolderPreventaDetalle.Producto.setText(detalle_de_preventas.get(i).getProducto());
        viewHolderPreventaDetalle.Cantidad.setText(detalle_de_preventas.get(i).getCantidad());
        viewHolderPreventaDetalle.PrecioU.setText(detalle_de_preventas.get(i).getPrecio_Unitario());
        viewHolderPreventaDetalle.SubTotal.setText(detalle_de_preventas.get(i).getTotal());
    }

    @Override
    public int getItemCount() {
        return detalle_de_preventas.size();
    }

    public class ViewHolderPreventaDetalle extends RecyclerView.ViewHolder {
        TextView CodigoSap, CodigoBarras, Producto, PrecioU, Cantidad, SubTotal;
        public ViewHolderPreventaDetalle(@NonNull View itemView) {
            super(itemView);
            CodigoSap=itemView.findViewById(R.id.textVNit);
            CodigoBarras=itemView.findViewById(R.id.textVCodigoBarras);
            Producto=itemView.findViewById(R.id.textVClienteNombre);
            PrecioU=itemView.findViewById(R.id.textVTelefono);
            Cantidad=itemView.findViewById(R.id.textVCantidad);
            SubTotal=itemView.findViewById(R.id.textVSubTotal);
        }
    }
}
