package com.example.aranjuez;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aranjuez.entidades.VisitaVO;

import java.util.ArrayList;

public class VisitaAdapter extends RecyclerView.Adapter<VisitaAdapter.ViewHolderVisitas> {
    ArrayList<VisitaVO> visitas;

    @NonNull
    @Override
    public ViewHolderVisitas onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_visitas, null, false);
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
