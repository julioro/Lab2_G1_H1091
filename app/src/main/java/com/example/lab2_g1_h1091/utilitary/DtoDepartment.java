package com.example.lab2_g1_h1091.utilitary;

import com.example.lab2_g1_h1091.entidades.Department;

public class DtoDepartment {

    private String estado;
    private int cuota;
    private Department[] lista;

    public DtoDepartment(String estado) {

    }

    public DtoDepartment(String estado, int cuota, Department[] lista) {
        this.estado = estado;
        this.cuota = cuota;
        this.lista = lista;
    }

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

    public Department[] getLista() {
        return lista;
    }

    public void setLista(Department[] lista) {
        this.lista = lista;
    }
}
