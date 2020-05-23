package com.example.lab2_g1_h1091;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
<<<<<<<<< Temporary merge branch 1
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lab2_g1_h1091.webservices.WebServices;
=========
import android.view.MenuItem;

import com.example.lab2_g1_h1091.entidades.Trabajo;
import com.example.lab2_g1_h1091.utilitary.ListaTrabajosAdapter;
>>>>>>>>> Temporary merge branch 2

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
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
    }

    public void calcularBtn(View view){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest rq = (new WebServices()).getApiKey("listarEmpleados", view, requestQueue);
        requestQueue.add(rq);



        Trabajo trabajo1 = new Trabajo("jefe","JEFE",1000,2000,"RUIZNAV");
        Trabajo trabajo2 = new Trabajo("jefe1","JEFE1",2000,3000,"RUIZNAV");

        Trabajo[] listaTrabajos = {trabajo1 ,trabajo2};

        ListaTrabajosAdapter adapter = new ListaTrabajosAdapter(listaTrabajos,MainActivity.this);
        RecyclerView rV = findViewById(R.id.recyclerView1);
        rV.setAdapter(adapter);
        rV.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

}
