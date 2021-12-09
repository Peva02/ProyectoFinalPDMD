package com.example.proyectofinal.adapter;

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
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.example.proyectofinal.model.Planeta;
import com.example.proyectofinal.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerHolder> {

    List<Planeta> listImagenes;
    private AdapterClickListener listener;
    private CircularProgressDrawable progressDrawable;
    Context context;

    public Adapter(List<Planeta> listImagenes, AdapterClickListener listener, Context context) {
        this.listImagenes = listImagenes;
        this.listener = listener;
        this.context = context;
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
        progressDrawable = new CircularProgressDrawable(context);
        progressDrawable.setStrokeWidth(15f);
        progressDrawable.setStyle(CircularProgressDrawable.LARGE);
        progressDrawable.setCenterRadius(35f);
        progressDrawable.start();
        Glide.with(holder.itemView)
                .load(planeta.getUrl())
                .placeholder(progressDrawable)
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
            return true;
        }
    }

    public interface AdapterClickListener {
        void onClick(View v, int pos);

        boolean onLongClick(View v, int pos);
    }

}