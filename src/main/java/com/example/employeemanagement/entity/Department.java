package com.example.employeemanagement.entity;

import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@Entity

@Getter

@Setter

@NoArgsConstructor

@AllArgsConstructor

public class Department {

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;

private String name;

@OneToMany(mappedBy = "department",

cascade = CascadeType.ALL)

private List<Employee> employees;

}
