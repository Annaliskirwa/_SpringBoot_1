package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepo {

        int count();
        int saveCountry(Country country);
        int update (Country country);
        int deleteById(Long countryId);

        List<Country> findAllCountries();
        List<Country> findByName(String countryName);
        Optional<Country> findByCountryId(Long countryId);
        String findCountryNameById(Long countryId);
    }


