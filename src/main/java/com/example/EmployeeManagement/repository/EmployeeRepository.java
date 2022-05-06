package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT e.id, e.firstName, e.lastName, e.emailId, d.name FROM Employee e, Department d WHERE e.departmentId = d.departmentId and e.id=:id", nativeQuery = true)
    List<Employee> findDetailedEmployeeById(@Param("id") Long id);
}
