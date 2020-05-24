package com.example.lab2_g1_h1091.entidades;

public class Department {


    private int departmentId;
    private String departmentName;

    private String departmentShortName;

    public Department() {

    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentShortName() {
        return departmentShortName;
    }

    public void setDepartmentShortName(String departmentShortName) {
        this.departmentShortName = departmentShortName;
    }

    public Department(int departmentId, String departmentName, String managerId, int locationId, String departmentShortName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;

        this.departmentShortName = departmentShortName;
    }


}
