package com.example.lab2_g1_h1091.webservices;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lab2_g1_h1091.entidades.ApiKey;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class wsgetapikey {
    String URL_WEB_SERVICE = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000";
    String RUTA = "";
    String GROUP_KEY = "WfnNf52Wsw6p6N8gVPFF";

    public ApiKey getApiKey() {
        RUTA = "/getApiKey";
        String URL_TARGET = URL_WEB_SERVICE + RUTA + "?groupKey=" + GROUP_KEY;
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, URL_TARGET,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(RUTA + " POST Response", response);
                        Gson gson = new Gson();
                        ApiKey responseGetKey = gson.fromJson(response, ApiKey.class);
                        return ApiKey;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(RUTA + " POST Response", error.getMessage());
                    }
                }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("groupKey", GROUP_KEY);
                return params;
            }
        };


    }
}
