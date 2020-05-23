package com.example.lab2_g1_h1091.utilitary;

import com.example.lab2_g1_h1091.entidades.Empleado;

public class DtoEmpleado {

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado[] getLista() {
        return lista;
    }

    public void setLista(Empleado[] lista) {
        this.lista = lista;
    }

    private String estado;
    private Empleado[] lista;
    private int cuota;

    public int getCuota() {
        return cuota;
    }
    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public DtoEmpleado(){

    }

    public DtoEmpleado(String estado, Empleado[] lista, int cuota) {
        this.estado = estado;
        this.lista = lista;
        this.cuota = cuota;
    }
}
