package com.example.EmployeeManagement;

import com.example.EmployeeManagement.model.System;
import com.example.EmployeeManagement.model.User;
import com.example.EmployeeManagement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUser(){
        System system = System.builder()
                //.systemId(1)
                .systemName("ICT")
                .build();
        User user = User.builder()
                //.userId(1)
                .userName("Annalis")
                .system(system)
                .build();
        userRepository.save(user);
    }
}
