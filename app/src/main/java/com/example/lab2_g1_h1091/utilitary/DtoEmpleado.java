package com.example.lab2_g1_h1091.utilitary;

import com.example.lab2_g1_h1091.entidades.Empleado;

public class DtoEmpleado {
    private String estado;
    private Empleado[] empleados;
    private int cuota;


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }


    public DtoEmpleado(String estado, Empleado[] lista, int cuota) {
        this.estado = estado;
        this.empleados = lista;
        this.cuota = cuota;
    }
}
