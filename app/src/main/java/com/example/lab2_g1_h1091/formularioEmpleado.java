package com.example.lab2_g1_h1091;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lab2_g1_h1091.entidades.Department;
import com.example.lab2_g1_h1091.entidades.Empleado;
import com.example.lab2_g1_h1091.entidades.Trabajo;

public class formularioEmpleado extends AppCompatActivity {

    private Department[] listaDepartments;
    private String[] listaDepartments_Nombres;
    private int index_selectedDepartment;

    private Empleado[] listaEmpleados;
    private String[] listaEmpleados_Nombres;
    private int index_selectedEmpleado;
    private int ultimoEmpleado_numero;

    private Trabajo[] listaTrabajos;
    private String[] listaTrabajos_Nombres;
    private int index_selectedTrabajo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_empleado);

        //Spinner de Departments
        final Spinner spinner1 = findViewById(R.id.spinnerDepartment);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                listaDepartments_Nombres);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index_selectedDepartment = position;
            }
        });

        //Spinner de Jefes
        final Spinner spinner2 = findViewById(R.id.spinnerJefe);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                listaEmpleados_Nombres);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index_selectedEmpleado = position;
            }
        });

        //Spinner de Trabajos
        final Spinner spinner3 = findViewById(R.id.spinnerJob);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                listaTrabajos_Nombres);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index_selectedTrabajo = position;
            }
        });


        //Boton "Aceptar"
        final Button button1 = findViewById(R.id.buttonAceptarForm);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText inputNombre = findViewById(R.id.inputNombre);
                String Nombre = inputNombre.getText().toString();
                EditText inputApellido = findViewById(R.id.inputApellido);
                String Apellido = inputApellido.getText().toString();
                EditText inputCorreo = findViewById(R.id.inputCorreo);
                String Correo = inputCorreo.getText().toString();
                EditText inputTelefono = findViewById(R.id.inputTelefono);
                String Telefono = inputTelefono.getText().toString();
                EditText inputSalario = findViewById(R.id.inputSalario);
                String Salario = inputSalario.getText().toString();

                //EditText inputComision = findViewById(R.id.inputComision);
                //String Comision = inputComision.getText().toString();
                String Comision = "0.01";

                Department selectedDepartment = listaDepartments[index_selectedDepartment];
                String departmentShortName = selectedDepartment.getDepartmentShortName();
                String employeeId = (ultimoEmpleado_numero + 1) + "_" + departmentShortName;


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
