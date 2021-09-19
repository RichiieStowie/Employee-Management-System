package com.example.employeemanagement.repositories;

import com.example.employeemanagement.models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.Optional;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Integer> {
  
    Optional<Salary> findSalaryByMonthInViewAndEmployee_Id(Month month, Integer id);
}
