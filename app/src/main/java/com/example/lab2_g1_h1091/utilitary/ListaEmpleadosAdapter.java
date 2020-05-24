package com.example.lab2_g1_h1091.utilitary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2_g1_h1091.R;
import com.example.lab2_g1_h1091.entidades.Empleado;

public class ListaEmpleadosAdapter extends RecyclerView.Adapter<ListaEmpleadosAdapter.EmpleadoViewHolder> {

    private Empleado[] data;
    private Context contexto;

    public ListaEmpleadosAdapter(Empleado[] lista, Context c) {
        this.data = lista;
        this.contexto = c;
    }


    public static class EmpleadoViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        Button button1;
        Button button2;

        public EmpleadoViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView1);
            button1 = itemView.findViewById(R.id.button1);
            button2 = itemView.findViewById(R.id.button2);
        }
    }

    @NonNull
    @Override
    public EmpleadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(contexto).inflate(R.layout.item_rv, parent, false);
        EmpleadoViewHolder EmpleadoViewHolder = new EmpleadoViewHolder(itemView);

        return EmpleadoViewHolder;

    }

    @Override
    public void onBindViewHolder(EmpleadoViewHolder holder, int position) {

        Empleado e = data[position];
        String texto = e.getFirstName() + " " + e.getLastName();
        holder.textView.setText(texto);
    }
    @Override
    public int getItemCount() {
        return data.length;
    }
}
