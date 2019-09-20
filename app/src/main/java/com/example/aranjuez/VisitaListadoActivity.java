package com.example.aranjuez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class VisitaListadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita_listado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.buscar_visitas, menu);
        /*MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.buscar_producto, menu);

        MenuItem buscar=menu.findItem(R.id.buscarProducto);
        SearchView searchView=(SearchView) buscar.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                productoAdapter.getFilter().filter(newText);
                return true;
            }
        });*/
        return super.onCreateOptionsMenu(menu);
    }
}
