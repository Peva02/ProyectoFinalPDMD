package com.example.proyectofinal.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.example.proyectofinal.R;
import com.example.proyectofinal.model.Planeta;
import com.orhanobut.logger.Logger;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerHolder> implements View.OnClickListener {
    List<Planeta> listImagenes;
    private View.OnClickListener listener;
    private Context context;

    public Adapter(List<Planeta> listImagenes, Activity RecView) {
        this.listImagenes = listImagenes;
        this.context = RecView;
    }

    @NonNull
    @Override
    /**Crear la estructura de componentes de cada celda de la lista a partir del layout creado
     * y devuelve un recycleholder, con la estructura de la celda
     */
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items, parent, false);
        RecyclerHolder recyclerHolder = new RecyclerHolder(view);
        /**le pasamos la vista el nuevo metodo creado*/
        view.setOnClickListener(listener);
        return recyclerHolder;
    }

    @Override
    /**Se encarga de enlazar la información con cada celda. Este método es
     *llamado una vez se ha creado la vista de cada celda de la lista.
     * */
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        Planeta planeta = listImagenes.get(position);
        Logger.t("URL_PLANETA").d(planeta.getUrl());
        Glide.with(context)
                .load(planeta.getUrl())
                .into(holder.imagen);
        holder.title.setText(planeta.getTitulo());
    }

    @Override
    /**Devuleve el numero de items que contiene la lista*/
    public int getItemCount() {
        return listImagenes.size();
    }

    public void setOnclickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    /**
     * Sobreescribe le metodo onClick y devuelve la vista del objeto que se a pulsado
     */
    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    /**
     * Recrea los elementos de la vista del layout creado(custom_items.xml)
     */
    public class RecyclerHolder extends ViewHolder {
        ImageView imagen;
        TextView title;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imgPlanetas);
            title = (TextView) itemView.findViewById(R.id.tw_title);
        }
    }

}
