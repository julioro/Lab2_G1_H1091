package com.example.lab2_g1_h1091;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lab2_g1_h1091.entidades.Department;
import com.example.lab2_g1_h1091.entidades.Trabajo;

public class formularioTrabajo2 extends AppCompatActivity {

    //Se supone que estas listas se llenan con WebServices
    private Department[] listaDepartmets;
    private String[] listaDepartmets_Nombres;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_trabajo2);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                        android.R.layout.simple_spinner_dropdown_item,
                                        listaDepartmets_Nombres);

        Spinner spinner = findViewById(R.id.spinnerDepartment);
        spinner.setAdapter(adapter);



        //Boton "Aceptar"
        final Button button1 = findViewById(R.id.buttonAceptarForm);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText inputTitle = findViewById(R.id.inputTitle);
                String jobTitle = inputTitle.getText().toString();
                EditText inputMinSalary = findViewById(R.id.inputMinSalary);
                String minSalary = inputMinSalary.getText().toString();
                EditText inputMaxSalary = findViewById(R.id.inputMaxSalary);
                String maxSalary = inputMaxSalary.getText().toString();


                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //Boton "Cancelar"
        final Button button2 = findViewById(R.id.buttonCancelarForm);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
