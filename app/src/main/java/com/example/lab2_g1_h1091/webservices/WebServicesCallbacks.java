package com.example.lab2_g1_h1091.webservices;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lab2_g1_h1091.TrabajosActivity;
import com.example.lab2_g1_h1091.VolleyCallback;
import com.example.lab2_g1_h1091.entidades.ApiKey;
import com.example.lab2_g1_h1091.entidades.Department;
import com.example.lab2_g1_h1091.entidades.Empleado;
import com.example.lab2_g1_h1091.entidades.Trabajo;
import com.example.lab2_g1_h1091.utilitary.DtoBorrar;
import com.example.lab2_g1_h1091.utilitary.DtoDepartment;
import com.example.lab2_g1_h1091.utilitary.DtoEmpleado;
import com.example.lab2_g1_h1091.utilitary.DtoTrabajo;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class WebServicesCallbacks {

    final String GROUP_KEY = "WfnNf52Wsw6p6N8gVPFF";
    ApiKey apikey;
    Gson gson;
    Trabajo[] trabajos;
    Empleado[] empleados;
    Department[] departamentos;
    /*
    * Se definen los webservices para que solo tengan que ser llamaods posteriormente y recibir
    * el resultado del request como callbacks.
    * */

    public void getApiKey(RequestQueue rq, final VolleyCallback callback) {
        Log.d("msgxd", "getApiKeyCall");
        String URL_API_KEY = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/getApiKey?groupKey=" + GROUP_KEY;
        StringRequest apiReq = new StringRequest(StringRequest.Method.POST, URL_API_KEY,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        gson = new Gson();
                        apikey = gson.fromJson(response, ApiKey.class);
                        callback.onSuccess(apikey);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("errormsg", error.toString());
                    }
                });

        rq.add(apiReq);
    }
    public void listarTrabajos(RequestQueue rq, final VolleyCallback callback) {
        if (apikey.getCuota() > 0) {
            String URL_LISTAR_TRABAJOS = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/listar/trabajos";
            StringRequest listarTrabajosRequest = new StringRequest(StringRequest.Method.GET, URL_LISTAR_TRABAJOS,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            apikey.setCuota(apikey.getCuota() - 1); // Disminuir la cuota
                            gson = new Gson();
                            DtoTrabajo dtoTrabajos = gson.fromJson(response, DtoTrabajo.class);
                            if (dtoTrabajos.getEstado().equals("ok")) {
                                Log.d("res", "Response de request ok");
                                trabajos = dtoTrabajos.getTrabajos();
                                callback.onSuccess(trabajos);
                            } else {
                                Log.d("msg", response.toString());
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("res", error.toString());

                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("api-key", WebServicesCallbacks.this.apikey.getApi_key());
                    return params;
                }
            };
            rq.add(listarTrabajosRequest);
        }
    }
    public void listarDepartamentos(RequestQueue rq, final VolleyCallback callback){
        if (apikey.getCuota() > 0) {
            String URL_LISTAR_DEPARTAMENTOS = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/listar/departamentos";
            StringRequest listarDepartamentosRequest = new StringRequest(StringRequest.Method.GET, URL_LISTAR_DEPARTAMENTOS,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            apikey.setCuota(apikey.getCuota() - 1); // Disminuir la cuota
                            gson = new Gson();
                            DtoDepartment dtoDepartment = gson.fromJson(response, DtoDepartment.class);
                            if (dtoDepartment.getEstado().equals("ok")) {
                                Log.d("res", "Response de request ok");
                                departamentos = dtoDepartment.getLista();
                                callback.onSuccess(departamentos);
                            } else {
                                Log.d("msg", response.toString());
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("res", error.toString());

                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("api-key", WebServicesCallbacks.this.apikey.getApi_key());
                    return params;
                }
            };
            rq.add(listarDepartamentosRequest);
        }
    }
    public void borrarTrabajo(String idTrabajo, RequestQueue rq, final VolleyCallback callback){
    if (apikey.getCuota()>0){
        Log.d("msgxd", "estoy acangaidtraabajo " + idTrabajo);
        String URL_TARGET_BORRAR_TRABAJO = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/borrar/trabajo?id=" + idTrabajo;
        StringRequest borrarTrabajoRequest = new StringRequest(StringRequest.Method.DELETE, URL_TARGET_BORRAR_TRABAJO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("msgxd", "borrado response ok ");
                        Gson gson = new Gson();
                        DtoBorrar dtoBorrar = gson.fromJson(response, DtoBorrar.class);
                        Log.d("msgxd", dtoBorrar.getEstado());
                        Log.d("msgxd", String.valueOf(dtoBorrar.getCuota()));
                        Log.d("msgxdestado", dtoBorrar.getEstado());
                        if (dtoBorrar.getEstado().equalsIgnoreCase("error")) {
                            callback.onSuccess(false); // no se borro ok.
                            //Toast.makeText(TrabajosActivity.this, "Borrado exitoso", Toast.LENGTH_LONG);
                        } else {
                            Log.d("msgxd", "asdasddddd");

                            callback.onSuccess(true); //  se pudo borrrar.
                            //Toast.makeText(TrabajosActivity.this, "Borrado exitoso", Toast.LENGTH_LONG);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("msgxd", "estoy acangaerror");
                        Log.e("error", error.toString());
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                Log.d("msgxd", "estoy acanga"+apikey.getApi_key());
                params.put("api-key", apikey.getApi_key());
                return params;
            }
        };
        rq.add(borrarTrabajoRequest);
    }

    }
    public void listarEmpleados(RequestQueue rq, final VolleyCallback callback) {
        if (apikey.getCuota() > 0) {
            String URL_LISTAR_EMPLEADOS = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/listar/empleados";
            StringRequest listarEmpleadosRequest = new StringRequest(StringRequest.Method.GET, URL_LISTAR_EMPLEADOS,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            apikey.setCuota(apikey.getCuota()-1);
                            gson = new Gson();
                            DtoEmpleado dtoEmpleado = gson.fromJson(response, DtoEmpleado.class);
                            if (dtoEmpleado.getEstado().equals("ok")) {
                                Log.d("res", "Response de request ok");
                                Empleado[] listaEmpleados = dtoEmpleado.getEmpleados();
                                empleados = listaEmpleados;
                                callback.onSuccess(listaEmpleados);
                            } else {
                                Log.d("msg", response.toString());
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("res", error.toString());
                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("api-key", WebServicesCallbacks.this.apikey.getApi_key());
                    return params;
                }
            };
            rq.add(listarEmpleadosRequest);
        }
    }


}
