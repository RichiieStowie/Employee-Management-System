package com.example.employeemanagement.models;

import com.example.employeemanagement.models.enums.Status;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table
@Data
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int LeaveId;
    @Column
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date leaveStartDate;
    @Column
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date leaveEndDate;
    @Enumerated(EnumType.STRING)
    @Column
    private Status status;
    @Column
    private String requestBody;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Employee employee;
}
