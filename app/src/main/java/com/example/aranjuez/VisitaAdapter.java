package com.example.aranjuez;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.aranjuez.entidades.VisitaVO;

import java.util.ArrayList;
import java.util.List;

public class VisitaAdapter extends RecyclerView.Adapter<VisitaAdapter.ViewHolderVisitas> implements View.OnClickListener, Filterable {
    ArrayList<VisitaVO> visitas;
    ArrayList<VisitaVO> visitasTodos;

    private View.OnClickListener listener;

    public VisitaAdapter(ArrayList<VisitaVO> visitas){
        this.visitas=visitas;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolderVisitas onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_visitas, null, false);
        view.setOnClickListener(this);
        return new ViewHolderVisitas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderVisitas viewHolderVisitas, int i) {
        viewHolderVisitas.Tema.setText(visitas.get(i).getTema_De_Visita());
        viewHolderVisitas.Estado.setText(visitas.get(i).getEstado());
        viewHolderVisitas.Fecha.setText(visitas.get(i).getFecha());
        viewHolderVisitas.Hora.setText(visitas.get(i).getHora());
        viewHolderVisitas.Nombre.setText(visitas.get(i).getCliente());
    }

    @Override
    public int getItemCount() {
        return visitas.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null) {
            listener.onClick(v);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<VisitaVO> filtrado=new ArrayList<>();
                if (constraint==null || constraint.length()==0){
                    filtrado.addAll(visitasTodos);
                } else {
                    String busqueda=constraint.toString().toLowerCase().trim();
                }
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                visitas.clear();
                visitas.addAll((List)results.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolderVisitas extends RecyclerView.ViewHolder {
        TextView Tema, Estado, Nombre, Fecha, Hora;
        public ViewHolderVisitas(@NonNull View itemView) {
            super(itemView);
            Tema=itemView.findViewById(R.id.textVTema);
            Estado=itemView.findViewById(R.id.textVEstadoVisita);
            Nombre=itemView.findViewById(R.id.textVClienteVisita);
            Fecha=itemView.findViewById(R.id.textVFechaVisita);
            Hora=itemView.findViewById(R.id.textVHora);
        }
    }
}
