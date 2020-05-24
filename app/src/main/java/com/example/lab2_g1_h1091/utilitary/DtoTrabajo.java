package com.example.lab2_g1_h1091.utilitary;

import com.example.lab2_g1_h1091.entidades.Trabajo;

public class DtoTrabajo {

    private String estado;
    private int cuota;
    private Trabajo[] trabajos;

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    private int cuota;

    public DtoTrabajo(){

    }

    public DtoTrabajo(String estado,int cuota, Trabajo[] trabajos){
        this.estado = estado;
        this.trabajos = trabajos;
        this.cuota = cuota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Trabajo[] getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(Trabajo[] trabajos) {
        this.trabajos = trabajos;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }
}
