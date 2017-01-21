package com.jcodee.incidente.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodee.incidente.R;
import com.jcodee.incidente.models.DataIncidente;

import java.util.Collections;
import java.util.List;

public class IncidenteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataIncidente> data = Collections.emptyList();
    DataIncidente current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public IncidenteAdapter(Context context, List<DataIncidente> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_incidente, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder = (MyHolder) holder;
        DataIncidente current = data.get(position);
        myHolder.textIncidenteName.setText(current.tipo_incidente);
        myHolder.textDescripcion.setText("Descripción: " + current.descripcion_incidente);
        myHolder.textFecha.setText("Fecha: " + current.fecha_incidente);
        myHolder.textHora.setText("Hora " + current.hora_incidente);
        myHolder.textHora.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

        // load image into imageview using glide
        Glide.with(context).load("http://ecandlemobile.com/Test/images/" + current.tipo_incidente_img)
                .placeholder(R.drawable.ic_img_error)
                .error(R.drawable.ic_img_error)
                .into(myHolder.ivTipoIncidente);

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView textIncidenteName;
        ImageView ivTipoIncidente;
        TextView textDescripcion;
        TextView textFecha;
        TextView textHora;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textIncidenteName = (TextView) itemView.findViewById(R.id.textIncidenteName);
            ivTipoIncidente = (ImageView) itemView.findViewById(R.id.ivTipoIncidente);
            textDescripcion = (TextView) itemView.findViewById(R.id.textDescripcion);
            textFecha = (TextView) itemView.findViewById(R.id.textFecha);
            textHora = (TextView) itemView.findViewById(R.id.textHora);
        }

    }

}
