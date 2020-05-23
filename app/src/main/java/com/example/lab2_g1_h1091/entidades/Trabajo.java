package com.example.lab2_g1_h1091.entidades;

import androidx.annotation.Size;

public class Trabajo {


    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Size(max = 10)
    private String jobId;
    @Size(max = 35)
    private String jobTitle;
    private int minSalary;
    private int maxSalary;
    @Size(max = 7, min = 7)
    private String createdBy;



}
