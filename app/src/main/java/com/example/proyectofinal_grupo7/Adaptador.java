package com.example.proyectofinal_grupo7;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> implements View.OnClickListener{
    private ArrayList<Formulario> listaFormulario;

    private View.OnClickListener listener;
    public Adaptador(ArrayList<Formulario> listaFormulario) {
        this.listaFormulario = listaFormulario;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.formato_form,null,false);
        view.setOnClickListener(this);//escuchador
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
      holder.asignarDatos(listaFormulario.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(),Facturas.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaFormulario.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {
        if (listener!=null)
        {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvID, tvNombre, tvMes, tvAnio, tvEstado;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID=itemView.findViewById(R.id.tvID);
            tvNombre=itemView.findViewById(R.id.tvNombre);
            tvMes=itemView.findViewById(R.id.tvMes);
            tvAnio=itemView.findViewById(R.id.tvAño);
            tvEstado=itemView.findViewById(R.id.tvEstado);
        }
        public void asignarDatos(Formulario formulario) {
            tvID.setText("ID: "+formulario.getId());
            tvNombre.setText("NOMBRE: "+formulario.getNombre());
            tvMes.setText("MES: "+formulario.getMes());
            tvAnio.setText("AÑO: "+formulario.getAnio());
            tvEstado.setText("ESTADO: "+formulario.getEstado());
        }
    }
}
