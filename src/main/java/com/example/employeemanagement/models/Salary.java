package com.example.employeemanagement.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;

@Entity
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salaryId;
    private double amountPaid;
    private LocalDate datePaid;
    @Enumerated (EnumType.STRING)
    private Month monthInView;
    @ManyToOne
    private Employee employee;
}
