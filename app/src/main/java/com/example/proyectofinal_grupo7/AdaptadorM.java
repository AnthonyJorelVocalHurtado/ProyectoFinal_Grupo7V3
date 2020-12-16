package com.example.proyectofinal_grupo7;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorM extends RecyclerView.Adapter<AdaptadorM.ViewHolder> implements View.OnClickListener{
    private ArrayList<FacturaM> listaFactura;

    private View.OnClickListener listener;
    public AdaptadorM(ArrayList<FacturaM> listaFormulario) {
        this.listaFactura = listaFactura;
    }

    @NonNull
    @Override
    public AdaptadorM.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.formato_factura,null,false);
        view.setOnClickListener(this);//escuchador
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorM.ViewHolder holder, int position) {
        holder.asignarDatos(listaFactura.get(position));
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
        return listaFactura.size();
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
        TextView tvIDF, tvNitProveedorF, tvNroFacturaF, tvNroAutorizacion,tvImporteF, tvCodigoControlF;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIDF=itemView.findViewById(R.id.tvIDF);
            tvNitProveedorF=itemView.findViewById(R.id.tvNitProveedorF);
            tvNroFacturaF=itemView.findViewById(R.id.tvNroFacturaF);
            tvNroAutorizacion=itemView.findViewById(R.id.tvNroAutorizacion);
            tvImporteF=itemView.findViewById(R.id.tvImporteF);
            tvCodigoControlF=itemView.findViewById(R.id.tvCodigoControlF);
        }
        public void asignarDatos(FacturaM facturaM) {
            tvIDF.setText("ID: "+facturaM.getId());
            tvNitProveedorF.setText("NOMBRE: "+facturaM.getNitProveedor());
            tvNroFacturaF.setText("MES: "+facturaM.getNroFactura());
            tvNroAutorizacion.setText("AÑO: "+facturaM.getNroAutizacion());
            tvImporteF.setText("ESTADO: "+facturaM.getImporteTotal());
            tvCodigoControlF.setText("ESTADO: "+facturaM.getCodigoControl());
        }
    }
}
