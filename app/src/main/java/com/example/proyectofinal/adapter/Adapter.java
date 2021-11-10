package com.example.proyectofinal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.proyectofinal.R;
import com.example.proyectofinal.model.Coches;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerHolder> implements View.OnClickListener {
    List<Coches> listImagenes;
    private View.OnClickListener listener;

    public Adapter(List<Coches> listImagenes) {
        this.listImagenes = listImagenes;
    }

    @NonNull
    @Override
    //Crear la estructura de componentes de cada celda de la lista a partir del layout creado
    // y devuelve un recycleholder, con la estructura de la celda
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items, parent, false);
        RecyclerHolder recyclerHolder = new RecyclerHolder(view);

        //le pasamos la vista el nuevo metodo creado
        view.setOnClickListener(listener);

        return recyclerHolder;
    }

    @Override
    //Se encarga de enlazar la información con cada celda. Este método es
    //llamado una vez se ha creado la vista de cada celda de la lista.
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        Coches coche = listImagenes.get(position);
        holder.imagen.setImageResource(coche.getImagen());
        holder.nombre.setText(coche.getNombre());
    }

    @Override
    public int getItemCount() {
        return listImagenes.size();//Devuleve el numero de items que contiene la lista
    }

    public void setOnclickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    //Sobreescribe le metodo onClick y devuelve la vista del objeto que se a pulsado
    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    //Recrea los elementos de la vista del layout creado(custom_items.xml)
    public class RecyclerHolder extends ViewHolder {
        ImageView imagen;
        TextView nombre;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imageView);
            nombre = (TextView) itemView.findViewById(R.id.tw_nombre);
        }
    }

}
