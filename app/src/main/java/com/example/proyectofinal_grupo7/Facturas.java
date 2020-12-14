package com.example.proyectofinal_grupo7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Facturas extends AppCompatActivity {
    Toolbar toolbar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturas);
        toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        //overflow
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    ///metodo para mostar el menu
    public boolean onCreateOptionsSelected(Menu menu)
    {
        getMenuInflater().inflate(R.menu.overflow_codigoqr,menu);
        return  true;
    }

    ///Método para asignar las funciones
    public  boolean onOptionsMenuItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if (id==R.id.itemQr)
        {

            Intent intent = new Intent(Facturas.this,Escanear_CodigoQR.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}