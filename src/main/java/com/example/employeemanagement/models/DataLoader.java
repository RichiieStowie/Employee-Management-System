package com.example.employeemanagement.models;

import com.example.employeemanagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void createAdmin(){
        Employee admin= new Employee();
        admin.setFirstName("Odunayo");
        admin.setLastName("tunji");
        admin.setEmail("0dune@gmail.com");
        admin.setRole("Admin");
        admin.setPassword("1234");
        admin.setSalary(20000.00);
        employeeRepository.save(admin);
    }
}
