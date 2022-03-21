package com.jacobo.employeemanager.repo;

import com.jacobo.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeByID(Long id);

    Optional<Employee> findEmployeeByID(Long id);
}
