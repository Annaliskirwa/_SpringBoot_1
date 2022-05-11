package com.example.EmployeeManagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @Column(name = "departmentName", nullable = false)
    private String departmentName;
//    @OneToOne
//    @JoinColumn(name = "countryId")
//    private Country country;

    

    public Department() {
    }

    public Department(Long departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
