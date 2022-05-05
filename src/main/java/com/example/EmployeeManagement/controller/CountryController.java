package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.exception.ResourceNotFoundException;
import com.example.EmployeeManagement.model.Country;
import com.example.EmployeeManagement.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") Long countryId)
        throws ResourceNotFoundException{
        Country country = countryRepository.findById(countryId)
                .orElseThrow(()-> new ResourceNotFoundException("Country not found for this id" + countryId));
        return ResponseEntity.ok().body(country);
    }
    @GetMapping("/countries/{countryName}")
    public List<Country> findByCountryName(@PathVariable String countryName){
        return countryRepository.findByCountryName(countryName);
    }
}
