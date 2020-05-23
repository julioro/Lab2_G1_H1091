package com.example.lab2_g1_h1091.webservices;

import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lab2_g1_h1091.MainActivity;
import com.example.lab2_g1_h1091.entidades.ApiKey;
import com.example.lab2_g1_h1091.entidades.Empleado;
import com.example.lab2_g1_h1091.utilitary.DtoEmpleados;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class WebServices {
    String URL_WEB_SERVICE = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000";
    String RUTA = "";
    String URL_TARGET = "";
    String GROUP_KEY = "WfnNf52Wsw6p6N8gVPFF";

    public StringRequest getApiKey(final String action, final View view, final RequestQueue rq) {
        RUTA = "/getApiKey";
        URL_TARGET = URL_WEB_SERVICE + RUTA + "?groupKey=" + GROUP_KEY;
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, URL_TARGET,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("getApiKeyRes", response);
                        Gson gson = new Gson();
                        ApiKey responseGetKey = gson.fromJson(response, ApiKey.class);
                        /*
                        if (responseGetKey.getEstado().equalsIgnoreCase("OK")) {
                            Log.d("Cuota", responseGetKey.getCuota());
                            Log.d("ApiKeyValue", responseGetKey.getApi_key());
                        } else {
                            Log.d("msg", responseGetKey.getMsg());
                        }

                         */
                        switch (action) {
                            case "listarEmpleados":
                                Log.d("Opcion", action);
                                // Apunto al URL par listar empleados.
                                String URL = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/listar/empleados?api-key=" + responseGetKey.getApi_key();
                                StringRequest listarEmpleadosRequest = new StringRequest(StringRequest.Method.GET, URL,
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                Log.d("res", "ok");
                                                Gson gson = new Gson();
                                                DtoEmpleados dtoEmpleados = gson.fromJson(response, DtoEmpleados.class);
                                                Empleado[] empleados = dtoEmpleados.getEmpleados();


                                            }
                                        },
                                        new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                Log.d("res", "err");
                                                Log.e("res", error.toString());

                                            }
                                        });
                                rq.add(listarEmpleadosRequest);

                                break;
                            case "listarTrabajos":
                                Log.d("Opcion", action);
                                break;

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("getApiKeyErr", error.getMessage());
                    }
                }) {
        };

        return stringRequest;
    }
}
