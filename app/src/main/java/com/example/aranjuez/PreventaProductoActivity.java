package com.example.aranjuez;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aranjuez.entidades.ProductoVO;

import java.util.ArrayList;

public class PreventaProductoActivity extends AppCompatActivity implements ProductoCantidadDialog.ProductoCantidadDialogListener {
    ArrayList<ProductoVO> productos;
    RecyclerView recyclerView;
    SQLiteHelper sqLiteHelper;
    ProductoAdapter productoAdapter;
    String Id_Producto, Id_Preventa, Id_Lista_De_Precios;
    SQLiteDatabase db;
    String Id_Unidad_De_Medida="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventa_producto);

        //getSupportActionBar().setTitle("Seleccione un Producto");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Id_Preventa = getIntent().getExtras().getString("idPreventa");
        Id_Lista_De_Precios = getIntent().getExtras().getString("idListaPrecios");

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null,1);

        productos=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerPreventaProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ProductosCargar();

        productoAdapter=new ProductoAdapter(productos);
        productoAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Producto=productos.get(recyclerView.getChildAdapterPosition(v)).getNombre();
                String PrecioU=productos.get(recyclerView.getChildAdapterPosition(v)).getPrecio();
                String CodigoSap=productos.get(recyclerView.getChildAdapterPosition(v)).getCodigo_SAP();

                Id_Producto=productos.get(recyclerView.getChildAdapterPosition(v)).getId();

                ProductoCantidadDialog productoCantidadDialog=new ProductoCantidadDialog();
                Bundle bundle=new Bundle();
                bundle.putString("Producto",Producto);
                bundle.putString("Precio", PrecioU);
                bundle.putString("CodigoSap", CodigoSap);
                productoCantidadDialog.setArguments(bundle);

                productoCantidadDialog.show(getSupportFragmentManager(), "Producto");
            }
        });

        recyclerView.setAdapter(productoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.buscar_preventas_producto, menu);

        MenuItem buscar=menu.findItem(R.id.buscarPreventaProducto);
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
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void ProductosCargar() {
        db=sqLiteHelper.getReadableDatabase();
        try {
            Cursor cursor=db.rawQuery("select Producto.*, (select Codigo_De_Barras.Codigo_De_Barras from Codigo_De_Barras where Codigo_De_Barras.Id_Producto=Producto.Id) as CodigoBarras, " +
                    "(select Precio_De_Producto.Precio from Precio_De_Producto where (Precio_De_Producto.Id_Lista_De_Precios='"+Id_Lista_De_Precios+"') and " +
                    "(Precio_De_Producto.Id_Unidad_De_Medida='"+Id_Unidad_De_Medida+"') and (Precio_De_Producto.Id_Producto=Producto.Id)) as Precio from Producto", null);
            cursor.moveToFirst();
            while ( !cursor.isAfterLast()) {
                productos.add(new ProductoVO(cursor.getString(cursor.getColumnIndex("Id")), cursor.getString(cursor.getColumnIndex("Codigo_SAP")),
                        cursor.getString(cursor.getColumnIndex("CodigoBarras")), cursor.getString(cursor.getColumnIndex("Descripcion")),
                        cursor.getString(cursor.getColumnIndex("Capacidad_En_Litros")), cursor.getString(cursor.getColumnIndex("Precio"))));
                cursor.moveToNext();
            }
            db.close();
            cursor.close();
        }catch ( Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void aplicarTextos(String cantidad) {
        Double PrecioF, CantidadF, DescuentoPorcentajeF, DescuentoF, LitrosF, LitrosTotalF, ICEF, ICETotalF, TotalF, TotalMenosICEF, PrecioUMenosICEF, IVAF;
        db=sqLiteHelper.getReadableDatabase();

        ICEF=3.51;

        Cursor cursorPrecios=db.rawQuery("select * from Precio_De_Producto where (Id_Lista_De_Precios='"+Id_Lista_De_Precios+"')and(Id_Unidad_De_Medida='"+Id_Unidad_De_Medida+"')and(Id_Producto='"+Id_Producto+"')", null);
        cursorPrecios.moveToFirst();
        PrecioF=cursorPrecios.getDouble(cursorPrecios.getColumnIndex("Precio"));
        DescuentoPorcentajeF=cursorPrecios.getDouble(cursorPrecios.getColumnIndex("Porcentaje_De_Descuento"));

        Cursor cursor=db.rawQuery("select * from Producto where (Id='"+Id_Producto+"')", null);
        cursor.moveToFirst();

        LitrosF=cursor.getDouble(cursor.getColumnIndex("Capacidad_En_Litros"));
        CantidadF=Double.parseDouble(cantidad);

        TotalF=CantidadF*PrecioF;
        PrecioUMenosICEF=PrecioF-(ICEF*LitrosF);
        ICETotalF=CantidadF*ICEF*LitrosF;
        TotalMenosICEF=CantidadF*PrecioUMenosICEF;
        LitrosTotalF=CantidadF*LitrosF;
        DescuentoF=(PrecioF*DescuentoPorcentajeF)/100;
        IVAF=(TotalMenosICEF-ICETotalF)*0.13;

        db=sqLiteHelper.getWritableDatabase();
        db.execSQL("insert into Detalle_De_Preventa (Id, Id_Preventa, Id_Producto, Cantidad, Precio_Unitario, Total, Precio_Unitario_Menos_ICE, Total_Menos_ICE, Descuento, " +
                "Porcentaje_De_Descuento, IVA, ICE, Litros, Estado) values ('0', '"+Id_Preventa+"', '"+Id_Producto+"', '"+cantidad+"', '"+Double.toString(PrecioF)+
                "', '"+Double.toString(TotalF)+"', '"+Double.toString(PrecioUMenosICEF)+"', '"+Double.toString(TotalMenosICEF)+"', '"+Double.toString(DescuentoF)+
                "', '"+Double.toString(DescuentoPorcentajeF)+"', '"+Double.toString(IVAF)+"', '"+Double.toString(ICETotalF)+"', '"+Double.toString(LitrosTotalF)+"', 'Pendiente')");
        db.close();
        Snackbar.make(getWindow().getDecorView().getRootView(), "Producto agregado", Snackbar.LENGTH_SHORT).show();
    }
}
