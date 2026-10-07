package com.example.employeemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.repository.DepartmentRepository;

import exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Department not found with id: " + id));
    }

    public Department updateDepartment(Long id, Department department) {
        Department existing = getDepartmentById(id);

        existing.setName(department.getName());

        return departmentRepository.save(existing);
    }

    public void deleteDepartment(Long id) {
        Department department = getDepartmentById(id);

        departmentRepository.delete(department);
    }
}