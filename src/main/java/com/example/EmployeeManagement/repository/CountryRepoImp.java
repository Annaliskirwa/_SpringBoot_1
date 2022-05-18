package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CountryRepoImp implements CountryRepo{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from country", Integer.class);
    }

    @Override
    public int saveCountry(Country country) {
        return jdbcTemplate.update("insert into country(country_Id, country_Name) values (?, ?);", country.getCountryId(), country.getCountryName());
    }

    @Override
    public int update(Country country) {
        return jdbcTemplate.update("update country set country_name = ? where country_Id = ?;", country.getCountryId(),country.getCountryName());
    }

    @Override
    public int deleteById(Long countryId) {
        return 0;
    }

    @Override
    public List<Country> findAllCountries() {
        return null;
    }

    @Override
    public List<Country> findByName(String countryName) {
        return null;
    }

    @Override
    public Optional<Country> findByCountryId(Long countryId) {
        return Optional.empty();
    }

    @Override
    public String findCountryNameById(Long countryId) {
        return null;
    }
}
