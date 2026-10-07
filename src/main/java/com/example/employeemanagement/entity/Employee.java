package com.example.employeemanagement.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity

@Getter

@Setter

@NoArgsConstructor

@AllArgsConstructor

public class Employee {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String email;

    private double salary;

    @ManyToOne(cascade = CascadeType.ALL)

    @JoinColumn(name = "department_id")

    private Department department;

}