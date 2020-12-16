package com.example.proyectofinal_grupo7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Facturas extends AppCompatActivity {
    private Toolbar toolbar2;
    private Button btnManual,btnQr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturas);
        toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        //overflow
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        btnManual=findViewById(R.id.btnManual);
        btnQr=findViewById(R.id.btnQr);
        btnManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Facturas.this,MainActivity2.class);
                startActivity(in);
            }
        });
        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Facturas.this,Escanear_CodigoQR.class);
                startActivity(in);
            }
        });
    }
    ///metodo para mostar el menu
    public boolean onCreateOptionsSelected(Menu menu)
    {
        getMenuInflater().inflate(R.menu.overflow,menu);
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