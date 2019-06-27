package com.example.aranjuez;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aranjuez.entidades.PreventaVO;

import java.util.ArrayList;

public class PreventaAdapter extends RecyclerView.Adapter<PreventaAdapter.ViewHolderPreventa> implements View.OnClickListener{
    ArrayList<PreventaVO> preventas;

    private View.OnClickListener listener;

    public PreventaAdapter(ArrayList<PreventaVO> preventas) {
        this.preventas = preventas;
    }

    @NonNull
    @Override
    public ViewHolderPreventa onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_preventas, null, false);
        view.setOnClickListener(this);
        return new ViewHolderPreventa(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPreventa viewHolderPreventa, int i) {
        viewHolderPreventa.Fecha.setText(preventas.get(i).getFecha());
        viewHolderPreventa.Hora.setText(preventas.get(i).getHora());
        viewHolderPreventa.ClienteNombre.setText(preventas.get(i).getCliente());
        viewHolderPreventa.Total.setText(preventas.get(i).getTotal());
        viewHolderPreventa.Estado.setText(preventas.get(i).getEstado());
    }

    @Override
    public int getItemCount() {
        return preventas.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolderPreventa extends RecyclerView.ViewHolder {
        TextView Fecha, Hora, ClienteNombre, Total, Estado;
        public ViewHolderPreventa(@NonNull View itemView) {
            super(itemView);
            Fecha=itemView.findViewById(R.id.textVCodigoSap);
            Hora=itemView.findViewById(R.id.textVHora);
            ClienteNombre=itemView.findViewById(R.id.textVProductoNombre);
            Total=itemView.findViewById(R.id.textVTelefono);
            Estado=itemView.findViewById(R.id.textVEstado);
        }
    }
}
