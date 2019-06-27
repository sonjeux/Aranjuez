package com.example.aranjuez;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aranjuez.sql.consultasSQLite;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(consultasSQLite.SQLProducto); //
        db.execSQL(consultasSQLite.SQLLista_De_Precios);  //
        db.execSQL(consultasSQLite.SQLPrecio_De_Producto); //
        db.execSQL(consultasSQLite.SQLGrupo_De_Unidad_De_Medida); //
        db.execSQL(consultasSQLite.SQLCliente); //
        db.execSQL(consultasSQLite.SQLCodigo_De_Barras); //
        db.execSQL(consultasSQLite.SQLDias_De_Visita);//
        db.execSQL(consultasSQLite.SQLDetalle_De_Grupo_De_Unidad_De_Medida); //
        db.execSQL(consultasSQLite.SQLUnidad_De_Medida); //
        db.execSQL(consultasSQLite.SQLUnidad_De_Medida_De_Producto); //
        db.execSQL(consultasSQLite.SQLPreventa);
        db.execSQL(consultasSQLite.SQLDetalle_De_Preventa);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Producto");
        db.execSQL("DROP TABLE IF EXISTS Lista_De_Precios");
        db.execSQL("DROP TABLE IF EXISTS Precio_De_Producto");
        db.execSQL("DROP TABLE IF EXISTS Grupo_De_Unidad_De_Medida");
        db.execSQL("DROP TABLE IF EXISTS Cliente");
        db.execSQL("DROP TABLE IF EXISTS Codigo_De_Barras");
        db.execSQL("DROP TABLE IF EXISTS Dias_De_Visita");
        db.execSQL("DROP TABLE IF EXISTS Detalle_De_Grupo_De_Unidad_De_Medida");
        db.execSQL("DROP TABLE IF EXISTS Unidad_De_Medida");
        db.execSQL("DROP TABLE IF EXISTS Unidad_De_Medida_De_Producto");
        db.execSQL("DROP TABLE IF EXISTS Preventa");
        db.execSQL("DROP TABLE IF EXISTS Detalle_De_Preventa");
        onCreate(db);
    }
}
