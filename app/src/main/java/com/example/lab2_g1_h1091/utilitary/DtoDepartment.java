package com.example.lab2_g1_h1091.utilitary;
import com.example.lab2_g1_h1091.entidades.Department;
public class DtoDepartment {
    private String estado;
    private int cuota;
    private Department[] departamentos;

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

    public Department[] getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Department[] departamentos) {
        this.departamentos = departamentos;
    }


}
