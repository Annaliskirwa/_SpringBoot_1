package com.example.EmployeeManagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    private Long countryId;
    private String countryName;

    public Country(){

    }
    public  Country(String countryName){this.countryName = countryName;}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Column(name = "countryName", nullable = false)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Country(Long countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    //@OneToMany(mappedBy = "country")
    //private List<Department> department;
}
