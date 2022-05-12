package com.example.EmployeeManagement.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employees", indexes = @Index(name = "fn_index",columnList = "first_name, last_name DESC"))
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private Long departmentId;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String emailId)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @ManyToOne
    @JoinColumn(name = "departmentId")

    private Department department;

}
