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
        db.execSQL(consultasSQLite.SQLProducto);
        db.execSQL(consultasSQLite.SQLLista_De_Precios);
        db.execSQL(consultasSQLite.SQLPrecio_De_Producto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Producto");
        db.execSQL("DROP TABLE IF EXISTS Lista_De_Precios");
        db.execSQL("DROP TABLE IF EXISTS Precio_De_Producto");
        onCreate(db);
    }
}
