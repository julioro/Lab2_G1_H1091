package com.example.lab2_g1_h1091.entidades;


import androidx.annotation.Size;

import androidx.annotation.FloatRange;
import androidx.annotation.Size;

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
    private Manager manager;
    private double salary;
    private double commissionPct;
    private Department department;
    @Size(max=7)
    private String createdBy;

    public Empleado(String employeeId, String firstName, String lastName, String email, String phoneNumber, Trabajo trabajo, Manager manager, double salary, double commissionPct, Department department, String createdBy) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.trabajo = trabajo;
        this.manager = manager;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.department = department;
        this.createdBy = createdBy;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Trabajo getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajo trabajo) {
        this.trabajo = trabajo;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
