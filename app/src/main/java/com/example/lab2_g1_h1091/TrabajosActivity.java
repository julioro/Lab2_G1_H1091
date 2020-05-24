package com.example.lab2_g1_h1091;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.lab2_g1_h1091.entidades.ApiKey;
import com.example.lab2_g1_h1091.entidades.Trabajo;
import com.example.lab2_g1_h1091.utilitary.ListaTrabajosAdapter;
import com.example.lab2_g1_h1091.webservices.WebServicesCallbacks;

public class TrabajosActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuItem1:
                Intent intent = new Intent(this, MainActivity.class);
                //Intent intent = new Intent(this, EmpleadoActPrueba.class);
                startActivity(intent);
                return true;
            case R.id.menuItem2:

                return true;

        }


        return super.onOptionsItemSelected(item);
    }

    ApiKey apikey;
    Trabajo[] listaTrabajos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajos);
        final RequestQueue rq = Volley.newRequestQueue(this);
        final WebServicesCallbacks ws = new WebServicesCallbacks();
        ws.getApiKey(rq, new VolleyCallback() {
            @Override
            public void onSuccess(Object result) {
                apikey = (ApiKey) result;
                ws.listarTrabajos(rq, new VolleyCallback() {
                    @Override
                    public void onSuccess(Object result) {
                        Trabajo[] trabajos = (Trabajo[]) result;
                        listaTrabajos = trabajos;
                        // Recycler view logica:
                        RecyclerView rV = findViewById(R.id.recyclerView1);
                        ListaTrabajosAdapter adapter = new ListaTrabajosAdapter(trabajos, TrabajosActivity.this, new ListaTrabajosAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(final int position, boolean borrar) {
                                Log.d("msgxd", "estoy acanga");
                                if (borrar) {
                                    ws.borrarTrabajo(listaTrabajos[position].getJobId(), rq, new VolleyCallback() {
                                        @Override
                                        public void onSuccess(Object result) {
                                            Log.d("msgxd", result.toString());
                                            Log.d("msgxd", "DsadasdddD");


                                            boolean parse = ((boolean) result);
                                            Log.d("msgxd", "estoy asdads");
                                            String msg = (parse) ? "Borrado exitos.\nNo se pudo sacaar de la lista." : "No se pudo borrar";
                                            Toast.makeText(TrabajosActivity.this, msg, Toast.LENGTH_LONG);

                                            if (parse) { // Sacarlo de la lista.
                                                //listaTrabajos.remove(position);
                                                // Me sale que no soporta el metodo remove.

                                            }

                                        }
                                    });
                                } else {
                                    //editarTrabajo(listaTrabajos[position].getJobId());
                                }
                            }
                        });

                        rV.setAdapter(adapter);
                        rV.setLayoutManager(new LinearLayoutManager(TrabajosActivity.this));


                    }
                });
            }
        });

    }
}
