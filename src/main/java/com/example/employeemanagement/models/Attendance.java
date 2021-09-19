package com.example.employeemanagement.models;

import com.example.employeemanagement.models.enums.AttendanceStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;

@Entity
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;
    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalTime localTime;
    @DateTimeFormat(pattern = "yyyy:mm:dd")
    private LocalDate localDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Employee employee;
}
