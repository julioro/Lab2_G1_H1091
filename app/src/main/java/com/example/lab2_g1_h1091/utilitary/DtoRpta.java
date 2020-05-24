package com.example.lab2_g1_h1091.utilitary;

public class DtoRpta {
    private String msg;
    private String estado;
    private int cuota;

    public DtoRpta(String msg, String estado, int cuota) {
        this.msg = msg;
        this.cuota = cuota;
        this.estado = estado;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
}
