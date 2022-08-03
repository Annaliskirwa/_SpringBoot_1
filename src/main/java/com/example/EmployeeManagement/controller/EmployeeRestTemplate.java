package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.xml.transform.sax.SAXResult;
import java.net.Authenticator;
import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/rest/")
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
    @RequestMapping(value = "template/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeByEmployeeId(@PathVariable(value = "id")Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);
        return restTemplate.exchange("http://localhost:8080/api/v1/employees/"+id, HttpMethod.GET, entity, String.class).getBody();
    }
    @RequestMapping(value = "template/employee", method = RequestMethod.POST)
    public String createEmployee(@RequestBody Employee employee){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);
        return restTemplate.exchange("http://localhost:8080/api/v1/employees", HttpMethod.POST, entity, String.class).getBody();
    }
    @RequestMapping(value = "template/employee/{id}", method = RequestMethod.PUT)
    public String updateEmployee(@PathVariable(value = "id")Long id, @RequestBody @Valid Employee employee){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);
        return restTemplate.exchange("http://localhost:8080/api/v1/employee/"+id, HttpMethod.PUT,entity, String.class).getBody();
    }
    @RequestMapping(value = "template/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable(value="id")Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);
        return restTemplate.exchange("http://localhost:8080/api/v1/employee/"+id, HttpMethod.DELETE,entity, String.class).getBody();
    }
}
