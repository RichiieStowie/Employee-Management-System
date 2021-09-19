package com.example.employeemanagement.models;

import com.sun.istack.NotNull;
import lombok.Data;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Employee_Data")
@Data

public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column
    private Double  salary;
    @Column(nullable = false)
    private String role;


//    private List<LeaveRequest> leaveRequests;

}
