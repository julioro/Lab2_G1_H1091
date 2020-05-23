package com.example.lab2_g1_h1091.utilitary;

import com.example.lab2_g1_h1091.entidades.Trabajo;

public class DtoTrabajo {

    private String estado;
    private Trabajo[] trabajos;

    public DtoTrabajo(){

    }

    public DtoTrabajo(String estado, Trabajo[] trabajos){
        this.estado = estado;
        this.trabajos = trabajos;
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
}
