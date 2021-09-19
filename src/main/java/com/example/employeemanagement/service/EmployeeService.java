package com.example.employeemanagement.service;

import com.example.employeemanagement.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee getEmployeeByEmailAndPassword(String email, String password);
    List<Employee>findAllEmployee();
    void CreateNewEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee findEmployee(int id);
    void paySalaryByEmployeeId(int id);
}
