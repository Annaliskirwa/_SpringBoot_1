package com.example.EmployeeManagement.model;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    private Long countryID;
    private String countryName;

    public Country(){

    }
    public  Country(String countryName){this.countryName = countryName;}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getCountryID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    @Column(name = "countryName", nullable = false)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
