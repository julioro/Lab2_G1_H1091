package com.example.lab2_g1_h1091.webservices;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lab2_g1_h1091.entidades.ApiKey;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class WebServices {
    String URL_WEB_SERVICE = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000";
    String RUTA = "";
    String URL_TARGET = "";
    String GROUP_KEY = "WfnNf52Wsw6p6N8gVPFF";

    public StringRequest getApiKey(final String action) {
        RUTA = "/getApiKey";
        URL_TARGET = URL_WEB_SERVICE + RUTA + "?groupKey=" + GROUP_KEY;
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, URL_TARGET,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("getApiKeyRes", response);
                        Gson gson = new Gson();
                        ApiKey responseGetKey = gson.fromJson(response, ApiKey.class);
                        if (responseGetKey.getEstado().equalsIgnoreCase("OK")) {
                            Log.d("Cuota", responseGetKey.getCuota());
                            Log.d("ApiKeyValue", responseGetKey.getApi_key());
                        } else {
                            Log.d("msg", responseGetKey.getMsg());
                        }

                        switch (action) {
                            case "listarEmpleados":
                                Log.d("Opcion", "1");
                                break;
                            case "listarTrabajos":
                                Log.d("Opcion", "2");
                                break;
                            case "crearTrabajo":
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
