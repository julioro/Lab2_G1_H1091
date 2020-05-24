package com.example.lab2_g1_h1091.utilitary;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2_g1_h1091.R;
import com.example.lab2_g1_h1091.TrabajosActivity;
import com.example.lab2_g1_h1091.entidades.Trabajo;

public class ListaTrabajosAdapter extends RecyclerView.Adapter<ListaTrabajosAdapter.TrabajoViewHolder> {

    private Trabajo[] data;
    private Context contexto;
    private OnItemClickListener anotherlistener;

   /* public ListaTrabajosAdapter(Trabajo[] data, Context contexto) {
        this.data = data;
        this.contexto = contexto;
    }
    */
    public ListaTrabajosAdapter(Trabajo[] data, Context contexto, OnItemClickListener listener) {
        this.data = data;
        this.contexto = contexto;
        this.anotherlistener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, boolean borrar);
    }

    //https://github.com/mitchtabian/SQLite-for-Beginners-2019/blob/master/app/src/main/java/com/codingwithmitch/notes/adapters/NotesRecyclerAdapter.java
    public class TrabajoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        OnItemClickListener anotherlistener;

        Button btnBorrar = itemView.findViewById(R.id.btnBorrar);
        Button btnEditar = itemView.findViewById(R.id.btnEditar);

        public TrabajoViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView1);
            anotherlistener = listener;

            btnBorrar.setOnClickListener(this);
            btnEditar.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
  /*
            Log.d("xdmsg", "CLICKED");
            Log.d("pos", String.valueOf(getAdapterPosition()));
            Log.d("viewtype", v.getId());
*/
            Log.d("msgxd", "estoy acanga0");
            if (v.getId() == btnBorrar.getId()) { // Borrar
                Log.d("msgxd", "estoy acanga2");
                anotherlistener.onItemClick(getAdapterPosition(), true);
            } else if (v.getId() == btnEditar.getId()) { // Editar
                anotherlistener.onItemClick(getAdapterPosition(), false);
            }
        }
    }

    @NonNull
    @Override
    public TrabajoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(contexto).inflate(R.layout.item_rv, parent, false);
        TrabajoViewHolder trabajoViewHolder = new TrabajoViewHolder(itemView, anotherlistener);

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
