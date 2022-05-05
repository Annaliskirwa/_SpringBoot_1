package com.example.EmployeeManagement.controller;


import com.example.EmployeeManagement.model.Country;
import com.example.EmployeeManagement.repository.CountryRepository;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }
    @PostMapping("/employees")
    public Country createCountry(@Valid @RequestBody Country country){
        return countryRepository.save(country);
    }
}
