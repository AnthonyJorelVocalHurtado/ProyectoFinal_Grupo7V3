package com.example.proyectofinal_grupo7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ActivityFormulario extends AppCompatActivity {
    private EditText etNombre, etMes, etAnio, etEstado;
    private FloatingActionButton btnAgregar;
    private RecyclerView rvFormulario;
    private ControladorFormulario controladorFormulario;
    private Formulario formulario;
    private ArrayList<Formulario> listaFormulario;
    private Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        //Instanciar datos
        etNombre=findViewById(R.id.etNombre);
        etMes=findViewById(R.id.etMes);
        etAnio=findViewById(R.id.etAño);
        etEstado=findViewById(R.id.etEstado);
        btnAgregar=findViewById(R.id.btnAgregar);
        rvFormulario=findViewById(R.id.rvFormulario);
        rvFormulario.setLayoutManager(new GridLayoutManager(this,1));
        listaFormulario = new ArrayList<Formulario>();
        controladorFormulario = new ControladorFormulario(ActivityFormulario.this);
        formulario = new Formulario();
        adaptador = new Adaptador(listaFormulario);
        //cargar al recyclerView
        cargarFormularioSQLite();
        rvFormulario.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Seleccion:"+listaFormulario.get(rvFormulario.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_LONG).show();
            }
        });
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreString = etNombre.getText().toString().trim();
                String mesString = etMes.getText().toString().trim();
                String anioString = etAnio.getText().toString().trim();
                String estadoString = etEstado.getText().toString().trim();
                if (nombreString.equals("")) {
                    etNombre.setError("Inserta un nombre");
                    etNombre.requestFocus();
                    return;
                }
                if (mesString.equals("")) {
                    etMes.setError("Inserta un Mes");
                    etMes.requestFocus();
                    return;
                }
                if (anioString.equals("")) {
                    etAnio.setError("Inserta un Año");
                    etAnio.requestFocus();
                    return;
                }
                if (estadoString.equals("")) {
                    etAnio.setError("Inserta un Estado");
                    etAnio.requestFocus();
                    return;
                }
                int anioInt = Integer.parseInt(anioString);
                int estadoInt=Integer.parseInt(estadoString);
                formulario = new Formulario(nombreString,mesString,anioInt,estadoInt);
                long resultado = controladorFormulario.insertarFormulario(formulario);
                if (resultado==-1){
                    Toast.makeText(getApplicationContext(),"Error al insertar", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Formulario almacenado con exito", Toast.LENGTH_LONG).show();
                    cargarFormularioSQLite();
                    adaptador = new Adaptador(listaFormulario);
                    rvFormulario.setAdapter(adaptador);
                    etNombre.setText("");
                    etMes.setText("");
                    etAnio.setText("");
                    etEstado.setText("");
                }
            }
        });

    }

    private void cargarFormularioSQLite() {
        try {
            listaFormulario = new ArrayList<Formulario>();
            String nombreString, mesString;
            int idInt, anioInt, estadoInt;
            AyudanteFormulario ayudanteFormulario = new AyudanteFormulario(ActivityFormulario.this);
            SQLiteDatabase sqLiteDatabase = ayudanteFormulario.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select id,nombre,mes,anio,estado from formulario",null);
            if(cursor.moveToFirst()){
                do{
                    idInt = cursor.getInt(0);
                    nombreString = cursor.getString(1);
                    mesString = cursor.getString(2);
                    anioInt = cursor.getInt(3);
                    estadoInt = cursor.getInt(4);
                    Formulario formularioAux = new Formulario(nombreString,mesString,idInt,anioInt,estadoInt);
                    listaFormulario.add(formularioAux);
                }while (cursor.moveToNext());
            }else{
                Toast.makeText(getApplicationContext(),"No existen registros",Toast.LENGTH_LONG).show();
            }
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"Error "+ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}