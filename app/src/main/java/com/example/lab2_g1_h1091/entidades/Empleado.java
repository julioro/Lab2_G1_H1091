package com.example.lab2_g1_h1091.entidades;

import androidx.annotation.FloatRange;

public class Empleado {
    @Size(max=6)
    private String employeeId;
    @Size(max=20)
    private String firstName;
    @Size(max=25)
    private String lastName;
    @Size(max=25)
    private String email;
    @Size(max=20)
    private String phoneNumber;
    private Trabajo trabajo;
    private double salary;
    private double commissionPct;
    private Manager manager;
    private Department department;
    @Size(max=7)
    private String createdBy;

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }



}
