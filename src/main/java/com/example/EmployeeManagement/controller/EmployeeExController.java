package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.model.EmployeeEx;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeExController {
    private List<EmployeeEx> employeeEx = createList();
    private static List<EmployeeEx> createList(){
        List<EmployeeEx> tempEmployees = new ArrayList<>();
        EmployeeEx emp1 = new EmployeeEx();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId("1");
        emp1.setSalary(3000);
    }
}
