package com.example.employeemanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // Save employee under a department
    @PostMapping("/department/{departmentId}")
    public Employee saveEmployee(
            @PathVariable Long departmentId,
            @RequestBody Employee employee) {

        return employeeService.saveEmployee(departmentId, employee);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }

    // Get employees by department
    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(
            @PathVariable Long departmentId) {

        return employeeService.getEmployeesByDepartment(departmentId);
    }

    // Update employee
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return "Employee deleted successfully";
    }
}