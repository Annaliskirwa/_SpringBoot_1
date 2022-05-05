package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    List<Country> findByCountryName(String countryName);
}
