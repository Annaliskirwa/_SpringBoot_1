package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.System;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends JpaRepository<System, Integer> {
}
