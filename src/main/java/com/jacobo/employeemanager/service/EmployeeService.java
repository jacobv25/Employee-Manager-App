package com.jacobo.employeemanager.service;

import com.jacobo.employeemanager.exceptions.UserNotFoundException;
import com.jacobo.employeemanager.model.Employee;
import com.jacobo.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeByID(Long id) {
        return employeeRepo.findEmployeeByID(id).orElseThrow(() ->
                new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmploye(Long id) {
        employeeRepo.deleteEmployeeByID(id);
    }
}
