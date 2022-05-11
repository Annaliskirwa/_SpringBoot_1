package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT e.id, e.first_name, e.last_name, e.email_address, d.department_name" +
            " FROM employees e INNER JOIN department d ON e.department_Id = d.department_Id" +
            " WHERE e.id = :id", nativeQuery = true)
    List<Employee> findDetailedEmployeeById(@Param("id") Long id);
}
