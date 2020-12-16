package com.example.proyectofinal_grupo7;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ControladorFactura {
    private AyudanteFactura ayudanteFactura;

    public ControladorFactura(Context context) {
        ayudanteFactura = new AyudanteFactura(context);
    }
    public long insertarFactura(FacturaM facturaM){
        SQLiteDatabase sqLiteDatabase = ayudanteFactura.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",facturaM.getId());
        contentValues.put("nitProveedor",facturaM.getNitProveedor());
        contentValues.put("nroFactura",facturaM.getNroFactura());
        contentValues.put("nroAutorizacion",facturaM.getNroAutizacion());
        contentValues.put("importeTotal",facturaM.getImporteTotal());
        contentValues.put("codigoControl",facturaM.getCodigoControl());
        return sqLiteDatabase.insert(ayudanteFactura.getNombreTabla(),null,contentValues);
    }
}
