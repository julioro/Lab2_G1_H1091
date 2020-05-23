package com.example.lab2_g1_h1091.entidades;

import androidx.annotation.Size;

public class Trabajo {

<<<<<<< .merge_file_a12744
    private String jobId;
    private String jobTitle;
    private double minSalary;
    private double maxSalary;
    private String createdBy;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
=======
    @Size(max = 10)
    private String jobId;
    @Size(max = 35)
    private String jobTitle;
    private int minSalary;
    private int maxSalary;
    @Size(max = 7, min = 7)
    private String createdBy = null;

    public Trabajo(){

    }
    public Trabajo(String jobId, String jobTitle,int minSalary, int maxSalary, String createdBy){
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.createdBy = createdBy;

    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
>>>>>>> .merge_file_a13040
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

<<<<<<< .merge_file_a12744
    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
=======
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public String getCreatedBy() {
        return createdBy;
>>>>>>> .merge_file_a13040
    }
}
