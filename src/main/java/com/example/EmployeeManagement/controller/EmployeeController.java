package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.exception.ResourceNotFoundException;
import com.example.EmployeeManagement.model.Department;
import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.model.System;
import com.example.EmployeeManagement.model.User;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class EmployeeController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


    @GetMapping("/employees/details/{id}")
    public List<Employee> findDetailedEmployeeById(@PathVariable(value = "id") Long id){
        return employeeRepository.findDetailedEmployeeById(id);}
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException{
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id:" + employeeId));
                return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
//        Department department = new Department(employee.getDepartment().getDepartmentId(), employee.getDepartment().getDepartmentName());
//        Employee employee1 = new Employee(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmailId(),
//                department
//        );
//        log.info(employee.toString());
        return employeeRepository.save(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id:" + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());

        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException{
        //Employee employee = employeeRepository.findById(employeeId)
         //       .orElseThrow(()->new ResourceNotFoundException("Employee not found with this id:" + employeeId));
        //employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("The employee was deleted", Boolean.TRUE);
//        System system = System.builder()
//                //.systemId(1)
//                .systemName("ICT")
//                .build();
//        User user = User.builder()
//                //.userId(1)
//                .userName("Annalis")
//                .system(system)
//                .build();
//        userRepository.save(user);

        return response;
        
    }
}
