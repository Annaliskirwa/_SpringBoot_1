package com.example.EmployeeManagement.model;

public class EmployeeEx {
    private String empId;
    private String name;
    private String designation;
    private double salary;

    public EmployeeEx(){}

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((designation == null)?0: designation.hashCode());
        result = prime * result + ((empId == null)?0: empId.hashCode());

    }

}
