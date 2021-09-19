package com.example.employeemanagement.service;

import com.example.employeemanagement.models.Employee;
import com.example.employeemanagement.models.Leave;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LeaveService {
    void RequestForLeave(Leave leave);
    Leave displayLeaveStatus(int id);
}
