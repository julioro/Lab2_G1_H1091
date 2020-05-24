package com.example.lab2_g1_h1091;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lab2_g1_h1091.entidades.ApiKey;
import com.example.lab2_g1_h1091.entidades.Department;
import com.example.lab2_g1_h1091.entidades.Trabajo;
import com.example.lab2_g1_h1091.utilitary.DtoDepartment;
import com.example.lab2_g1_h1091.utilitary.DtoRpta;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class formularioTrabajo2 extends AppCompatActivity {

    //Se supone que estas listas se llenan con WebServices

    public List<String> listaDepartments_Nombres = new ArrayList<>();
    public List<String> ListaDepartments_ShortName = new ArrayList<>();
    int index_selectedDepartment;
    public String a, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_trabajo2);
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
                            String URL_TARGET_LISTA_TRABAJOS = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/listar/departamentos";
                            StringRequest listarTrabajosRequest = new StringRequest(StringRequest.Method.GET, URL_TARGET_LISTA_TRABAJOS,
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            String a;
                                            Gson gson = new Gson();
                                            DtoDepartment dtoDepartment = gson.fromJson(response, DtoDepartment.class);
                                            Log.d("CUOTASSSSS", Integer.toString(dtoDepartment.getCuota()));
                                            if (dtoDepartment.getEstado().equals("ok")) { // Si la consulta por lista de trabajos fue exitosa.
                                                Log.d("xd", "Estoy aca 4.");


                                                Department[] departments = dtoDepartment.getdepartamentos();

                                                for (int i = 0; i < departments.length; i++) {

                                                    listaDepartments_Nombres.add(String.valueOf(departments[i].getDepartmentName()));
                                                    a = listaDepartments_Nombres.get(i).substring(0, 2);

                                                    ListaDepartments_ShortName.add(a);
                                                    a = " ";
                                                }
                                                final Spinner spinner = findViewById(R.id.spinnerDepartment);

                                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(formularioTrabajo2.this,
                                                        android.R.layout.simple_spinner_dropdown_item,
                                                        listaDepartments_Nombres);
                                                spinner.setAdapter(adapter);
                                                text = spinner.getSelectedItem().toString();

                                       /*       spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                    @Override
                                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                        index_selectedDepartment=position;
                                                        Log.d("INDEX", String.valueOf(index_selectedDepartment));
                                                    }
                                                   public void onNothingSelected(AdapterView<?> parent) { }
                                               });*/


                                                Log.d("lista departaments", text);


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
                            requestQueue.add(listarTrabajosRequest);
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


        //Spinner de Departments


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
                EditText inputAbreviation = findViewById(R.id.inputAbreviacion);
                String Abreviation = inputAbreviation.getText().toString();

                String departmentShortName = text.substring(0, 2);
                String jobId = departmentShortName + "_" + Abreviation;
                Log.d("joid", jobId);
                Log.d("joid", text);

            }
        });

              /*  Trabajo trabajo=new Trabajo(jobTitle,);
                final Gson Gson1=new Gson();


                final RequestQueue requestQueue = Volley.newRequestQueue(formularioTrabajo2.this);
                String GROUP_KEY = "WfnNf52Wsw6p6N8gVPFF";
                String URL_TARGET_GET_API_KEY = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/getApiKey?groupKey=" + GROUP_KEY;
                Log.d("xd", "Estoy aca 0.");
                final StringRequest getApiKeyRequest = new StringRequest(StringRequest.Method.POST, URL_TARGET_GET_API_KEY,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                final Gson gson = new Gson();
                                final ApiKey responseGetKey = gson.fromJson(response, ApiKey.class);
                                if (responseGetKey.getEstado().equals("ok")) { // Si la consulta fue realziada exitosamente por el apikey.

                                    // Se procede a pedir la lista de trabajos.
                                    String URL_TARGET_LISTA_TRABAJOS = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/trabajo";
                                    StringRequest listarTrabajosRequest = new StringRequest(StringRequest.Method.POST, URL_TARGET_LISTA_TRABAJOS,
                                            new Response.Listener<String>() {
                                                @Override
                                                public void onResponse(String response) {
                                                    Gson gson = new Gson();

                                                    DtoRpta dtoRpta=gson.fromJson(response,DtoRpta.class);

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
                                        public Map<String ,String>getParams()throws AuthFailureError{
                                            Map<String,String> parametros1=new HashMap<>();
                                            Gson1=gson.toJson();
                                            parametros1.put();
                                            return parametros1;
                                        }
                                    };
                                    Log.d("xd", "Estoy aca 6.");
                                    requestQueue.add(listarTrabajosRequest);
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





                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });*/

        //Boton "Cancelar"
        final Button button2 = findViewById(R.id.buttonCancelarForm);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        EditText inputAbreviation = findViewById(R.id.inputAbreviacion);
        inputAbreviation.setText(text);
    }


}
