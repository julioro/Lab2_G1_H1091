package com.example.lab2_g1_h1091;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lab2_g1_h1091.entidades.Department;
import com.example.lab2_g1_h1091.entidades.Empleado;
import com.example.lab2_g1_h1091.entidades.Manager;
import com.example.lab2_g1_h1091.entidades.Trabajo;
import com.example.lab2_g1_h1091.utilitary.ListaEmpleadosAdapter;
import com.example.lab2_g1_h1091.utilitary.ListaTrabajosAdapter;

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
        Department department = new Department();
        Manager manager1 = new Manager();
        Trabajo trabajo1 = new Trabajo("jefe","JEFE",1000,2000,"RUIZNAV");
        Trabajo trabajo2 = new Trabajo("jefe1","JEFE1",2000,3000,"RUIZNAV");


        Empleado empleado1 = new Empleado("gaa", "J P", "VM", "A20145334@PUCP.PE", "941107208", trabajo1, manager1, 30000.9, 1000, department, "da");

        Empleado empleado2 = new Empleado("gaa", "J P", "VM", "A20145334@PUCP.PE", "941107208", trabajo1, manager1, 30000.9, 1000, department, "da");

        Empleado empleado3 = new Empleado("gaa", "J P", "VM", "A20145334@PUCP.PE", "941107208", trabajo1, manager1, 30000.9, 1000, department, "da");

        Empleado empleado4 = new Empleado("gaa", "J P", "VM", "A20145334@PUCP.PE", "941107208", trabajo1, manager1, 30000.9, 1000, department, "da");

        Trabajo[] listaTrabajos = {trabajo1 ,trabajo2};
        Empleado[] empleados = {empleado1, empleado2, empleado3, empleado4};
        ListaTrabajosAdapter adapter = new ListaTrabajosAdapter(listaTrabajos,MainActivity.this);
        ListaEmpleadosAdapter listaEmpleadosAdapter = new ListaEmpleadosAdapter(empleados, MainActivity.this);

        RecyclerView rV = findViewById(R.id.recyclerView1);
        rV.setAdapter(listaEmpleadosAdapter);
        rV.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }
}
