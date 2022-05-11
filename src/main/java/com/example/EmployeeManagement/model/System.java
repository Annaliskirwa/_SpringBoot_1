package com.example.EmployeeManagement.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class System {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer systemId;
    private String systemName;
}
