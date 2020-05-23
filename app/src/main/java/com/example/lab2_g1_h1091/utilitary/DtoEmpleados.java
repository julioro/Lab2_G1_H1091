package com.example.lab2_g1_h1091.utilitary;

import com.example.lab2_g1_h1091.entidades.Empleado;

public class DtoEmpleados {
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    private String estado;
    private int cuota;
    private Empleado[] empleados;


}
