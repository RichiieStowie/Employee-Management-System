package com.example.employeemanagement.service;

import com.example.employeemanagement.models.Attendance;
import com.example.employeemanagement.models.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface AttendanceService {
    void markAttendance(Employee employee);
    List<Attendance>  viewAttendanceList(LocalDate startDate, LocalDate endDate, Employee employee);
}
