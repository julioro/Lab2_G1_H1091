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

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lab2_g1_h1091.entidades.ApiKey;
import com.example.lab2_g1_h1091.entidades.Trabajo;
import com.example.lab2_g1_h1091.utilitary.DtoTrabajo;
import com.example.lab2_g1_h1091.utilitary.ListaTrabajosAdapter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

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
                Intent intent = new Intent(this, EmpleadosActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuItem2:

                return true;

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String GROUP_KEY = "WfnNf52Wsw6p6N8gVPFF";
        String URL_TARGET_GET_API_KEY = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/getApiKey?groupKey=" + GROUP_KEY;
        final StringRequest getApiKeyRequest = new StringRequest(StringRequest.Method.POST, URL_TARGET_GET_API_KEY,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        final ApiKey responseGetKey = gson.fromJson(response, ApiKey.class);
                        if (responseGetKey.getEstado().equals("ok")) { // Si la consulta fue realziada exitosamente por el apikey.
                            // Se procede a pedir la lista de trabajos.
                            String URL_TARGET_LISTA_TRABAJOS = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/listar/trabajos";
                            StringRequest listarTrabajosRequest = new StringRequest(StringRequest.Method.GET, URL_TARGET_LISTA_TRABAJOS,
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            Gson gson = new Gson();
                                            DtoTrabajo dtoTrabajos = gson.fromJson(response, DtoTrabajo.class);
                                            if (dtoTrabajos.getEstado().equals("ok")) { // Si la consulta por lista de trabajos fue exitosa.
                                                Trabajo[] trabajos = dtoTrabajos.getTrabajos();
                                                ListaTrabajosAdapter adapter = new ListaTrabajosAdapter(trabajos, MainActivity.this);
                                                RecyclerView rV = findViewById(R.id.recyclerView1);
                                                rV.setAdapter(adapter);
                                                rV.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                                            } else {
                                                Log.e("error", response.toString());
                                            }
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Log.e("error", error.toString());

                                        }
                                    }) {
                                @Override
                                public Map<String, String> getHeaders() throws AuthFailureError {
                                    Map<String, String> parametros = new HashMap<>();
                                    parametros.put("api-key", responseGetKey.getApi_key());
                                    return parametros;
                                }
                            };
                            requestQueue.add(listarTrabajosRequest);
                        } else { // Si hubo errror en la consulta por el apikey
                            Log.e("error", response.toString());
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("error", error.toString());
                    }
                });


        requestQueue.add(getApiKeyRequest);

    /*
        Trabajo trabajo1 = new Trabajo("jefe", "JEFE", 1000, 2000, "RUIZNAV");
        Trabajo trabajo2 = new Trabajo("jefe1", "JEFE1", 2000, 3000, "RUIZNAV");

        Trabajo[] listaTrabajos = {trabajo1, trabajo2};

        ListaTrabajosAdapter adapter = new ListaTrabajosAdapter(listaTrabajos, MainActivity.this);
        RecyclerView rV = findViewById(R.id.recyclerView1);
        rV.setAdapter(adapter);
        rV.setLayoutManager(new LinearLayoutManager(MainActivity.this));
*/
    }
}
