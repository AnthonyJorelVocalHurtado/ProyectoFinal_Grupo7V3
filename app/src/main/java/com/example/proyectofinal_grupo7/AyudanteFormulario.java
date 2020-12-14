package com.example.proyectofinal_grupo7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AyudanteFormulario extends SQLiteOpenHelper {
    private static final String NOMBRE_BD = "proyectofinal.db", NOMBRE_TABLA = "formulario";
    public AyudanteFormulario(@Nullable Context context) {
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
        sqLiteDatabase.execSQL(String.format("create table if not exists %s(id integer primary key autoincrement,nombre texto not null,mes texto not null,anio integer not null,estado integer default 1);",NOMBRE_TABLA));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
