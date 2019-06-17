package com.example.aranjuez;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.aranjuez.entidades.ProductoVO;

import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolderProductos> implements View.OnClickListener, Filterable {
    ArrayList<ProductoVO> productos;
    ArrayList<ProductoVO> productosTodos;

    private View.OnClickListener listener;

    public ProductoAdapter(ArrayList<ProductoVO> productos) {
        this.productos = productos;
        productosTodos=new ArrayList<>(productos);
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_productos, null, false);
        view.setOnClickListener(this);
        return new ViewHolderProductos((view));
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos viewHolderProductos, int i) {
        viewHolderProductos.codigoSap.setText(productos.get(i).getCodigo_SAP());
        viewHolderProductos.codigoBarras.setText(productos.get(i).getCodigo_SAP());
        viewHolderProductos.producto.setText(productos.get(i).getNombre());
        viewHolderProductos.litros.setText(productos.get(i).getCodigo_SAP());
        viewHolderProductos.precio.setText(productos.get(i).getCodigo_SAP());
    }

    @Override
    public int getItemCount() {
        return productos.size();
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
                ArrayList<ProductoVO> filtrado=new ArrayList<>();
                if (constraint==null || constraint.length()==0){
                    filtrado.addAll(productosTodos);
                } else {
                    String busqueda=constraint.toString().toLowerCase().trim();
                    for (ProductoVO producto:productosTodos){
                        if (producto.getNombre().toLowerCase().contains(busqueda)){
                            filtrado.add(producto);
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filtrado;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                productos.clear();
                productos.addAll((List)results.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolderProductos extends RecyclerView.ViewHolder {
        TextView codigoSap, codigoBarras, producto, litros, precio;
        public ViewHolderProductos(@NonNull View itemView) {
            super(itemView);
            codigoSap=itemView.findViewById(R.id.textVCodigoSap);
            codigoBarras=itemView.findViewById(R.id.textVCodigoBarras);
            producto=itemView.findViewById(R.id.textVProductoNombre);
            litros=itemView.findViewById(R.id.textVPrecioU);
            precio=itemView.findViewById(R.id.textVPrecio);
        }
    }
}
