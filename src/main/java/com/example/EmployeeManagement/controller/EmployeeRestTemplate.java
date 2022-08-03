package com.example.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class EmployeeRestTemplate {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "template/employee")
    public String getEmployees(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8080/api/v1/employees", HttpMethod.GET, entity, String.class).getBody();
    }
}
