package com.example.proyectofinal.adapter;

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
import com.example.proyectofinal.model.Planeta;
import com.example.proyectofinal.R;
import com.orhanobut.logger.Logger;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerHolder> {

    List<Planeta> listImagenes;
    private AdapterClickListener listener;

    public Adapter(List<Planeta> listImagenes, AdapterClickListener listener) {
        this.listImagenes = listImagenes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_items, parent, false);
        RecyclerHolder recyclerHolder = new RecyclerHolder(view);

        return recyclerHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        Planeta planeta = listImagenes.get(position);
        Logger.t("URL_PLANETA").d(planeta.getUrl());
        Glide.with(holder.itemView)
                .load(planeta.getUrl())
                .into(holder.imagen);
        holder.title.setText(planeta.getTitulo());
    }

    @Override
    public int getItemCount() {
        return listImagenes.size();
    }


    public class RecyclerHolder extends ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView imagen;
        TextView title;


        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imgPlanetas);
            title = itemView.findViewById(R.id.tw_title);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }


        @Override
        public boolean onLongClick(View view) {
            listener.onLongClick(view, getAdapterPosition());
            return false;
        }
    }

    public interface AdapterClickListener {
        void onClick(View v, int pos);

        boolean onLongClick(View v, int pos);
    }

}