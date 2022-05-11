package com.example.EmployeeManagement.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    @OneToOne(
            optional = false,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "userSystemId",
            referencedColumnName = "systemId"
    )
    private System system;
}
