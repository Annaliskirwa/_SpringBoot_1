package com.example.EmployeeManagement.model;

import javax.persistence.Entity;

@Entity
@Table(name = "department")
public class Department {
    private int departmentId;
    private String departmentName;
    private int departmentCountryId;

    public Department(){

    }
}
