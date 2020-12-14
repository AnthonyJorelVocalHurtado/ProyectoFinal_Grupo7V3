package com.example.proyectofinal_grupo7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //overflow
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
    //metodo para mostrar y ocultar el menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }
    //asignamos funciones a las opciones del menu over flow
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id==R.id.item4)
        {
            Toast.makeText(this,"Escanear Codigo Qr",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.item2)
        {
            //Toast.makeText(this,"Crear Nuevo Formulario",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,ActivityFormulario.class);
            startActivity(i);
        }
        if(id==R.id.itemQr)
        {
            //Toast.makeText(this,"Click en Quienes Somos",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,MainActivityInfo.class);
            startActivity(i);
        }
        if(id==R.id.item3)
        {
            //Toast.makeText(this,"Click en Salir",Toast.LENGTH_SHORT).show();
            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
            alerta.setMessage("Desea salir de la app?")
                    .setCancelable(false)
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog titulo = alerta.create();
            titulo.setTitle("Salida");
            titulo.show();
        }
        return super.onOptionsItemSelected(item);
    }
}