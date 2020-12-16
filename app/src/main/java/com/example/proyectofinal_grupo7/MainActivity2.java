package com.example.proyectofinal_grupo7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private Button btnGuardar;
    private EditText nitProveedor,nrofactura,nroAutorizacion,importe,codigocontrol;
    private ControladorFactura controladorFactura;
    private FacturaM facturaM;
    private ArrayList<FacturaM> listaFactura;
    private AdaptadorM adaptadorM;
    private RecyclerView rvFactura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rvFactura=findViewById(R.id.rvFactura);
        btnGuardar=findViewById(R.id.btnGuardar);
        nitProveedor=findViewById(R.id.txtNitProveedor);
        nrofactura=findViewById(R.id.txtNroFactura);
        nroAutorizacion=findViewById(R.id.txtNroAutorizacion);
        importe=findViewById(R.id.txtImporteTotal);
        codigocontrol=findViewById(R.id.txtCodigoControl);
        //factura otros
        listaFactura = new ArrayList<FacturaM>();
        controladorFactura = new ControladorFactura(MainActivity2.this);
        facturaM = new FacturaM();
        adaptadorM = new AdaptadorM(listaFactura);
        //cargar al recyclerView
        cargarFacturaSQLite();
        rvFactura.setAdapter(adaptadorM);
        rvFactura.setLayoutManager(new GridLayoutManager(this,1));
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nitProveedorString = nitProveedor.getText().toString().trim();
                String nrofacturaString = nrofactura.getText().toString().trim();
                String nroAutorizacionString = nroAutorizacion.getText().toString().trim();
                String importeString = importe.getText().toString().trim();
                String codigocontrolString = codigocontrol.getText().toString().trim();
                if (nitProveedorString.equals("")) {
                    nitProveedor.setError("Inserta un Nro Proveedor");
                    nitProveedor.requestFocus();
                    return;
                }
                if (nrofacturaString.equals("")) {
                    nrofactura.setError("Inserta un Nro de Factura");
                    nrofactura.requestFocus();
                    return;
                }
                if (nroAutorizacionString.equals("")) {
                    nroAutorizacion.setError("Inserta un Nro de Autorizacion");
                    nroAutorizacion.requestFocus();
                    return;
                }
                if (importeString.equals("")) {
                    importe.setError("Inserta un Importe");
                    importe.requestFocus();
                    return;
                }
                if (codigocontrolString.equals("")) {
                    codigocontrol.setError("Inserta un codigo de control");
                    codigocontrol.requestFocus();
                    return;
                }
                int nitProveedorInt = Integer.parseInt(nitProveedorString);
                int nrofacturaInt=Integer.parseInt(nrofacturaString);
                int nroAutorizacionInt=Integer.parseInt(nroAutorizacionString);
                int importeInt=Integer.parseInt(importeString);
                facturaM = new FacturaM(codigocontrolString,nitProveedorInt,nrofacturaInt,nroAutorizacionInt,importeInt);
                long resultado = controladorFactura.insertarFactura(facturaM);
                if (resultado==-1){
                    Toast.makeText(getApplicationContext(),"Error al insertar", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Factura almacenada con exito", Toast.LENGTH_LONG).show();
                    cargarFacturaSQLite();
                    adaptadorM = new AdaptadorM(listaFactura);
                    rvFactura.setAdapter(adaptadorM);
                    nitProveedor.setText("");
                    nrofactura.setText("");
                    nroAutorizacion.setText("");
                    importe.setText("");
                    codigocontrol.setText("");
                }
            }
        });
    }

    private void cargarFacturaSQLite() {
        try {
            listaFactura = new ArrayList<FacturaM>();
            String codigocontrolString;
            int idInt, nitProveedorInt, nrofacturaInt, nroAutorizacionInt,importeInt;
            AyudanteFactura ayudanteFactura = new AyudanteFactura(MainActivity2.this);
            SQLiteDatabase sqLiteDatabase = ayudanteFactura.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select id,nitProveedor,nroFactura,nroAutizacion,importeTotal,codigoControl from factura",null);
            if(cursor.moveToFirst()){
                do{
                    idInt = cursor.getInt(0);
                    nitProveedorInt = cursor.getInt(1);
                    nrofacturaInt = cursor.getInt(2);
                    nroAutorizacionInt = cursor.getInt(3);
                    importeInt = cursor.getInt(4);
                    codigocontrolString = cursor.getString(5);
                    FacturaM facturaAux = new FacturaM(codigocontrolString,idInt,nitProveedorInt,nrofacturaInt,nroAutorizacionInt,importeInt);
                    listaFactura.add(facturaAux);
                }while (cursor.moveToNext());
            }else{
                Toast.makeText(getApplicationContext(),"No existen registros",Toast.LENGTH_LONG).show();
            }
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"Error "+ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}