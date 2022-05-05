package com.example.EmployeeManagement.controller;


import com.example.EmployeeManagement.exception.ResourceNotFoundException;
import com.example.EmployeeManagement.model.Country;
import com.example.EmployeeManagement.model.Department;
import com.example.EmployeeManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    @PostMapping("/departments")
    public Department createDepartment(@Valid @RequestBody Department department){
        return departmentRepository.save(department);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Long departmentId)
        throws ResourceNotFoundException{
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("The department with that id not found:" + departmentId));
        return ResponseEntity.ok().body(department);
    }


}
