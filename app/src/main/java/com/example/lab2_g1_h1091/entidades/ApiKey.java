package com.example.lab2_g1_h1091.entidades;

import com.google.gson.annotations.SerializedName;

public class ApiKey {

    private String estado;
    private int cuota;
    @SerializedName("api-key")
    private String api_key;
    private String msg;

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

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
