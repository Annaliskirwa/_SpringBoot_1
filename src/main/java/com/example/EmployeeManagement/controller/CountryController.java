package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.exception.ResourceNotFoundException;
import com.example.EmployeeManagement.model.Country;
import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @DeleteMapping("/countries/{id}")
    public Map<String, Boolean> deleteCountryById(@PathVariable(value = "id") Long countryId)
        throws ResourceNotFoundException{
        Country country = countryRepository.findById(countryId)
                .orElseThrow(()-> new ResourceNotFoundException("Country not found with this id:" + countryId));
        countryRepository.delete(country);
        Map<String, Boolean> response = new HashMap<>();
        response.put("The country was deleted", Boolean.TRUE);
        return response;
    }
    //Ambigous methods throwing errors
    /**
    @DeleteMapping("/countries/{countryName}")
    public String deleteCountryByName(@PathVariable String countryName){
        countryRepository.deleteByCountryName(countryName);
        return "The country has been deleted";
    }
    */
    //Delete a country with id without the error handler method

    /**
     *
     *     public String deleteCountryById(@PathVariable("id") Long countryId){
     *         countryRepository.deleteById(countryId);
     *         return "The country has been deleted";
     *     }*/
}
