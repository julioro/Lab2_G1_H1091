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
import android.view.View;
import android.widget.AdapterView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.lab2_g1_h1091.R;
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
                        // Recycler view logica:
                        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        };
                        ListaTrabajosAdapter adapter = new ListaTrabajosAdapter(trabajos, TrabajosActivity.this, listener);
                        RecyclerView rV = findViewById(R.id.recyclerView1);
                        rV.setAdapter(adapter);
                        rV.setLayoutManager(new LinearLayoutManager(TrabajosActivity.this));



                    }
                });
            }
        });

    }
}
