package com.example.lab2_g1_h1091.webservices;

import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
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

public class WebServices {
    String URL_WEB_SERVICE = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000";
    String RUTA = "";
    String URL_TARGET = "";
    String GROUP_KEY = "WfnNf52Wsw6p6N8gVPFF";

    public StringRequest getApiKey(final String action, final View view, final RequestQueue rq) {
        String URL = "";
        RUTA = "/getApiKey";
        URL_TARGET = URL_WEB_SERVICE + RUTA + "?groupKey=" + GROUP_KEY;
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, URL_TARGET,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("getApiKeyRes", response);
                        Gson gson = new Gson();
                        final ApiKey responseGetKey = gson.fromJson(response, ApiKey.class);
                        if (responseGetKey.getEstado().equalsIgnoreCase("OK")) {
                            switch (action) {
                                case "listaDepartamentos":
                                    Log.d("Opcion", action);
                                    String URL_LISTAR_DEPARTAMENTO = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/listar/departamentos";
                                    StringRequest listarDepartamentosRequest = new StringRequest(StringRequest.Method.GET, URL_LISTAR_DEPARTAMENTO,
                                            new Response.Listener<String>() {
                                                @Override
                                                public void onResponse(String response) {
                                                    Log.d("res", "Request ok");
                                                    Gson gson = new Gson();
                                                    DtoDepartment dtoDepartment = gson.fromJson(response, DtoDepartment.class);
                                                    if (dtoDepartment.getEstado().equals("ok")) {
                                                        Log.d("res", "Response de request ok");
                                                        Department[] departamentos = dtoDepartment.getLista();
                                                        /*
                                                         *
                                                         * Insertar logica que use departamentos.
                                                         *
                                                         * */


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
                                            params.put("api-key", responseGetKey.getApi_key());
                                            return params;
                                        }
                                    };
                                    rq.add(listarDepartamentosRequest);
                                    break;


                                case "listaEmpleados":
                                    Log.d("Opcion", action);
                                    String URL_LISTAR_EMPLEADOS = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/listar/empleados";
                                    StringRequest listarEmpleadosRequest = new StringRequest(StringRequest.Method.GET, URL_LISTAR_EMPLEADOS,
                                            new Response.Listener<String>() {
                                                @Override
                                                public void onResponse(String response) {
                                                    Log.d("res", "Request ok");
                                                    Gson gson = new Gson();
                                                    DtoEmpleado dtoEmpleado = gson.fromJson(response, DtoEmpleado.class);
                                                    if (dtoEmpleado.getEstado().equals("ok")) {
                                                        Log.d("res", "Response de request ok");
                                                        Empleado[] empleados = dtoEmpleado.getLista();
                                                        /*
                                                         *
                                                         * Insertar logica que use empleados.
                                                         *
                                                         * */
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
                                            params.put("api-key", responseGetKey.getApi_key());
                                            return params;
                                        }
                                    };
                                    rq.add(listarEmpleadosRequest);
                                    break;

                                case "listarTrabajos":
                                    Log.d("Opcion", action);
                                    Log.d("api-keyObtenida", responseGetKey.getApi_key());
                                    String URL_LISTAR_TRABAJOS = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/listar/trabajos";
                                    Log.d("urlListarTrabajos", URL_LISTAR_TRABAJOS);
                                    StringRequest listarTrabajosRequest = new StringRequest(StringRequest.Method.GET, URL_LISTAR_TRABAJOS,
                                            new Response.Listener<String>() {
                                                @Override
                                                public void onResponse(String response) {
                                                    Log.d("res", "Request ok");
                                                    Gson gson = new Gson();
                                                    DtoTrabajo dtoTrabajos = gson.fromJson(response, DtoTrabajo.class);
                                                    if (dtoTrabajos.getEstado().equals("ok")) {
                                                        Log.d("res", "Response de request ok");
                                                        Trabajo[] trabajos = dtoTrabajos.getTrabajos();
                                                    } else {
                                                        Log.d("res", "Response de request error");
                                                        Log.d("msg", response.toString());
                                                    }
                                                }
                                            },
                                            new Response.ErrorListener() {
                                                @Override
                                                public void onErrorResponse(VolleyError error) {
                                                    Log.d("res", "err");
                                                    Log.e("res", error.toString());

                                                }
                                            }) {
                                        @Override
                                        public Map<String, String> getHeaders() throws AuthFailureError {
                                            Map<String, String> parametros = new HashMap<>();
                                            parametros.put("api-key", responseGetKey.getApi_key());
                                            return parametros;
                                        }
                                    };
                                    rq.add(listarTrabajosRequest);
                                    break;


                                case "borrarTrabajo":
                                    String idTrabajo = "";
                                    String URL_TARGET_BORRAR_TRABAJO = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/borrar/trabajo?id=" + idTrabajo;
                                    StringRequest borrarTrabajoRequest = new StringRequest(StringRequest.Method.DELETE, URL_TARGET_BORRAR_TRABAJO,
                                            new Response.Listener<String>() {
                                                @Override
                                                public void onResponse(String response) {
                                                    Gson gson = new Gson();
                                                    DtoBorrar dtoBorrar = gson.fromJson(response, DtoBorrar.class);
                                                    if (dtoBorrar.getEstado().equalsIgnoreCase("borrado exitoso")) {

                                                        /*
                                                         *
                                                         * Insertar logica que retire la entrada con ese id del menu?
                                                         *
                                                         * */
                                                    } else {
                                                        Log.e("error", response.toString());
                                                    }
                                                }
                                            },
                                            new Response.ErrorListener() {
                                                @Override
                                                public void onErrorResponse(VolleyError error) {
                                                    Log.e("error", error.toString());
                                                }
                                            }) {
                                        @Override
                                        public Map<String, String> getHeaders() throws AuthFailureError {
                                            Map<String, String> params = new HashMap<>();
                                            params.put("api-key", responseGetKey.getApi_key());
                                            return params;
                                        }
                                    };
                                    rq.add(borrarTrabajoRequest);
                                    break;


                                case "borrarEmpleado":
                                    String idEmpleado = "";
                                    String URL_TARGET_BORRAR_EMPLEADO = "http://ec2-54-165-73-192.compute-1.amazonaws.com:9000/borrar/empleado?id=" + idEmpleado;
                                    StringRequest borrarEmpleadoRequest = new StringRequest(StringRequest.Method.DELETE, URL_TARGET_BORRAR_EMPLEADO,
                                            new Response.Listener<String>() {
                                                @Override
                                                public void onResponse(String response) {
                                                    Gson gson = new Gson();
                                                    DtoBorrar dtoBorrar = gson.fromJson(response, DtoBorrar.class);
                                                    if (dtoBorrar.getEstado().equalsIgnoreCase("borrado exitoso")) {

                                                        /*
                                                         *
                                                         * Insertar logica que retire la entrada con ese id del menu?
                                                         *
                                                         * */
                                                    } else {
                                                        Log.e("error", response.toString());
                                                    }
                                                }
                                            },
                                            new Response.ErrorListener() {
                                                @Override
                                                public void onErrorResponse(VolleyError error) {
                                                    Log.e("error", error.toString());
                                                }
                                            }) {
                                        @Override
                                        public Map<String, String> getHeaders() throws AuthFailureError {
                                            Map<String, String> params = new HashMap<>();
                                            params.put("api-key", responseGetKey.getApi_key());
                                            return params;
                                        }
                                    };
                                    rq.add(borrarEmpleadoRequest);
                                    break;


                            }
                        }
                    }
                },
                // ERROR AL PEDIR EL GROUP KEY
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("getApiKeyErr", error.getMessage());
                    }
                }
        );
        return stringRequest;
    }
}
