package com.example.EmployeeManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;

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
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
