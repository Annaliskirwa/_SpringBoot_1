package com.example.EmployeeManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")

public class Department {
    private int departmentId;
    private String departmentName;
    private int departmentCountryId;

    public Department(){

    }
    public Department(String departmentName){
        this.departmentName = departmentName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

}
