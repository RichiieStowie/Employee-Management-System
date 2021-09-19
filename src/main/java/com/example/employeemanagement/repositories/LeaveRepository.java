package com.example.employeemanagement.repositories;

import com.example.employeemanagement.models.Leave;
import com.example.employeemanagement.models.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {
    Optional<Leave> findLeaveByEmployee_Id(Integer integer);
    List<Leave>findLeavesByStatus(Status status);

}
