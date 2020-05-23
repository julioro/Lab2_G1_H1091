package com.example.lab2_g1_h1091;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lab2_g1_h1091.entidades.ApiKey;
import com.example.lab2_g1_h1091.webservices.WSGetApiKey;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String URL_WEB_SERVICE = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000";
    String RUTA = "";
    String GROUP_KEY = "WfnNf52Wsw6p6N8gVPFF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RUTA = "/getApiKey";

        String URL_TARGET = URL_WEB_SERVICE + RUTA + "?groupKey=" + GROUP_KEY;
        Log.d("xdxdx", URL_TARGET);
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, URL_TARGET,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("get api key response", response);
                        Gson gson = new Gson();
                        ApiKey responseGetKey = gson.fromJson(response, ApiKey.class);
                        if (responseGetKey.getEstado().equalsIgnoreCase("OK")) {
                            Log.d("ApiKeyValue", responseGetKey.getApi_key());
                            Log.d("Cuota", responseGetKey.getCuota());
                        } else {
                            Log.d("msg", responseGetKey.getMsg());
                        }
                        //return Apikey;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("errorxd", error.getMessage());
                        Log.e("get api key error", error.getMessage());
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