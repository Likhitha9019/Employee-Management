package com.example.employeemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.DepartmentRepository;
import com.example.employeemanagement.repository.EmployeeRepository;

import exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    // Save employee under department
    public Employee saveEmployee(Long departmentId, Employee employee) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Department not found with id: " + departmentId));

        employee.setDepartment(department);

        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee not found with id: " + id));
    }

    // Get employees by department
    public List<Employee> getEmployeesByDepartment(Long departmentId) {

        return employeeRepository.findByDepartmentId(departmentId);
    }

    // Update employee
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existing = getEmployeeById(id);

        existing.setName(employee.getName());

        existing.setEmail(employee.getEmail());

        existing.setSalary(employee.getSalary());

        existing.setDepartment(employee.getDepartment());

        return employeeRepository.save(existing);
    }

    // Delete employee
    public void deleteEmployee(Long id) {

        Employee employee = getEmployeeById(id);

        employeeRepository.delete(employee);
    }
}