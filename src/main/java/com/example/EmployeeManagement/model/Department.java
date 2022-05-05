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
    private Long departmentId;
    private String departmentName;
    private Long departmentCountryId;

    public Department(){

    }
    public Department(String departmentName){
        this.departmentName = departmentName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    @Column(name = "departmentName", nullable = false)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
