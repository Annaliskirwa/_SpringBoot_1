package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.model.Country;
import com.example.EmployeeManagement.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }
    @PostMapping("/countries")
    public Country createCountry(@Valid @RequestBody Country country){
        return countryRepository.save(country);
    }
}
