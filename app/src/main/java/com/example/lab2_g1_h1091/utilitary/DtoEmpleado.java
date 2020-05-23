package com.example.lab2_g1_h1091.utilitary;

import com.example.lab2_g1_h1091.entidades.Empleado;

public class DtoEmpleado {

    private String estado;
    private Empleado[] lista;

    public DtoEmpleado(){

    }

    public DtoEmpleado(String estado, Empleado[] lista) {
        this.estado = estado;
        this.lista = lista;
    }
}
