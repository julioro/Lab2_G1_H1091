package com.example.lab2_g1_h1091.utilitary;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2_g1_h1091.R;
import com.example.lab2_g1_h1091.entidades.Trabajo;

public class ListaTrabajosAdapter extends RecyclerView.Adapter<ListaTrabajosAdapter.TrabajoViewHolder> {

    private Trabajo[] data;
    private Context contexto;
    private AdapterView.OnItemClickListener listener;

    public ListaTrabajosAdapter(Trabajo[] data, Context contexto, AdapterView.OnItemClickListener listener) {
        this.data = data;
        this.contexto = contexto;
        this.listener = listener;
    }

    public static class TrabajoViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public TrabajoViewHolder(View itemView, final AdapterView.OnItemClickListener listener) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView1);

            Button btnBorrar = itemView.findViewById(R.id.btnBorrar);
            Button btnEditar = itemView.findViewById(R.id.btnEditar);


        }


    }

    @NonNull
    @Override
    public TrabajoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(contexto).inflate(R.layout.item_rv, parent, false);
        TrabajoViewHolder trabajoViewHolder = new TrabajoViewHolder(itemView, listener);

        return trabajoViewHolder;
    }

    @Override
    public void onBindViewHolder(TrabajoViewHolder holder, int position) {

        String mCurrent = data[position].getJobTitle() + " - " + data[position].getJobId() + "\n" +
                "Salario: " + data[position].getMinSalary() + "-" + data[position].getMaxSalary();

        holder.textView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {

        return data.length;
    }


}
