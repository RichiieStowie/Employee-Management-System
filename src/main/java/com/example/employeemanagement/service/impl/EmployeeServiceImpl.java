package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.models.Employee;
import com.example.employeemanagement.models.Salary;
import com.example.employeemanagement.repositories.EmployeeRepository;
import com.example.employeemanagement.repositories.SalaryRepository;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SalaryRepository salaryRepository;


    @Override
    public Employee getEmployeeByEmailAndPassword(String email, String password) {
     return employeeRepository.findEmployeeByEmailAndPassword(email,password).get();
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void CreateNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findEmployee(int id) {
        Optional<Employee>optionalEmployee = employeeRepository.findById(id);
        System.out.println(optionalEmployee);
        System.out.println();
        return  employeeRepository.findById(id).get();
    }

    @Override
    public void paySalaryByEmployeeId(int id) {
        int monthValue= Calendar.getInstance().get(Calendar.MONTH);
        Month monthInView = Month.of(monthValue);
        Optional<Salary>optionalSalary = salaryRepository.findSalaryByMonthInViewAndEmployee_Id(monthInView,id);
        if(optionalSalary.isEmpty()){
            Employee employee= employeeRepository.getById(id);
            Salary salary= new Salary();
            salary.setEmployee(employee);
            salary.setAmountPaid(employee.getSalary());
            salary.setDatePaid(LocalDate.now());
            salary.setMonthInView(monthInView);
            salaryRepository.save(salary);

        }else{
            System.out.println("Salary already paid");
        }
    }
}
