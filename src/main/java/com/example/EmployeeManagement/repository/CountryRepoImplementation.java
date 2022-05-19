package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class CountryRepoImplementation implements CountryRepo {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int update(Country country) {
        return namedParameterJdbcTemplate.update("update country set country_Name = :country_Name where country_Id = :country_Id",
                new BeanPropertySqlParameterSource(country));
    }

    @Override
    public List<Country> findByName(String countryName) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("countryName", countryName);

        return namedParameterJdbcTemplate.query(
                "select * from country where country_Name like :country_Name", mapSqlParameterSource,
                ((rs, rowNum) -> new Country(
                        rs.getLong("countryId"),
                        rs.getString("countryName")
                ))
        );
    }

    @Override
    public Optional<Country> findByCountryId(Long countryId) {
        return namedParameterJdbcTemplate.queryForObject(
                "select * from country where country_Id = :country_Id",
                new MapSqlParameterSource("countryId", countryId),
                (rs, rowNum) ->
                        Optional.of(new Country(
                                rs.getLong("countryId"),
                                rs.getString("countryName")
                        ))
        );
    }


}
