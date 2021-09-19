package com.example.employeemanagement.repositories;

import com.example.employeemanagement.models.Attendance;
import com.example.employeemanagement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {
//    @Override
    List<Attendance> findAttendancesByLocalDateBetweenAndEmployee(LocalDate startDate, LocalDate endDate, Employee employee);

    Optional<Attendance> findAttendanceByEmployee_IdAndLocalDate(int id,LocalDate localDate);
}
