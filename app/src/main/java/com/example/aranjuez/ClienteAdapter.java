package com.example.aranjuez;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.aranjuez.entidades.ClienteVO;

import java.util.ArrayList;
import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolderCliente> implements View.OnClickListener, Filterable {
    ArrayList<ClienteVO> clientes;
    ArrayList<ClienteVO> clientesTodos;

    private View.OnClickListener listener;

    public ClienteAdapter(ArrayList<ClienteVO> clientes) {
        this.clientes = clientes;
        clientesTodos=new ArrayList<>(clientes);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolderCliente onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_clientes, null, false);
        view.setOnClickListener(this);
        return new ViewHolderCliente(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCliente viewHolderCliente, int i) {
        viewHolderCliente.Nit.setText(clientes.get(i).getCI_O_NIT());
        viewHolderCliente.CodigoSap.setText(clientes.get(i).getCodigo_SAP());
        viewHolderCliente.ClienteNombre.setText(clientes.get(i).getNombre());
        viewHolderCliente.Telefono.setText(clientes.get(i).getTelefono());
        viewHolderCliente.Celular.setText(clientes.get(i).getCelular());
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<ClienteVO> filtrado=new ArrayList<>();
                if (constraint==null || constraint.length()==0){
                    filtrado.addAll(clientesTodos);
                } else {
                    String busqueda=constraint.toString().toLowerCase().trim();
                    for (ClienteVO cliente:clientesTodos){
                        if (cliente.getNombre().toLowerCase().contains(busqueda)){
                            filtrado.add(cliente);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filtrado;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clientes.clear();
                clientes.addAll((List)results.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolderCliente extends RecyclerView.ViewHolder {
        TextView Nit, CodigoSap, ClienteNombre, Telefono, Celular;;
        public ViewHolderCliente(@NonNull View itemView) {
            super(itemView);
            Nit=itemView.findViewById(R.id.textVCodigoSap);
            CodigoSap=itemView.findViewById(R.id.textVCodigoSap);
            ClienteNombre=itemView.findViewById(R.id.textVProductoNombre);
            Telefono=itemView.findViewById(R.id.textVTelefono);
            Celular=itemView.findViewById(R.id.textVCelular);
        }
    }
}
