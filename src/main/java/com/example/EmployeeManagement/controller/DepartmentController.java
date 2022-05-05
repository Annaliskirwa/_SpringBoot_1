package com.example.EmployeeManagement.controller;


import com.example.EmployeeManagement.model.Department;
import com.example.EmployeeManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
