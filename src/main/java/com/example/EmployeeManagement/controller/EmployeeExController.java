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

        EmployeeEx emp2 = new EmployeeEx();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId("2");
        emp2.setSalary(5000);

        tempEmployees.add(emp1);
        tempEmployees.add(emp2);
        return tempEmployees;
    }
}
