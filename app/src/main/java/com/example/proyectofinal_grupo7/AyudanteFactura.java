package com.example.proyectofinal_grupo7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AyudanteFactura extends SQLiteOpenHelper {
    private static final String NOMBRE_BD = "factura.db", NOMBRE_TABLA = "factura";
    public AyudanteFactura(@Nullable Context context) {
        super(context, NOMBRE_BD, null, 1);
    }

    public static String getNombreBd() {
        return NOMBRE_BD;
    }

    public static String getNombreTabla() {
        return NOMBRE_TABLA;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.format("create table if not exists %s(id integer primary key autoincrement,nitProveedor integer not null,nroFactura texto not null,nroAutizacion integer not null,importeTotal integer not null, codigoControl text not null);",NOMBRE_TABLA));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
