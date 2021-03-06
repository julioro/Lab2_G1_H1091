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

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lab2_g1_h1091.entidades.ApiKey;
import com.example.lab2_g1_h1091.entidades.Empleado;
import com.example.lab2_g1_h1091.utilitary.DtoEmpleado;
import com.example.lab2_g1_h1091.utilitary.ListaEmpleadosAdapter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class EmpleadosActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_empleados, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuItem1:
                Intent intent = new Intent(this, MainActivity.class);
                int requetsCode_NewTrabajo = 1;
                startActivityForResult(intent, requetsCode_NewTrabajo);

                Toast.makeText(this, "Nuevo empleado creado", Toast.LENGTH_SHORT);
                return true;

            case R.id.menuItem2:

                return true;

        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleados);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String GROUP_KEY = "WfnNf52Wsw6p6N8gVPFF";
        String URL_TARGET_GET_API_KEY = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/getApiKey?groupKey=" + GROUP_KEY;
        Log.d("xd", "Estoy aca 0.");
        final StringRequest getApiKeyRequest = new StringRequest(StringRequest.Method.POST, URL_TARGET_GET_API_KEY,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("xd", "Estoy aca 1.");
                        Gson gson = new Gson();
                        final ApiKey responseGetKey = gson.fromJson(response, ApiKey.class);
                        if (responseGetKey.getEstado().equals("ok")) { // Si la consulta fue realziada exitosamente por el apikey.
                            Log.d("xd", "Estoy aca 2.");
                            // Se procede a pedir la lista de trabajos.
                            String URL_TARGET_LISTA_EMPLEADOS = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/listar/empleados";
                            StringRequest listarEmpleadosRequest = new StringRequest(StringRequest.Method.GET, URL_TARGET_LISTA_EMPLEADOS,
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            Gson gson = new Gson();
                                            DtoEmpleado dtoEmpleado = gson.fromJson(response, DtoEmpleado.class);
                                            Log.d("xd", "Estoy aca 3.");
                                            if (dtoEmpleado.getEstado().equals("ok")) { // Si la consulta por lista de trabajos fue exitosa.
                                                Log.d("xd", "Estoy aca 4.");


                                                Empleado[] empleados = dtoEmpleado.getEmpleados();
                                                ListaEmpleadosAdapter adapter = new ListaEmpleadosAdapter(empleados, EmpleadosActivity.this);
                                                RecyclerView rV = findViewById(R.id.view1);
                                                rV.setAdapter(adapter);
                                                rV.setLayoutManager(new LinearLayoutManager(EmpleadosActivity.this));

                                            } else {
                                                Log.e("error", response.toString());
                                            }
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Log.d("xd", "Estoy aca 5.");

                                        }
                                    }) {
                                @Override
                                public Map<String, String> getHeaders() throws AuthFailureError {
                                    Map<String, String> parametros = new HashMap<>();
                                    parametros.put("api-key", responseGetKey.getApi_key());
                                    return parametros;
                                }
                            };
                            Log.d("xd", "Estoy aca 6.");
                            requestQueue.add(listarEmpleadosRequest);
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

    }





}
