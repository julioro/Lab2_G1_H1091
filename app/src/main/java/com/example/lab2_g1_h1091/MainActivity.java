package com.example.lab2_g1_h1091;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lab2_g1_h1091.webservices.WebServices;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue rq = Volley.newRequestQueue(this);

        StringRequest sr1 =  (new WebServices()).getApiKey("listarEmpleados");
        StringRequest sr2 =  (new WebServices()).getApiKey("listarTrabajos");
        rq.add(sr1);
        rq.add(sr2);


    }
}