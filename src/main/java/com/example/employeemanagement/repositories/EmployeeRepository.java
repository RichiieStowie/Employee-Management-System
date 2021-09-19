package com.example.employeemanagement.repositories;

import com.example.employeemanagement.dto.EmployeeDto;
import com.example.employeemanagement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee>findEmployeeByEmailAndPassword(String email, String password);
    List<Employee>findEmployeesBy();

    @Override
    Optional<Employee> findById(Integer integer);
}
