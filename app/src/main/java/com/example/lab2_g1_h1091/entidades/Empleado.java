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


}
