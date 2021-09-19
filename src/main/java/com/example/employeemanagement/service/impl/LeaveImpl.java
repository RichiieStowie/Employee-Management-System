package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.models.Employee;
import com.example.employeemanagement.models.Leave;
import com.example.employeemanagement.repositories.LeaveRepository;
import com.example.employeemanagement.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveImpl implements LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public void RequestForLeave(Leave leave) {
      leaveRepository.save(leave);
    }
//
//    @Override
//    public List<Leave> findLeavesByStatus_PendingEquals() {
//       return leaveRepository.findLeavesByStatus_PendingEquals();
//    }

    @Override
    public Leave displayLeaveStatus(int id) {
        System.out.println(id);
      return leaveRepository.findLeaveByEmployee_Id(id).get();
    }
}
