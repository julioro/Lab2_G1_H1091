package com.example.lab2_g1_h1091.utilitary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2_g1_h1091.R;
import com.example.lab2_g1_h1091.entidades.Trabajo;

public class ListaTrabajosAdapter extends RecyclerView.Adapter {

    private Trabajo[] data;
    private Context contexto;

    public ListaTrabajosAdapter(Trabajo[] data, Context contexto) {
        this.data = data;
        this.contexto = contexto;
    }

    public static class TrabajoViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public TrabajoViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView1);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(contexto).inflate(R.layout.item_rv, parent, false);
        TrabajoViewHolder trabajoViewHolder = new TrabajoViewHolder(itemView);

        return trabajoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
