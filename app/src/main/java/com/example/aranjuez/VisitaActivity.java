package com.example.aranjuez;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.aranjuez.entidades.Tema_De_Visita;

import java.util.ArrayList;

public class VisitaActivity extends AppCompatActivity {

    ArrayList<Tema_De_Visita> temas_de_visita;
    ArrayList<String> temas;
    SQLiteDatabase db;
    SQLiteHelper sqLiteHelper;
    Spinner spinnerTema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.buscar_visitas, menu);

        spinnerTema=findViewById(R.id.spinnerTema);

        sqLiteHelper=new SQLiteHelper(this, "aranjuez", null, 1);
        db=sqLiteHelper.getReadableDatabase();

        cargarTemas();

        ArrayAdapter adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, temas);
        spinnerTema.setAdapter(adapter);

        return super.onCreateOptionsMenu(menu);
    }

    public void cargarTemas(){
        temas_de_visita=new ArrayList<Tema_De_Visita>();
        Cursor cursor=db.rawQuery("SELECT * FROM Tema_De_Visita", null);
        while(cursor.moveToNext()){
            temas_de_visita.add(new Tema_De_Visita(cursor.getString(cursor.getColumnIndex("Id")),
                    cursor.getString(cursor.getColumnIndex("Descripcion")),
                    cursor.getString(cursor.getColumnIndex("Estado"))));
        }
        obtenerTemas();
    }

    public void obtenerTemas(){
        temas=new ArrayList<String>();
        for (int i=0; i<temas_de_visita.size(); i++){
            temas.add(temas_de_visita.get(i).getDescripcion());
        }
    }
}
