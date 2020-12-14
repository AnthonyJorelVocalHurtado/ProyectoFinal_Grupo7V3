package com.example.proyectofinal_grupo7;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ControladorFormulario {
    private AyudanteFormulario ayudanteFormulario;

    public ControladorFormulario(Context context) {
        ayudanteFormulario = new AyudanteFormulario(context);
    }
    public long insertarFormulario(Formulario formulario){
        SQLiteDatabase sqLiteDatabase = ayudanteFormulario.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",formulario.getNombre());
        contentValues.put("mes",formulario.getMes());
        contentValues.put("anio",formulario.getAnio());
        contentValues.put("estado",formulario.getEstado());
        return sqLiteDatabase.insert(ayudanteFormulario.getNombreTabla(),null,contentValues);
    }
}
