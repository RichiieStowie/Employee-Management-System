package com.example.employeemanagement.dto;

import lombok.Data;

import java.util.Date;
@Data
public class AttendanceRequestDto {
    private String startDate;
    private String endDate;
    private int employeeId;
}
