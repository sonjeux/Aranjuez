package com.example.aranjuez;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.aranjuez.entidades.PreventaVO;

import java.util.ArrayList;
import java.util.List;

public class PreventaAdapter extends RecyclerView.Adapter<PreventaAdapter.ViewHolderPreventa> implements View.OnClickListener, View.OnLongClickListener, Filterable {
    ArrayList<PreventaVO> preventas, preventasTodos;

    private View.OnClickListener listener;
    private View.OnLongClickListener onLongClickListener;

    public PreventaAdapter(ArrayList<PreventaVO> preventas) {
        this.preventas = preventas;
        preventasTodos=new ArrayList<>(preventas);
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

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<PreventaVO> filtrado=new ArrayList<>();
                if (constraint==null || constraint.length()==0){
                    filtrado.addAll(preventasTodos);
                } else {
                    String busqueda=constraint.toString().toLowerCase().trim();
                    for (PreventaVO preventa:preventasTodos){
                        if (preventa.getCliente().toLowerCase().contains(busqueda)){
                            filtrado.add(preventa);
                        }
                    }
                }

                FilterResults filterResults=new FilterResults();
                filterResults.values=filtrado;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                preventas.clear();
                preventas.addAll((List)results.values);
                notifyDataSetChanged();
            }
        };
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
